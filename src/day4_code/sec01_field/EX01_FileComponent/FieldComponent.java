package day4_code.sec01_field.EX01_FileComponent;

//클래스 생성
class A {
	int m = 3;
	int n = 4;
	void work1() {
		int k = 5;
		System.out.println(k);
		work2(3);
	}
	void work2(int i) {
		int j = 4;
		System.out.println(i + j);;
	}
}

public class FieldComponent {

	public static void main(String[] args) {
		// 클래스의 객체 생성
		A a = new A();
		//필드값 출력
		System.out.println(a.m);
		System.out.println(a.n);
		//메서드 호출
		a.work1();
	}

}
