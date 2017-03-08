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
import userInputsListener.ChosenCardListener;

public class Main extends JPanel{
	
	private ArrayList<Player> playersList = new ArrayList<Player>();
	
	private	CardsDecksDrawer cdd = new CardsDecksDrawer(); 
	
	public static void main(String[] args) {
		new MainFrame();
		//new Main();
	
	}
	
	public Main() {
		
			
		
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
		
		playersList.get(0).setIsItMyTurn(true);
		
		this.addMouseListener(new ChosenCardListener(this, playersList, cdd.getMargin_top(), 
													 cdd.getMargin_left(), cdd.getCardHeight(), 
													 cdd.getCardWidth()));
		this.setFocusable(true);
		
		
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		super.paintComponents(g);
		
		cdd.drawCardsDecks(g, playersList);
	
			
	}
	
	

}
