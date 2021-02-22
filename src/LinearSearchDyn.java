import java.util.Scanner;

public class LinearSearchDyn {
	
	int zahlenReihung[];
	DynArray suchReihung;
	
	LinearSearchDyn() {
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
		suchReihung = new DynArray();
		
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
	public void reihungAusgeben(DynArray r) {
		Listenelement a = r.getLastElement();
		while(a != null) {
			System.out.println(a.getObject().toString());
			a = a.getNextElement();
		}
	}
	
	public void zahlenGenerator(int anzahl) {
		for(int i = 0; i < anzahl; i++) {
			int freieZahl;
			do {
				freieZahl = (int) (Math.random() * anzahl);
			} while(zahlenReihung[freieZahl] == 0);
			suchReihung.append(freieZahl+1);
			zahlenReihung[freieZahl] = 0;
		}
	}
	
	public int sucheLinear(DynArray feld, int x) {
		for (int i = 0; i < feld.getLength(); i++) {
			if(x == (int)feld.getItem(i)) {
				System.out.println(x + " wurde an Position " + i + " gefunden!");
				return i;
			}
		}
		System.out.println(x + " wurde nicht gefunden!");
		return -1;
	}
}
