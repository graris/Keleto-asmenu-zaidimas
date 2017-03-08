package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import dataStructures.Player;
import dataStructures.Square;
import drawer.CardsDecksDrawer;
import frames.MainFrame;

public class Main extends JPanel {

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
		
		// Turi buti iskvieciama po kiekvieno perpiesimo
		if(isGameOver(playersList)){
			calculateScore(playersList);
		}

		new CardsDecksDrawer().drawCardsDecks(g, playersList);

	}

	public boolean isGameOver(ArrayList<Player> playersList) {
		for(int i = 0; i < playersList.size(); i++){
			// Zaidimas baigiasi jei visi zaidejai nebeturi korteliu
			if(playersList.get(i).getCards().size() > 0){
				return false;
			}
		}
		return true;
	}

	void calculateScore(ArrayList<Player> playersList) {
		// Iteruojama per visus langelius
		Square[][] squares = new Square[3][3];
		
		int[] totalPlayerScores = new int[3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int[] squareCardScores = new int[3];

				ArrayList<Integer> cards = squares[i][j].getCards();
				ArrayList<Integer> players = squares[i][j].getPlayers();
				
				// Calculate each player's score for this square
				for(int u = 0; u < playersList.size(); i++){
					for(int l = 0; l < players.size(); l++){
						if(u == players.get(l)){
							squareCardScores[u] += cards.get(l);
						}
					}
				}
				
				int[] scoresCopy = squareCardScores;
				// Sort squareCardScores
				Arrays.sort(scoresCopy);
				
				// Check if there is no multiple winners
				if(scoresCopy[0] > scoresCopy[1]){
					// Add one win to player which has the highest square score
					totalPlayerScores[Arrays.asList(squareCardScores).indexOf(scoresCopy[0])] += 1;
				} else {
					// If there are multiple winners assign victory to the first player who place the card
					totalPlayerScores[players.get(0)] += 1;
				}
				
			}
		}
		
		// Display the winner
	}
}
