package dataStructures;

import java.awt.Color;
import java.util.ArrayList;

public class Player {
	
	private boolean ItIsMyTurn = false;
	private ArrayList<Card> cardsDeck = new ArrayList<Card>();
	private Color cardsColor = new Color(0);
	
	public Player(){
		for (int i = 1; i <= 10; i++)
			cardsDeck.add(new Card(i, false, this));
	}

	public boolean IsItMyTurn() {
		return ItIsMyTurn;
	}

	public void setIsItMyTurn(boolean isItMyTurn) {
		this.ItIsMyTurn = isItMyTurn;
	}
	
	public void removeCardFromDeck(int cardValue){
		
		for(int i = 0; i <cardsDeck.size(); i++) 		
			if (cardsDeck.get(i).getValue() == cardValue)
				cardsDeck.remove(i);
		
	}

	public ArrayList<Card> getCards() {
		return cardsDeck;
	}

	public Color getCardsColor() {
		return cardsColor;
	}

	public void setCardsColor(Color cardsColor) {
		this.cardsColor = cardsColor;
	}	

}
