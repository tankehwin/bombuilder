package logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.ItemModel;
import model.NodeFittingLinkModel;

public class ChainManager {

	private ArrayList<ItemModel> itemList;
	private ArrayList<NodeFittingLinkModel> fittingList;

	public ChainManager() {
		this.itemList = new ArrayList<ItemModel>();
		this.fittingList = new ArrayList<NodeFittingLinkModel>();
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
				break; // remove only one instance of it
			}
		}
	}
	
	public void addFitting(Integer itemId, Connection conn) throws Exception {
		ArrayList<NodeFittingLinkModel> fittings = getFittingByItemId(itemId, conn);
		for (NodeFittingLinkModel fittingObj : fittings) {
			this.fittingList.add(fittingObj);
		}	
	}
	
	public void clearFittings() {
		this.fittingList = new ArrayList<NodeFittingLinkModel>();
	}
	
	public void removeFitting(Integer itemId, Connection conn) throws Exception {
		ArrayList<NodeFittingLinkModel> fittings = getFittingByItemId(itemId, conn);
		for(NodeFittingLinkModel fittingObj : fittings) {
			for(NodeFittingLinkModel temp : this.fittingList) {
				if(temp.getId().intValue()==fittingObj.getId().intValue()) {
					this.fittingList.remove(temp);
					break; // remove only one instance of it
				}
			}
		}
	}
	
	private ItemModel getItemByPartNumber(String partNumber, Connection conn) throws Exception {
		ItemModel result = null;
		
		String sql = "SELECT * FROM " + ItemModel.TABLENAME + " WHERE " + ItemModel.COLNAME_PART_NUMBER + " = '" + partNumber + "' ORDER BY " + ItemModel.COLNAME_PART_NUMBER + ";";
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

	private ArrayList<NodeFittingLinkModel> getFittingByItemId(Integer itemId, Connection conn) throws Exception {
		ArrayList<NodeFittingLinkModel> result = null;
		
		String sql = "SELECT * FROM " + NodeFittingLinkModel.TABLENAME + " WHERE " + NodeFittingLinkModel.COLNAME_NODE_ID + " = '" + itemId + "' ORDER BY " + NodeFittingLinkModel.COLNAME_NODE_ID + ";";
		Statement st = conn.createStatement();
//		System.out.println(sql);
		ResultSet rs = st.executeQuery(sql);
		result = new ArrayList<NodeFittingLinkModel>();
		while(rs.next()) {
			NodeFittingLinkModel temp = new NodeFittingLinkModel();
			temp.setNodeId(new Integer(rs.getInt(NodeFittingLinkModel.COLNAME_NODE_ID)));
			temp.setFittingId(new Integer(rs.getInt(NodeFittingLinkModel.COLNAME_ID)));
			temp.setId(new Integer(rs.getInt(NodeFittingLinkModel.COLNAME_FITTING_ID)));
			result.add(temp);
		}	
		
		return result;
	}
	
	public ArrayList<ItemModel> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<ItemModel> itemList) {
		this.itemList = itemList;
	}

	public ArrayList<NodeFittingLinkModel> getFittingList() {
		return fittingList;
	}

	public void setFittingList(ArrayList<NodeFittingLinkModel> fittingList) {
		this.fittingList = fittingList;
	}
	
	
}
