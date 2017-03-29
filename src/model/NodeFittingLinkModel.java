package model;

public class NodeFittingLinkModel {

	private Integer itemsId;
	private Integer id;
	private Integer connectorsId;
	
	public static final String COLNAME_ID = "id";
	public static final String COLNAME_NODE_ID = "node_id";
	public static final String COLNAME_FITTING_ID = "fitting_id";
	
	public static final String TABLENAME = "node_fitting_link";

	public Integer getItemsId() {
		return itemsId;
	}

	public void setItemsId(Integer itemsId) {
		this.itemsId = itemsId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getConnectorsId() {
		return connectorsId;
	}

	public void setConnectorsId(Integer connectorsId) {
		this.connectorsId = connectorsId;
	}

	
	
	
}
