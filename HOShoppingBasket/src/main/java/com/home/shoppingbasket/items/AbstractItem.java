package com.home.shoppingbasket.items;

public abstract class AbstractItem implements Item{
	
	protected final String cost;
	protected final String name; 

	
	public AbstractItem(String cost, String name) {
		this.cost = cost;
		this.name = name;
	}

	@Override
	public String getCost() {
		return cost;
	}

	public String getName() {
		return name;
	}

}