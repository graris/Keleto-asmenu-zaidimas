package drawer;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;

import dataStructures.Player;

public class CardsDecksDrawer {
	
	private int margin_top = 10, 
				margin_left = 10,
				cardHeight = 50,
				cardWidth = 50;
	
	public CardsDecksDrawer() { }	
	
	public CardsDecksDrawer(int margin_top, int margin_left, int cardHeight, int cardWidth) {
		this.margin_top = margin_top;
		this.margin_left = margin_left;
		this.cardHeight = cardHeight;
		this.cardWidth = cardWidth;
	}

	public void drawCardsDecks(Graphics g, ArrayList<Player> playersList) {

		drawCardsDecks(g, playersList, 
				   this.margin_top, this.margin_left, this.cardHeight, this.cardWidth);	


	}
	
	public void drawCardsDecks(Graphics g, ArrayList<Player> playersList, 
			   int margin_top, int margin_left) {

		drawCardsDecks(g, playersList, 
				   margin_top, margin_left, this.cardHeight, this.cardWidth);	


	}

	public void drawCardsDecks(Graphics g, ArrayList<Player> playersList, 
							   int margin_top, int margin_left, int cardHeight, int cardWidth) {
		
		for (int i=0; i<playersList.size(); i++) {
			
			for (int j=0; j<playersList.get(i).getCards().size(); j++) {
				
				g.setColor(playersList.get(i).getCardsColor());
				g.fillOval((cardWidth)*(j)+margin_left, cardHeight*(i)+margin_top, cardHeight, cardWidth);
				
				g.setColor(new Color(0));
				g.setFont(new Font("Monospaced", Font.BOLD, 20));
			    FontMetrics fm = g.getFontMetrics();
			    int w = fm.stringWidth(String.valueOf(playersList.get(i).getCards().get(j)));
			    int h = fm.getAscent();

			    g.drawString(String.valueOf(playersList.get(i).getCards().get(j)), ((cardWidth)*(j))+margin_left+cardWidth/2-w/2, (cardHeight*(i))+margin_top+cardHeight/2+h/2-3);
			}
			
			
		}		
		
		
	}

}
