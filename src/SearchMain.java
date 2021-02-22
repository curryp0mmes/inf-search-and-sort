import java.util.Scanner;

public class SearchMain {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int modus = -1;	//0=linear 1=bin
		
		while(modus == -1) {
			System.out.println("Willst du linear [l] oder binär [b] suchen?\n");
			String a = scan.nextLine();
			
			if(a.equals("l")) modus = 0;
			else if(a.equals("b")) modus = 1;			
			else System.out.println("Bitte eine der Möglichkeiten eingeben!");
			
		}
		if(modus == 0) {
			LinearSearchDyn lin = new LinearSearchDyn();
		}
		scan.close();
	}
}
