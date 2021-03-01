import java.util.Scanner;

public class LinearSearch {
	
	int zahlenReihung[];
	int suchReihung[];
	
	LinearSearch() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Gib die Länge des Suchfeldes an!");
		int laenge = -1;
		while (laenge == -1) {
			String laengeStr = scan.nextLine();
			try {
				laenge = Integer.parseInt(laengeStr);
			}
			catch(NumberFormatException e) {
				System.out.println("Bitte eine Zahl eingeben!");
			}
		}
		
		zahlenReihung = new int[laenge];
		for(int i = 0; i<zahlenReihung.length; i++) {
			zahlenReihung[i] = 1;
		}
		suchReihung = new int[laenge];
		
		zahlenGenerator(laenge);
		
		
		System.out.println("Such-Reihung");
		reihungAusgeben(suchReihung);
		//System.out.println("Zahlen-Reihung");
		//reihungAusgeben(zahlenReihung);
		
		sucheLinear(suchReihung, 2);
		
		scan.close();
	}
	
	public void reihungAusgeben(int[] r) {
		for(int i = 0; i<r.length; i++) {
			System.out.println(r[i]);
		}
	}
	
	public void zahlenGenerator(int anzahl) {
		if(anzahl > zahlenReihung.length || anzahl > suchReihung.length) return;
		
		for(int i = 0; i < anzahl; i++) {
			int freieZahl;
			do {
				freieZahl = (int) (Math.random() * anzahl);
			} while(zahlenReihung[freieZahl] == 0);
			
			suchReihung[i] = freieZahl+1;
			zahlenReihung[freieZahl] = 0;
		}
	}
	
	public int sucheLinear(int[] feld, int x) {
		for (int i = 0; i < feld.length; i++) {
			if(x == feld[i]) {
				System.out.println(x + " wurde an Position " + i + " gefunden!");
				return i;
			}
		}
		System.out.println(x + " wurde nicht gefunden!");
		return -1;
	}
}
