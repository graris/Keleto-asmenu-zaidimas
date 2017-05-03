package userInputsListener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import dataStructures.Card;
import dataStructures.Player;

public class ChosenCardListener extends MouseAdapter{
	
	private JPanel panel;
	
	private ArrayList<Player> playersList;
	
	private int margin_top = 10, 
				margin_left = 10,
				cardHeight = 50,
				cardWidth = 50;
	
	public ChosenCardListener(JPanel panel, ArrayList<Player> playersList,
							  int margin_top, int margin_left, int cardHeight, int cardWidth) {
		
		this.panel = panel;
		this.playersList = playersList;
		
		this.margin_top = margin_top; 
		this.margin_left = margin_left;
		this.cardHeight = cardHeight;
		this.cardWidth = cardWidth;
	}
	
	/**
	 * Responds to mouse clicks on cards
	 */
	@Override
	public void mouseClicked(MouseEvent evt) {
		int x = evt.getX();
		int y = evt.getY();
		
		int currentPlayerID = getCurrentPlayerID();
		
		int selectedCard = (x-margin_left)/cardWidth;

		if ( ((y-margin_top)/cardHeight == currentPlayerID)
				&&((x-margin_left)/cardWidth <= playersList.get(currentPlayerID).getCards().size())){
			
			for (Player player : playersList)
				for (Card card : player.getCards()) 
					card.setActive(false);
			
				
			playersList.get(currentPlayerID).getCards().get(selectedCard).setActive(true);
				
		}

		panel.repaint();

		
	}


	private int getCurrentPlayerID() {
		for (int i=0; i<playersList.size(); i++) 
			if (playersList.get(i).IsItMyTurn()) return i;
			
		return -1;
	}

}
