package model;

public class ConnectorMatchModel {

	private Integer id;
	private Integer rootConnectorId;
	private Integer matchingConnectorId;
	
	public static final String COLNAME_ID = "id";
	public static final String COLNAME_ROOT_CONNECTOR_ID = "root_connector_id";
	public static final String COLNAME_MATCHING_CONNECTOR_ID = "matching_connector_id";
	
	public static final String TABLENAME = "connectors_match";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRootConnectorId() {
		return rootConnectorId;
	}

	public void setRootConnectorId(Integer rootConnectorId) {
		this.rootConnectorId = rootConnectorId;
	}

	public Integer getMatchingConnectorId() {
		return matchingConnectorId;
	}

	public void setMatchingConnectorId(Integer matchingConnectorId) {
		this.matchingConnectorId = matchingConnectorId;
	}
	
	
}
