package day2_code.operation;

public class OpTest2 {

	public static void main(String[] args) {
		boolean b1 = true, b2 = true;
		
		System.out.println(b1 && b2);
		System.out.println(b1 || b2);
		System.out.println(!b1);
		
		int n1 = 5, n2 = 3;
	    System.out.println(n1 & n2);
	    System.out.println(n1 | n2);
	    System.out.println(~n1);
	    
	    /*
	     int temp = n1;
	     n1 = n2;
	     n2 = temp;
	     */
	    
	    n1 = n1 ^ n2;
	    n2 = n2 ^ n1;
	    n1 = n1 ^ n2;
	    System.out.println(n1 + "," + n2);
	    
	}
}
