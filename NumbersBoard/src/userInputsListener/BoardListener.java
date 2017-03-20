package userInputsListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import dataStructures.Card;
import dataStructures.Player;
import dataStructures.Square;
import main.GameLogicHandler;

public class BoardListener extends MouseAdapter{	
	
	private JPanel panel;
	
	private ArrayList<Player> playersList;
	
	private ArrayList<ArrayList<Square>> board;
	
	private GameLogicHandler glh;
	
	private int margin_top = 10, 
				margin_left = 600,
				squareHeight = 100,
				squareWidth = 100;
	
	public BoardListener(JPanel panel, ArrayList<Player> playersList, ArrayList<ArrayList<Square>> board,
						 GameLogicHandler glh, int margin_top, int margin_left, int cardHeight, 
						 int cardWidth) {
		
		this.panel = panel;
		this.playersList = playersList;
		this.glh = glh;
		
		this.margin_top = margin_top; 
		this.margin_left = margin_left;
		this.squareHeight = cardHeight;
		this.squareWidth = cardWidth;
	}
	
	public BoardListener(JPanel panel, ArrayList<Player> playersList, ArrayList<ArrayList<Square>> board,
			GameLogicHandler glh) {

		this.panel = panel;
		this.playersList = playersList;
		this.board = board;
		this.glh = glh;
		
	}	
	@Override
	public void mouseClicked(MouseEvent evt) {
		
		
		int x = evt.getX(),
			y = evt.getY();
		
		int selectedSquareX = (x-margin_left)/squareWidth,
		    selectedSquareY = (y-margin_top)/squareHeight;
		
		try {
			
			for (int i=0; i<playersList.size(); i++) {
				
				for (Card card : playersList.get(i).getCards()) {
					
					if ((board.get(selectedSquareY).get(selectedSquareX).getCards().size() < 4)
						&&(card.isActive())) {
						
						board.get(selectedSquareY).get(selectedSquareX).addPlayerCard(card);
						
						playersList.get(i).setIsItMyTurn(false);
						if(i == playersList.size() - 1)
							playersList.get(0).setIsItMyTurn(true);
						else
							playersList.get(i + 1).setIsItMyTurn(true);
						
						
						playersList.get(i).removeCardFromDeck(card.getValue());
						
						glh.checkIfGameIsOver(playersList);
						
						
						
					}
					
				}
			}
			
		} catch(Exception ex) {
			
			// area outside board is selected
		}

		panel.repaint();

		
	}
}
