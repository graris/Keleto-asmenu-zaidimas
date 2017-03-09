package drawer;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import dataStructures.Player;

public class TableDrawer {

	private int[][] cardsInACell = new int[3][3];
	
	public void drawTable(Graphics g){
		g.drawRect(600, 10, 300, 300);
		g.drawLine(700, 10, 700, 310);
		g.drawLine(800, 10, 800, 310);
		g.drawLine(600, 110, 900, 110);
		g.drawLine(600, 210, 900, 210);
	}

	//Returns false if the cell is full
	public boolean drawCardInTable(Graphics g, int tableCellX, int tableCellY, Player player, int cardNumber){
		if(cardsInACell[tableCellX][tableCellY] <= 3){
				
		int addX = 0;
		int addY = 0;
		
		if(cardsInACell[tableCellX][tableCellY] == 1){
			addX = 50;
		}
		else if(cardsInACell[tableCellX][tableCellY] == 2){
			addY = 50;
		}
		else if (cardsInACell[tableCellX][tableCellY] == 3){
			addX = 50;
			addY = 50;
		}
			
		g.setColor(player.getCardsColor());
		g.fillOval(600 + (100 * tableCellX + addX), 10 + (100 * tableCellY + addY), 50, 50);
		
		g.setColor(new Color(0));
		g.setFont(new Font("Monospaced", Font.BOLD, 20));
	    FontMetrics fm = g.getFontMetrics();
	    int w = fm.stringWidth(String.valueOf(cardNumber));
	    int h = fm.getAscent();

	    g.drawString(String.valueOf(cardNumber), (600 + (100 * tableCellX + addX))+50/2-w/2, (10 + (100 * tableCellY + addY))+50/2+h/2-3);
	    cardsInACell[tableCellX][tableCellY]++;
	    return true;
		}
		else
			return false;
	}
}
