package day4_code.sec02_method.EX07_FlexibleSizeArrayArgument;

public class FlexibleSizeArrayArgument {

	public static void main(String[] args) {
		// method1(int ...values)
		method1(1,2);
		method1(1,2,3);
		method1();
		//method2(String ...values)
		method2("안녕","방가");
		method2("땡큐","베리","감사");
		method2();
	}

	private static void method2() {
		// TODO Auto-generated day4_code.method stub
		
	}

	public static void method1(int ...values) {
		System.out.println("배열의 길이: " + values.length);
		for (int k : values) {
			System.out.print(k+ " ");
			System.out.println();
		}
	}
	
	private static void method2(String ...values) {
		System.out.println("배열의 길이: " + values.length);
		for (String k : values) {
			System.out.print(k+ " ");
			System.out.println();
		}
	}
}
