package model;

public class ConnectorModel {

	private Integer id;
	private String name;
	
	public static final String COLNAME_ID = "id";
	public static final String COLNAME_NAME = "name";
	
	private static final String TABLENAME = "connectors_master";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
