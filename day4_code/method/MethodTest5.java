package day4_code.method;

public class MethodTest5 {

	public static void main(String[] args) {
		int a = 10, b = 5;
		System.out.println(a + "+" + b + "=" + add(a,b));
		System.out.println("main a:" + a);
		System.out.println("종료");
	}

	private static int add(int a, int b) { //call by value : 값에 의한 호출
		int sum = a + b;
		a++;
		System.out.println("add a:" + a);
		return sum;
	}
	

}