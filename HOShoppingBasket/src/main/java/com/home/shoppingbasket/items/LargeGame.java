package com.home.shoppingbasket.items;

public class LargeGame extends AbstractItem {

	private static final String COST = "20.0";
	private static final String NAME = "LARGE GAME"; 
	
	public LargeGame() {
		super(COST, NAME);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LargeGame other = (LargeGame) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



}
