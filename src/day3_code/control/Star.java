package day3_code.control;

public class Star {

	public static void main(String[] args) {
		int i = 1;
		while (i <= 5) {
			int j = 1;
			while (j <= i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
		System.out.println("----------");
		
		for (int k = 0; k < 5; k++) {
			for (int l = 5; l > k; l--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	    System.out.println("----------");
		
		for (int k = 0; k < 5; k++) {
			for (int l = 0; l < 5; l++) {
				if (l < 4-k) System.out.print(" ");
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
	
	}

}
