package dataStructures;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Contains information about the player
 */
public class Player {
	
	private boolean ItIsMyTurn = false;
	private ArrayList<Card> cardsDeck = new ArrayList<Card>();
	private Color cardsColor = new Color(0);
	
	public Player(){
		for (int i = 1; i <= 10; i++)
			cardsDeck.add(new Card(i, false, this));
	}


	/**
	 * Check if it's my turn
	 */
	public boolean IsItMyTurn() {
		return ItIsMyTurn;
	}

	/**
	 * Change turn value
	 */
	public void setIsItMyTurn(boolean isItMyTurn) {
		this.ItIsMyTurn = isItMyTurn;
	}
	
	/**
	 * Removes card from deck 
	 */
	public void removeCardFromDeck(int cardValue){
		
		for(int i = 0; i <cardsDeck.size(); i++) 		
			if (cardsDeck.get(i).getValue() == cardValue)
				cardsDeck.remove(i);
		
	}

	/**
	 * Retrieve Card list
	 */
	public ArrayList<Card> getCards() {
		return cardsDeck;
	}

	/**
	 * Retrieve color list
	 */
	public Color getCardsColor() {
		return cardsColor;
	}

	/**
	 * Set color list
	 */
	public void setCardsColor(Color cardsColor) {
		this.cardsColor = cardsColor;
	}	

}
