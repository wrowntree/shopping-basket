package com.home.shoppingbasket;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import com.home.shoppingbasket.items.Item;
import com.home.shoppingbasket.items.LargeGame;
import com.home.shoppingbasket.items.SmallToy;

public class BasketTest {

	private Basket basket;
	
	@Before
    public void setup() {
		
		basket = new Basket(new HashMap<Item, Integer>());
		
	}
	
	@Test
	public void shouldAddItemsToBasketAndReturnCorrectItemsAndCost() {
		
		basket.addItem(new SmallToy());

		assertThat(basket.getTotalCost(), is(new BigDecimal("5.99")));
		
		basket.addItem(new LargeGame());
		
		assertThat(basket.getBasketItems().size(), is(2));
		assertThat(basket.getTotalCost(), is(new BigDecimal("25.99")));
	}

	@Test
	public void shouldBeAbleToAddMultipleItemsAndReturnTheCorrectTotalCost() {
		
		basket.addItem(new SmallToy());
		basket.addItem(new SmallToy());
		
		assertThat(basket.getTotalCost(), is(new BigDecimal("11.98")));
	}
	
	@Test
	public void shouldReturnCorrectNumberOfItems() {
		
		basket.addItem(new SmallToy());
		basket.addItem(new SmallToy());
		basket.addItem(new SmallToy());
		basket.addItem(new SmallToy());
		basket.addItem(new LargeGame());
		
		ArrayList<Item> basketItems = basket.getBasketItems();
		
		
		assertThat(basketItems.size(), is(5));
		
		assertThat(basket.getNumberOfItem(new SmallToy()), is(4));
		assertThat(basket.getNumberOfItem(new LargeGame()), is(1));

	}
	
	@Test
	public void shouldIgnoreAttemptToAddNullItem() {

		basket.addItem(new SmallToy());
		basket.addItem(null);
		basket.addItem(new LargeGame());
		
		ArrayList<Item> basketItems = basket.getBasketItems();
		
		
		assertThat(basketItems.size(), is(2));
		
		assertThat(basket.getNumberOfItem(new SmallToy()), is(1));
		assertThat(basket.getNumberOfItem(new LargeGame()), is(1));
	}
	
	@Test
	public void shouldReturnZeroIfItemIsNotInBasket() {
		
		basket.addItem(new SmallToy());
		
		assertThat(basket.getNumberOfItem(new LargeGame()), is(0));
		
	}
}
