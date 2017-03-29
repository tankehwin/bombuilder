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
	private String category; // further classification
	private String description; // additional description
	
	private static final String ITEM_CLASS_NODE = "node";
	private static final String ITEM_CLASS_FITTING = "fitting";
	
	public static final String COLNAME_ID = "id";
	public static final String COLNAME_PART_NUMBER = "part_number";
	public static final String COLNAME_ITEM_CLASS = "item_class";
	public static final String COLNAME_CATEGORY = "category";
	public static final String COLNAME_DESCRIPTION = "description";
	
	public static final String TABLENAME = "items_master";
		
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

	// only nodes have categories. fittings will have blank string for category
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
