package com.home.shoppingbasket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import com.home.shoppingbasket.items.Item;

public class Basket {

	private HashMap<Item, Integer> itemsInBasket;

	public Basket(HashMap <Item, Integer> items) {
		
		itemsInBasket = items;
		
	}
	
	public void addItem(Item item) {
		
		if(item != null) {
			if(itemsInBasket.containsKey(item)) {
				Integer itemCount = itemsInBasket.get(item);
				itemsInBasket.replace(item, new Integer(itemCount.intValue() +1));
			} else {
				itemsInBasket.put(item, new Integer (1));
			}
		}
	}
	
	public HashMap <Item, Integer> getItemsAndItemCount() {
		return itemsInBasket;
	}
	
	public ArrayList<Item> getBasketItems() {
		
		ArrayList<Item> itemList = new ArrayList<>();
		
		for (Item itemType : itemsInBasket.keySet()) {
			for (int i=0; i < itemsInBasket.get(itemType); i++) {
				itemList.add(itemType);
			}
		}
		
		return itemList;
				
	}
	
	public int getNumberOfItem(Item item) {
		
		int numItems = 0;
		
		if(itemsInBasket.containsKey(item)) {
			numItems = itemsInBasket.get(item).intValue();
		}
		
		return numItems;
	}
	
	public BigDecimal getTotalCost() {
		BigDecimal totalCost = BigDecimal.ZERO;
		
		for (Item itemType : itemsInBasket.keySet()) {
			
			int itemCount = itemsInBasket.get(itemType).intValue();
			BigDecimal itemCost = new BigDecimal(itemType.getCost()).multiply(new BigDecimal(itemCount));
			
			
			
			totalCost = totalCost.add(itemCost);
		}
		
		return totalCost;
	}
}
