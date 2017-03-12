package main;

import java.util.ArrayList;
import java.util.Arrays;

import dataStructures.Card;
import dataStructures.Player;
import dataStructures.Square;

public class GameLogicHandler {

	
	private static ArrayList<ArrayList<Square>> board = new ArrayList<ArrayList<Square>>();
	
	private static ArrayList<Player> playersList = new ArrayList<Player>();

	GameLogicHandler(ArrayList<Player> playersList, ArrayList<ArrayList<Square>> board) {
		this.playersList = playersList;
		this.board = board;
	}
	
	  public static boolean isGameOver(ArrayList<Player> playersList) {
	        for(int i = 0; i < playersList.size(); i++){
	            // Zaidimas baigiasi jei visi zaidejai nebeturi korteliu
	            if(playersList.get(i).getCards().size() > 0){
	                return false;
	            }
	        }
	        return true;   
	  }
	  
	  static void calculateScore() {
	      
	        int[] totalPlayerScores = new int[3];
	        
	        for (int i = 0; i < board.size(); i++) {
	            for (int j = 0; j < board.size(); j++) {
	                int[] squareCardScores = new int[playersList.size()];
	                
	                
	                if(board.get(i).get(j).getCards().size() > 0){
	                ArrayList<Card> cards = board.get(i).get(j).getCards();
	                ArrayList<Player> players = board.get(i).get(j).getPlayers();
	                
	                // Calculate each player's score for this square
	                for(int u = 0; u < playersList.size(); u++){
	                    for(int l = 0; l < players.size(); l++){
	                        if(playersList.get(u) == players.get(l)){
	                            squareCardScores[u] += cards.get(l).getValue();
	                        }
	                    }
	                }
	                
	                int[] scoresCopy = new int[playersList.size()];
	                System.arraycopy( squareCardScores, 0, scoresCopy, 0, squareCardScores.length );

	                // Sort squareCardScores
	                Arrays.sort(scoresCopy);
	               
	                // Check if there is no multiple winners
	                if(scoresCopy[1] < scoresCopy[2]){
	                    // Add one win to player which has the highest square score
	                	for(int h = 0; h < playersList.size(); h++){
	                		System.out.println("CARD  : " +squareCardScores[h]);
	                		if(squareCardScores[h] == scoresCopy[2]){
	                			totalPlayerScores[h] += 1;
	                			System.out.println("WINNER : " + h);
	                			break;
	                		}
	                	}
	                } else {
	                    // If there are multiple winners assign victory to the first player who place the card
	                	totalPlayerScores[playersList.indexOf(cards.get(0).getOwner())] += 1;
	                }
	                
	                }
	            }
	        }
	        
	        int[] totalScoresCopy = new int[3];
	        System.arraycopy(totalPlayerScores , 0, totalScoresCopy, 0, totalPlayerScores.length );
	        Arrays.sort(totalScoresCopy);
	        
	        // Display the winner
	       
	        if(totalScoresCopy[1] < totalScoresCopy[2]){
	        	for(int i = 0; i < playersList.size(); i++){
	        		if(totalScoresCopy[2] == totalPlayerScores[i]){
	        			System.out.println("WINNER IS PLAYER: " + i);
	        			break;
	        		}
	        	}
	        } else {
	        	// No winners
	        	System.out.println("NO WINNERS");
	        }
	    }
}
