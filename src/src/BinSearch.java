import java.util.Arrays;

public class BinSearch {
	
	public int[] suchReihung;
	
	BinSearch() {
		int[] ersteListe = {2,4,5,12,19,20,23,30,37,38};
		int[] zweiteListe = {1,6,7,11,15,17,22,29,40};
		binarySearch(37, ersteListe);
	}
	
	public int binarySearch(int search, int[] r) {
		int zaehler = 1;
		int nenner = 2;
		
		while(true) {
			int pos = r.length * zaehler / nenner;
			if(r[pos] == search) {
				System.out.println("Gefunden an Stelle " + pos);
				return pos;
			}
			else if(r[pos] > search) {
				zaehler *= 2;
				nenner *= 2;
				--zaehler;
			}
			else {
				zaehler *= 2;
				nenner *= 2;
				++zaehler;
			}
			
			if(nenner > r.length * 2) {
				System.out.println("Nicht gefunden!");
				return -1;
			}
		}

	}
}
