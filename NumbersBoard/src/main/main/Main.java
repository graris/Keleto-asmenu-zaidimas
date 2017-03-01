package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import dataStructures.Player;
import drawer.CardsDecksDrawer;
import frames.MainFrame;

public class Main extends JPanel{
	
	public static void main(String[] args) {
		new MainFrame();
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		super.paintComponents(g);
		
		ArrayList<Player> playersList = new ArrayList<Player>();
		
		playersList.add(new Player());
		playersList.add(new Player());
		playersList.add(new Player());
		
		playersList.get(0).setCardsColor(Color.lightGray);
		playersList.get(1).setCardsColor(Color.green);
		playersList.get(2).setCardsColor(Color.orange);
		
		playersList.get(0).removeCardFromDeck(6);
		
		playersList.get(2).removeCardFromDeck(1);
		playersList.get(2).removeCardFromDeck(9);
		playersList.get(2).removeCardFromDeck(10);
		
		new CardsDecksDrawer().drawCardsDecks(g, playersList);
			
	}
	
	

}
