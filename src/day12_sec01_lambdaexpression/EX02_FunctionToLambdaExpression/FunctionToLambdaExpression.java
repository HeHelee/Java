package day12_sec01_lambdaexpression.EX02_FunctionToLambdaExpression;

interface A {
	// 입력 X, 리턴 X
	void method1();
}
interface B {
	// 입력 O, 리턴 X
	void method2(int a);
}
interface C {
	// 입력 X, 리턴 O
	int method3();
}
interface D {
	//입력 O, 리턴 O
	double method4(int a, double b);
}

public class FunctionToLambdaExpression {

	public static void main(String[] args) {
		//인터페이스의 함수 구현 -> 람다식
		//1.입력 X, 리턴 X
		//1-1. 익명 이너 클래스 방식
		A a1 = new A() {
			@Override
			public void method1() {
				System.out.println("입력 x 리턴 x 함수");
			}
		};
		//1-2. 람다식 표현
		A a2 = () -> {System.out.println("입력 x 리턴 x 함수");};
		A a3 = () -> {System.out.println("입력 x 리턴 x 함수");};
		
		//2.입력 O, 리턴 X
		//2-1. 익명 이너 클래스 방식
		B b1 = new B() {
			@Override
			public void method2(int a) {
				System.out.println("입력 O 리턴 x 함수");
			}
		};
		//2-2. 람다식 표현
		B b2 = (int a) -> {System.out.println("입력 o 리턴 x 함수");};
		B b3 = (a) -> {System.out.println("입력 o 리턴 x 함수");};
		B b4 = (a) -> System.out.println("입력 o 리턴 x 함수");
		B b5 =  a -> System.out.println("입력 o 리턴 x 함수");
		
		//3. 입력 X, 리턴 O
		//3-1. 익명 이너 클래스 방식
		C c1 = new C() {
			@Override
			public int method3() {
				return 4;
			}
		};
		//3-2 람다식 표현
		C c2 = () -> {return 4;};
		C c3 = () -> 4;
		
		//4. 입력 O, 리턴 O
		D d2 = (int a, double b) -> {return a + b;};
		D d3 = (a,b) -> {return a + b;};
		D d4 = (a,b) -> a+b;

	}

}
