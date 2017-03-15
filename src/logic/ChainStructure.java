package logic;

import java.util.ArrayList;

import model.ChainModel;

public class ChainStructure {

	private ChainModel chainObject;
	private ArrayList<ChainStructure> childObjectList;
	
	public ChainStructure() {
		// this class holds each individual link in the working chain. it contains the chainlink itself as well as any children
		this.chainObject = new ChainModel();
		this.childObjectList = new ArrayList<ChainStructure>();
	}

	public ChainModel getChainObject() {
		return chainObject;
	}

	public void setChainObject(ChainModel chainObject) {
		this.chainObject = chainObject;
	}

	public ArrayList<ChainStructure> getChildObjectList() {
		return childObjectList;
	}

	public void setChildObjectList(ArrayList<ChainStructure> childObjectList) {
		this.childObjectList = childObjectList;
	}
	
	
}
