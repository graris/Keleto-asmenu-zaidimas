package dataStructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Square {

	private ArrayList<Integer> cards = new ArrayList<Integer>();
	private ArrayList<Integer> players = new ArrayList<Integer>();
	
	public void addPlayerCard(int cardValue, int playerIndex){
		cards.add(cardValue);
		players.add(playerIndex);
	}

	public ArrayList<Integer> getCards() {
		return cards;
	}

	public ArrayList<Integer> getPlayers() {
		return players;
	}

}
