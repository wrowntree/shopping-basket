package com.home.shoppingbasket.items;

public class SmallToy extends AbstractItem {

	private static final String COST = "5.99";
	private static final String NAME = "SMALL TOY"; 
	
	public SmallToy() {
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
		SmallToy other = (SmallToy) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


}
