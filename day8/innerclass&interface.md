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

  ```
  class A {
	int a = 3;
	int b = 4;
	void abc() {
		System.out.println("A 클래스 메서드");
	}
	//인스턴스 이너 클래스
	class B {
		int a = 5;
		int b = 6;
		void abc() {
			System.out.println("B 클래스 메서드");
		}
		void bcd() {
			//이너 클래스의 멤버 호출 또는 사용
			System.out.println(a);
			System.out.println(b);
			abc();
			
			//아우터 클래스의 멤버 호출 또는 사용
			System.out.println(A.this.a);
			System.out.println(A.this.b);
			A.this.abc();
		}
	}
  }
  public class UseMemberOfOuterClass {

	public static void main(String[] args) {
		// 아우터 클래스 객체 생성
		A a = new A();
		
		// 이너 클래스 객체 생성
		A.B b = a.new B();
		b.bcd();
	}
  }
 

  ```
### 정적 멤버 이너 클래스
- 정적 멤버 이너 클래스는 이너 클래스 앞에 static 키워드가 포함된 이너 클래스이다.
- 정적 메서드와 동일하게 아우터 클래스의 정적 멤버에만 접근할 수 있다.
- 정적 클래스는 일반 클래스와 달리 객체를 생성하지 않고도 동작하기 때문에 정적 멤버 이너 클래스도 마찬가지로 외부 클래스의 인스턴스 없이 사용할 수 있다.
#### 정적 이너 클래스 생성하기
- 컴파일 이후에는 이너 클래스와 마찬가지로 '아우터 클래스.class' 와 '아우터 클래스$이너 클래스.class'의 바이트 코드 파일이 생성된다.
```
아우터 클래스.이너 클래스 이너 클래스 참조 변수 = new 아우터 클래스.이너 클래스();
```
```
class A {
	int a = 3;
    static int b = 4;
    void method1() {
    	System.out.println("instance method");
    }
    static void method2() {
    	System.out.println("static method");
    }
    //정적 이너 클래스
    static class B {
    	void bcd() {
    		//필드 사용
    		//System.out.println(a);
    		System.out.println(b);
    		//메서드 호출
    		//method1();
    		method2();
    	}
    }
}

public class CreateObjectAndAccessMember {

	public static void main(String[] args) {
		//정적 이너 클래스의 객체 생성
		A.B b = new A.B();
		//메서드 호출
		b.bcd();
	}

}
```

### 지역 이너 클래스
- 클래스의 멤버가 아닌 메서드 내에서 정의되는 클래스다.
- 지역 변수처럼 정의된 메서드 내부에서만 사용할 수 있으므로, 일반적으로 지역 이너 클래스는 선언 이후 바로 객체를 생성해 사용하며, 메서드가 호출될 때만 메모리에 로딩된다.
- 지역 이너 클래스는 객체가 생성되어야 사용되므로 정적 클래스로 지정할 수 없다.
#### 지역 이너 클래스 객체 생성하기
- 지역 이너 클래스도 다른 이너 클래스처럼 아우터 클래스의 멤버를 접근 지정자와 상관없이 사용할 수 있다.
- 자신이 정의된 메서드의 지역 변수도 클래스 내부에서 사용할 수 있다.
- 다만, 지역 변수를 사용할 때는 반드시 해당 지역 변수가 final로 선언되어야 한다.
```
지역 이너 클래스 지역 이너 클래스 참조 변수 = new 지역 이너 클래스();
```
```
class A {
	int a = 3;
	void abc() {
		int b = 5; //final로 정의됨
		//지역 이너 클래스
		class B {
			void bcd() {
				System.out.println(a);
				System.out.println(b);
				a = 5;
			//	b = 7;
			}
		}
		B bb = new B();
		bb.bcd();
	}
}
public class AccessMemberAndLocalVariable {

	public static void main(String[] args) {
		// 객체 생성 및 메서드 호출
		A a = new A ();
		a.abc();

	}

}
```
### 익명 이너 클래스
- 이름이 없는 클래스를 의미한다.
- 중괄호 바로 아래에 사용했을 경우에는 인스턴스 익명 이너 클래스, 메서드 내부에서 사용했을 경우에는 지역 익명 이너 클래스로 분류한다.
- 익명 이너 클래스는 항상 부모 타입으로만 선언할 수 있다.
```
   class A {
	C c = new C() {
		public void bcd() {
			System.out.println("익명 이너 클래스");
		}
	};

	void abc() {
		c.bcd();
	}
 }

 interface C {
	public abstract void bcd();
 }

 public class AnnonymouseClass_2 {

	public static void main(String[] args) {
		// 객체 생성 및 메서드 호출
		A a = new A();
		a.abc();

	}

  }
```
#### 익명 이너 클래스를 활용한 인터페이스 타입의 입력매개변수 전달
- 전달하는 방법에는 4가지로 분류할 수 있다.
- 클래스명 O + 참조 변수명 O
- 클래스명 O + 참조 변수명 X
- 클래스명 X + 참조 변수명 O
- 클래스명 X + 참조 변수명 X
```

interface A {
	public abstract void abc();
}
// 자식 클래스 직접 생성
class B implements A {
	public void abc() {
		System.out.println("입력매개변수 전달");
	}
}
class C {
	void cde(A a) {
		a.abc();
	}
}
public class AnnonymousClass_3 {

	public static void main(String[] args) {
		C c = new C();
		//방법 1. 클래스명 O + 참조 변수명 O
		A a = new B();
		c.cde(a);
		//방법 2. 클래스명 O + 참조 변수명 X
		c.cde(new B());

	}

}
```
```
interface A {
	public abstract void abc();
}
class C {
	void cde(A a) {
		a.abc();
	}
}
public class AnnonymousClass_3 {

	public static void main(String[] args) {
		C c = new C();
		//방법 3. 클래스명 X + 참조 변수명 O
		A a = new A() {
                  public void abc() {
                    System.out.println("입력매개변수 전달");
                  }
                }
                c.cde(a);
               
		//방법 4. 클래스명 X + 참조 변수명 X
		c.cde(new A() {
                  public void abc() {
                    System.out.println("입력 매개변수 전달");
                  }
                });

	}

}
```
### 이너 인터페이스
- 인터페이스를 클래스 내부에 정의하는 것은 해당 클래스에 의존적인 기능을 수행할 때 사용한다.
- 이너 인터페이스는 사용자 인터페이스의 이벤트 처리에 가장 많이 사용된다.

#### 이너 인터페이스의 특징
- 정적 이너 인터페이스만 존재할 수 있다.
- 이너 인터페이스도 인터페이스이므로 자체적으로 객체를 생성할 수 없다.
- 객체를 생성하기 위해서는 해당 인터페이스를 상속한 자식 클래스를 생성한 후 생성자를 이용해 객체를 생성하거나 익명 이너 클래스를 활용해 객체를 생성해야 한다.
- '이우터 클래스명.이너 안터페이스명'
```
class A {
	interface B {
		public abstract void bcd();
	}
}

class C implements A.B {
	public void bcd() {
		System.out.println("이너 인터페이스 구현 클래스 생성");
	}
}

public class CreateObjectOfInnerInterface {

	public static void main(String[] args) {
		// 객체 생성 방법 1 (자식 클래스 직접 생성)
		A.B ab = new C();
		C c = new C();
		c.bcd();
		// 객체 생성 방법 2 (익명 이너 클래스 생성)
		A.B b = new A.B() {
			public void bcd() {
				System.out.println("익명 이너 클래스로 객체 생성");
			}
		};
		b.bcd();

	}

}
```

'
