package dataStructures;

import java.awt.Color;
import java.util.ArrayList;

public class Player {
	
	private boolean ItIsMyTurn = false;
	private ArrayList<Integer> cardsDeck = new ArrayList<Integer>();
	private Color cardsColor = new Color(0);
	
	public Player(){
		for (int i = 1; i <= 10; i++)
			cardsDeck.add(i);
	}

	public boolean IsItMyTurn() {
		return ItIsMyTurn;
	}

	public void setIsItMyTurn(boolean isItMyTurn) {
		this.ItIsMyTurn = isItMyTurn;
	}
	
	public void removeCardFromDeck(int card){
		if(cardsDeck.contains(card))
			cardsDeck.remove((Object)card);
		
	}

	public ArrayList<Integer> getCards() {
		return cardsDeck;
	}

	public Color getCardsColor() {
		return cardsColor;
	}

	public void setCardsColor(Color cardsColor) {
		this.cardsColor = cardsColor;
	}	

}
