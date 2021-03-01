import java.util.Scanner;

public class SearchMain {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int modus = -1;	//0=linear 1=dynlin 2=bin
				
		while(modus == -1) {
			System.out.println("Willst du linear [l], dynamisch linear [d] oder binär [b] suchen?\n");
			String a = scan.nextLine();
			
			if(a.equals("l")) modus = 0;
			else if(a.equals("d")) modus = 1;
			else if(a.equals("b")) modus = 2;			
			else System.out.println("Bitte eine der Möglichkeiten eingeben!");
		}
		if(modus == 0) new LinearSearch();
		else if(modus == 1) new LinearSearchDyn();
		else if(modus == 2) new BinSearch();
		
		scan.close();
	}
}
