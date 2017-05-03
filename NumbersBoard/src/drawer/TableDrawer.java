package drawer;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;

import dataStructures.Square;

public class TableDrawer {
	
	/**
	 * Draws table bounds
	 */
	public void drawTable(Graphics g){
		
		g.setColor(Color.BLACK);
		g.drawRect(600, 10, 300, 300);
		g.drawLine(700, 10, 700, 310);
		g.drawLine(800, 10, 800, 310);
		g.drawLine(600, 110, 900, 110);
		g.drawLine(600, 210, 900, 210);
	}

	/**
	 * Draws all Cards in a table
	 */
	public void drawCardsInTable(Graphics g, ArrayList<ArrayList<Square>> board){		
		
		int tableCellX = 0;
		int tableCellY = 0;
		
		int cardNumber = 0;
		
		for(int i=0; i<board.size(); i++) {
			
			for(int j=0; j<board.get(0).size(); j++) {
				
				if(!board.get(i).get(j).isEmpty()) {
					
					for (int k=0; k<board.get(i).get(j).getCards().size(); k++) {
						
						tableCellX = j;
						tableCellY = i;
						cardNumber = board.get(i).get(j).getCards().get(k).getValue();
						
						if(k <= 3) {
								
							int addX = 0;
							int addY = 0;
							
							if(k == 1){
								addX = 50;
							}
							else if(k == 2){
								addY = 50;
							}
							else if (k == 3){
								addX = 50;
								addY = 50;
							}
								
							g.setColor(board.get(i).get(j).getCards().get(k).getOwner().getCardsColor());
							g.fillOval(600 + (100 * tableCellX + addX), 10 + (100 * tableCellY + addY), 50, 50);
							
							g.setColor(new Color(0));
							g.setFont(new Font("Monospaced", Font.BOLD, 20));
						    FontMetrics fm = g.getFontMetrics();
						    int w = fm.stringWidth(String.valueOf(cardNumber));
						    int h = fm.getAscent();
					
						    g.drawString(String.valueOf(cardNumber), (600 + (100 * tableCellX + addX))+50/2-w/2, (10 + (100 * tableCellY + addY))+50/2+h/2-3);	
						}
						
					}			
					
				}
				
			}			
						
		}
		
	}
}
