package dataStructures;

public class Card {
	
	private int value;
	private boolean active;
	private Player owner;
	
	public Card(int value, boolean active, Player owner) {
		
		this.value = value;
		this.active = active;
		this.owner = owner;
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

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

}
