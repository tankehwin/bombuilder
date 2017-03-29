package model;

public class NodeFittingLinkModel {

	private Integer nodeId;
	private Integer id;
	private Integer fittingId;
	
	public static final String COLNAME_ID = "id";
	public static final String COLNAME_NODE_ID = "node_id";
	public static final String COLNAME_FITTING_ID = "fitting_id";
	
	public static final String TABLENAME = "node_fitting_link";

	public Integer getNodeId() {
		return nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFittingId() {
		return fittingId;
	}

	public void setFittingId(Integer fittingId) {
		this.fittingId = fittingId;
	}

}
