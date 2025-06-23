package day4_code.sec04_thisKeyword.EX01_ThisKeyword_1;

class A {
	int m;
	int n;
	void init(int a, int b) {
		int c;
		c = 3;
		this.m = a;
		this.n = b;
	}
	void work() {
		this.init(2, 3);
	}
}

public class ThisKeyword_1 {

	public static void main(String[] args) {
		// 클래스 객체 생성
		A a = new A();
		// 메서드 호출
		a.work();
		System.out.println(a.m);
		System.out.println(a.n);

	}

}
