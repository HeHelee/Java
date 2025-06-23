package day4_code.method;

public class methodTest2 {

	public static void main(String[] args) {
		int a = 10, b = 5;
		System.out.println(a + "+" + b + "=" + add(a,b));
		System.out.println(a + "-" + b + "=" + sub(a,b));
		System.out.println(a + "*" + b + "=" + mul(a,b));
		System.out.println(a + "/" + b + "=" + div(a,b) + "..." + mod(a,b));
	}

	private static int add(int a, int b) {
		return a+b;
	}
	
	private static int sub(int a, int b) {
		return a-b;
	}
	
	private static int mul(int a, int b) {
		return a*b;
	}
	
	private static int div(int a, int b) {
		return a/b;
	}
	
	private static int mod(int a, int b) {
		return a%b;
	}
}
