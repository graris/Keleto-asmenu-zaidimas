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
	
	/**
	 * Get value Card holds
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Set Card value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * Check if Card is active
	 */
	public boolean isActive() {
		return active;
	}
	
	/**
	 * Set Card to active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/**
	 * Get Card owner
	 */
	public Player getOwner() {
		return owner;
	}

	/**
	 * Set Card owner
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}

}
