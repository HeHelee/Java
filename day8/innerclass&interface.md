### 이너 클래스
- 클래스 내부에 포함되는 이너 클래스는 이너 클래스, 정적 클래스, 로컬 클래스로 나뉜다.
#### 인스턴스 멤버 이너 클래스
- 객체 내부에 멤버의 형태로 존재하는 것을 말한다.
- 이때 이너 클래스를 감싸고 있는 아우터 클래스의 모든 접근 지정자의 멤버에 접근할 수 있다.
- 그 이유는 이너 클래스 자체도 아우터 클래스의 멤버이기 때문이다.
- 또한 컴파일러가 외부 클래스의 인스턴스를 이너 클래스 안에 숨겨서 전달하기에 외부 클래스의 모든 멤버에 접근할 수 있다. (private도 가능하다.)
#### 인스턴스 이너 클래스 객체 생성하기
- 아우터 클래스 객체 내부에 이너 클래스가 정의되어있기 때문에 이너 클래스에 접근하기 위해서는 아우터 클래스의 객체를 먼저
  생성해야 한다.
  ```
  아우터 클래스 아우터 클래스 참조 변수 = new 아우터 클래스();
  아우터 클래스.이너 클래스 이너 클래스 참조 변수 = 아우터 클래스 참조 변수.new 이너 클래스();
  ```

- 예시
```
package day8_sec01_instanceinnerclass.EX01_CreateObjectAndAccessMember;

class A {
	public int a = 3;
	protected int b = 4;
	int c = 5;
	private int d = 6;

	void abc() {
		System.out.println("A 클래스 메서드 abc()");
	}

	// 이너 클래스
	class B {
		void bcd() {
			// 아우터 클래스의 필드 사용
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			System.out.println(d);

			// 아우터 클래스의 메서드 호출
			abc();
		}
	}
}

public class CreateObjectAndAccessMember {

	public static void main(String[] args) {
		// 아우터 클래스 객체 생성
		A a = new A();
		// 멤버 사용
		A.B b = a.new B();
		b.bcd();

	}

}
```
#### 아우터 클래스의 객체 참조하기
- 외부 클래스와 이너 클래스에 동일한 이름의 필드나 메서드가 있을 때, 이너 클래스의 필드나 메서드가 참조된다.
- 참조 객체명을 생략할 때는 자기 자신의 객체를 가리키는 this 키워드를 컴파일러가 자동으로 추가하기 때문이다.
- 이너 클래스 내부에서 'this.'의 의미는 이너 클래스 자신이 된다.
- 이너 클래스 내부에서 아우터 클래스의 멤버를 참조하고 싶을 때 '아우터 클래스명.this.' 를 사용한다.
