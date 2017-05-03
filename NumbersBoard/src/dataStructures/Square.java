package dataStructures;

import java.util.ArrayList;

/**
 * Square is responsible for storing card information for one specific square
 */
public class Square {
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	private ArrayList<Player> players = new ArrayList<Player>();
	
	/**
	 * Adds new Player card
	 */
	public void addPlayerCard(Card card){
		cards.add(card);
		players.add(card.getOwner());
	}

	/**
	 * Retrieve card list
	 */
	public ArrayList<Card> getCards() {
		return cards;
	}

	/**
	 * Retrieve player list
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * Check if card list is empty
	 */
	public boolean isEmpty() {
		
		if(cards.size() == 0)
			return true;
				else
					return false;
	}

}
