package model;

public class ConnectorItemLinkModel {

	private Integer itemsId;
	private Integer id;
	private Integer direction;
	private Integer connectorsId;
	
	public static final String COLNAME_ID = "id";
	public static final String COLNAME_DIRECTION = "direction";
	public static final String COLNAME_ITEMS_ID = "items_id";
	public static final String COLNAME_CONNECTORS_ID = "connectors_id";
	
	public static final String TABLENAME = "connectors_items_link";

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

	public Integer getDirection() {
		return direction;
	}

	public void setDirection(Integer direction) {
		this.direction = direction;
	}

	public Integer getConnectorsId() {
		return connectorsId;
	}

	public void setConnectorsId(Integer connectorsId) {
		this.connectorsId = connectorsId;
	}
	
	
}
