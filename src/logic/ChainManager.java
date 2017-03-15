package logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.ChainModel;
import model.ChainModel;

public class ChainManager {

	public ChainStructure initChain() {
		// initialise a new chain
		ChainStructure chainObj = new ChainStructure();
		
		return chainObj;
	}
	
	public void regenerateChain(Integer loginId, Connection conn) throws Exception {
		// find root chain by login_id - root chain has parent_id of 0. if there is more than 1 such object, throw error
		ArrayList<ChainModel> rootResult = getObjectByParentIdLoginId(0, loginId, conn);
		if(rootResult.size() > 1) {
			throw new Exception("ERROR: more than 1 root object detected for loginId " + loginId);
		}
		ChainModel rootChain = rootResult.get(0);
		// feed root chain into recursive function, get full result
		ArrayList<ChainStructure> chainResult = getNextChain(rootChain, conn);
		
		// test-only: display results inside chainResult
		printStructure(chainResult.get(0), 0);
	}
		
	private void printStructure(ChainStructure parent, int level) throws Exception {
		for(int k = 0; k < level; k++) {
			System.out.print("    ");
		}
		System.out.println(parent.getChainObject().getLabel() + " (Level " + level + ")");
		if(parent.getChildObjectList().size() > 0) {
			for(int i = 0; i < parent.getChildObjectList().size(); i++) {
				printStructure(parent.getChildObjectList().get(i), level + 1);
			}
		}
	}
	
	private ArrayList<ChainStructure> getNextChain(ChainModel parent, Connection conn) throws Exception {
		ArrayList<ChainStructure> result = new ArrayList<ChainStructure>();
		// return all chain objects with matching parent.parentId and parent.loginId
		ArrayList<ChainModel> childResult = getObjectByParentIdLoginId(parent.getId(), parent.getLoginId(), conn);
		// in a loop, call this function again recursively for each returned chain object assuming it has child objects
		// if no child object, return just the parent with empty child arraylist
		if( childResult.size() > 0) {
			
			ChainStructure newStruc = new ChainStructure();
			newStruc.setChainObject(parent);
			
			for(int i = 0; i < childResult.size(); i++) {
				newStruc.getChildObjectList().add(getNextChain(childResult.get(i), conn).get(0));
			}
			result.add(newStruc);
		}
		else {
			ChainStructure chainStruc = new ChainStructure();
			chainStruc.setChainObject(parent);

			result.add(chainStruc);
		}
		
		return result;
	}
	
	public static void insertObject(ChainModel value, Connection conn) throws Exception {
		String sql = "INSERT INTO " + ChainModel.TABLENAME + "(" + 
				ChainModel.COLNAME_LABEL + ", " +
				ChainModel.COLNAME_ITEMS_ID + ", " +
				ChainModel.COLNAME_PARENT_ID + ", " +
				ChainModel.COLNAME_LOGIN_ID + 
				")" +
				" VALUES ('" +
				value.getLabel().trim() + "', " +
				value.getItemsId() + ", " +
				value.getParentId() + ", " +
				value.getLoginId() + 
				");";
		Statement st = conn.createStatement();
		//System.out.println(sql);
		st.executeUpdate(sql);

	}
	
	public static void clearTable(Connection conn) throws Exception {
		String sql = "DELETE FROM " + ChainModel.TABLENAME + ";";
		Statement st = conn.createStatement();
		// System.out.println(sql);
		st.executeUpdate(sql);
	}
		
	public static ArrayList<ChainModel> getObjectByParentIdLoginId(Integer parentId, Integer loginId, Connection conn) throws Exception {
		
		String sql = "SELECT * FROM " + ChainModel.TABLENAME + " WHERE " + ChainModel.COLNAME_PARENT_ID + " = " +
				parentId + " AND " + ChainModel.COLNAME_LOGIN_ID + " = " + loginId + " ORDER BY " + ChainModel.COLNAME_ITEMS_ID + ";";
		Statement st = conn.createStatement();
//		System.out.println(sql);
		ResultSet rs = st.executeQuery(sql);
		ArrayList<ChainModel> result = new ArrayList<ChainModel>();
		ChainModel chainObj = null;
		while(rs.next()) {
			chainObj = new ChainModel();
			
			chainObj.setId(new Integer(rs.getInt(ChainModel.COLNAME_ID)));
			chainObj.setParentId(new Integer(rs.getInt(ChainModel.COLNAME_PARENT_ID)));
			chainObj.setLoginId(new Integer(rs.getInt(ChainModel.COLNAME_LOGIN_ID)));
			chainObj.setItemsId(new Integer(rs.getInt(ChainModel.COLNAME_ITEMS_ID)));
			chainObj.setLabel(rs.getString(ChainModel.COLNAME_LABEL));
			result.add(chainObj);
		}	
		return result;
	}
}
