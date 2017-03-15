package model;

public class ChainModel {

	private Integer itemsId;
	private Integer id;
	private String label;
	private Integer parentId;
	private Integer loginId;
	
	public static final String COLNAME_ID = "id";
	public static final String COLNAME_LABEL = "label";
	public static final String COLNAME_ITEMS_ID = "items_id";
	public static final String COLNAME_PARENT_ID = "parent_id";
	public static final String COLNAME_LOGIN_ID = "login_id";
	
	public static final String TABLENAME = "working_chain";

	public Integer getItemsId() {
		return itemsId;
	}

	public void setItemsId(Integer itemId) {
		this.itemsId = itemId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}
	
	
}
