package dataStructures;

import java.util.ArrayList;

public class Square {
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	private ArrayList<Player> players = new ArrayList<Player>();
	
	public void addPlayerCard(Card card){
//		boolean alreadyExists = false;
//		for (int i=0; i<cards.size();i++) 
//			if () {
//				
//				
//				alreadyExists = true;
//			}
//		
//		if () {
		cards.add(card);
		players.add(card.getOwner());
//		}
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public ArrayList<Player> getPlayers() {
		return players;
}

	public boolean isEmpty() {
		
		if(cards.size() == 0)
			return true;
				else
					return false;
	}

}
