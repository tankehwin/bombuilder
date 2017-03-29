package logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.ItemModel;

public class ChainManager {

	private ArrayList<ItemModel> itemList;

	public ChainManager() {
		this.itemList = new ArrayList<ItemModel>();
	}
	
	public void addItem(String partNumber, Connection conn) throws Exception {
		this.itemList.add(getItemByPartNumber(partNumber, conn));
	}
	
	public void clearItems() {
		this.itemList = new ArrayList<ItemModel>();
	}
	public void removeItem(String partNumber) {
		for(int i = 0; i < this.itemList.size(); i++) {
			if(this.itemList.get(i).getPartNumber().equals(partNumber)) {
				this.itemList.remove(i);
			}
		}
	}
	
	private ItemModel getItemByPartNumber(String partNumber, Connection conn) throws Exception {
		ItemModel result = null;
		
		String sql = "SELECT * FROM " + ItemModel.TABLENAME + " WHERE part_number = '" + partNumber + "' ORDER BY " + ItemModel.COLNAME_PART_NUMBER + ";";
		Statement st = conn.createStatement();
//		System.out.println(sql);
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			result = new ItemModel();
			result.setPartNumber(rs.getString(ItemModel.COLNAME_PART_NUMBER));
			result.setItemClass(rs.getString(ItemModel.COLNAME_ITEM_CLASS));
			result.setDescription(rs.getString(ItemModel.COLNAME_DESCRIPTION));
			result.setId(new Integer(rs.getInt(ItemModel.COLNAME_ID)));
		}	
		
		return result;
	}
}
