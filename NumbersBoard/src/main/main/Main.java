package main;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		//zaidejo klases logikos pvz
		Zaidejas zaidejas1 = new Zaidejas();
		zaidejas1.setArManoEile(true);
		Zaidejas zaidejas2 = new Zaidejas();
		Zaidejas zaidejas3 = new Zaidejas();
		
		ArrayList<Zaidejas> zaidejai = new ArrayList<Zaidejas>();
		zaidejai.add(zaidejas1);
		zaidejai.add(zaidejas2);
		zaidejai.add(zaidejas3);
		
		//Pirmas ciklas tik pvz(turetu buti zaidimo pagrindinis ciklas koks nors)
		for (int i = 0; i < 10; i ++){
			for (int j = 0; j < 3; j++){
				if(zaidejai.get(j).getArManoEile()){
					//Kokia nors funkcija pasima kortas kurias galima naudoti
					zaidejai.get(j).getKortos();
					//Eiles pakeitimas
					zaidejai.get(j).setArManoEile(false);
					
					if(j == 2)
						zaidejai.get(0).setArManoEile(true);
					else
						zaidejai.get(j).setArManoEile(true);
				}
			}
		}
	}

}
