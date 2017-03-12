package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import dataStructures.Card;
import dataStructures.Player;
import dataStructures.Square;
import drawer.CardsDecksDrawer;
import drawer.TableDrawer;
import frames.MainFrame;
import userInputsListener.BoardListener;
import userInputsListener.ChosenCardListener;

public class Main extends JPanel{
	
	private ArrayList<ArrayList<Square>> board = new ArrayList<ArrayList<Square>>();
	
	private ArrayList<Player> playersList = new ArrayList<Player>();
	
	private	CardsDecksDrawer cdd = new CardsDecksDrawer(); 	
	
	private TableDrawer td = new TableDrawer();
	
	private GameLogicHandler gameLogicHandler;
	
	private boolean gameIsOver = false;
	
	public static void main(String[] args) {
		new MainFrame();
		//new Main();
	
	}
	
	public Main() {
		
		for(int i=0;i<3;i++) {
			
			board.add(new ArrayList<Square>());
			for(int j=0;j<3;j++) {
				
				board.get(i).add(new Square());
			}
		}	
		
		playersList.add(new Player());
		playersList.add(new Player());
		playersList.add(new Player());
		
		playersList.get(0).setCardsColor(Color.blue);
		playersList.get(1).setCardsColor(Color.green);
		playersList.get(2).setCardsColor(Color.orange);
		
		playersList.get(0).removeCardFromDeck(6);
		
		playersList.get(2).removeCardFromDeck(1);
		playersList.get(2).removeCardFromDeck(9);
		playersList.get(2).removeCardFromDeck(10);
		
		playersList.get(0).setIsItMyTurn(true);
		
		
		
		this.addMouseListener(new BoardListener(this, playersList, board));
		
		this.addMouseListener(new ChosenCardListener(this, playersList, cdd.getMargin_top(), 
													 cdd.getMargin_left(), cdd.getCardHeight(), 
													 cdd.getCardWidth()));
		this.setFocusable(true);
		
		gameLogicHandler = new GameLogicHandler(playersList, board);

		//drawer.drawCardInTable(g, 1, 1, playersList.get(2), 6);
		

			
	}
	
	@Override
	public void paint(Graphics g) {

		super.paintComponents(g);
		
		if(!gameIsOver){
		
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, 1000, 400);
	
		td.drawTable(g);
		
		//td.drawCardInTable(g, 1, 1, playersList.get(0), 10);
//		td.drawCardInTable(g, 0, 1, playersList.get(1), 10);
		//td.drawCardInTable(g, 1, 2, playersList.get(1), 8);
		td.drawCardsInTable(g, board);
		
		cdd.drawCardsDecks(g, playersList);
		
		
		} else {
			gameLogicHandler.calculateScore();
		}
		
		
		gameIsOver = gameLogicHandler.isGameOver(playersList);
			
	}


}
