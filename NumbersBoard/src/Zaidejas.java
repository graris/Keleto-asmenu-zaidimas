package main;

import java.util.ArrayList;

public class Zaidejas {
	
	private boolean arManoEile = false;
	private ArrayList<Integer> kortos = new ArrayList<Integer>();
	
	public Zaidejas(){
		for (int i = 1; i <= 10; i++)
			kortos.add(i);
	}

	public boolean getArManoEile() {
		return arManoEile;
	}

	public void setArManoEile(boolean arManoEile) {
		this.arManoEile = arManoEile;
	}
	
	public void pasalintiKortaIsListo(int korta){
		if(kortos.contains(korta))
			kortos.remove(korta);
	}

	public ArrayList<Integer> getKortos() {
		return kortos;
	}
	
}
