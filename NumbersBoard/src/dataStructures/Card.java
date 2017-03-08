package dataStructures;

public class Card {
	
	private int value;
	private boolean active;
	
	public Card(int value, boolean active) {
		
		this.value = value;
		this.active = active;
	}	
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

}
