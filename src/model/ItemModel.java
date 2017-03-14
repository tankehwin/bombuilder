package model;

import java.util.ArrayList;

/**
 * @author tankehwin
 *
 */
public class ItemModel {

	private Integer id;
	private String partNumber; // name of part
	private String itemClass; // type of part: node,fitting
	private String description; // additional description
	
	private ArrayList fittingsCol;
	
	public static final String ITEM_CLASS_NODE = "node";
	public static final String ITEM_CLASS_FITTING = "fitting";
	
	
	public ItemModel(Integer id, String partNumber, String itemClass, String description, ArrayList fittingsCol) {
		super();
		this.id = id;
		this.partNumber = partNumber;
		this.itemClass = itemClass;
		this.description = description;
		this.fittingsCol = fittingsCol;
	}
	
	public ItemModel() {
		this.id = 0;
		this.partNumber = "";
		this.itemClass = "";
		this.description = "";
		this.fittingsCol = new ArrayList();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getItemClass() {
		return itemClass;
	}
	public void setItemClass(String itemClass) {
		this.itemClass = itemClass;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
