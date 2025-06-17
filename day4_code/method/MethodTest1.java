package day4_code.method;

public class MethodTest1 {

	public static void main(String[] args) {
		print("신해철");
		print("서태지");
		print(); //day4_code.method overload (메소드 중복정의)
	}

	private static void print() {
		System.out.println("안녕하세요.");
	}

	private static void print(String name) {
		System.out.println("+---------+");
		System.out.println("| "+ name + "  |");
		System.out.println("+---------+");
	}

}
