### 제네릭
#### 제네릭이란 ?
- 자바에서는 다양한 종류의 클래스와 인터페이스를 제공하고 있다.
- 이런 클래스와 인터페이스를 내부 멤버에서 활용하는 클래스를 작성하고자 할 때 제공되는 클래스나 인터페이스의 다양성 만큼이나 많은 가짓수의 클래스를 생성해야 한다.
- 이런 비효율성을 해결하기 위해서 제네릭 요소를 사용한다.
#### 제네릭 없이 여러 객체를 저장하는 클래스 작성하기
- Goods1 클래스의 객체를 생성하면 사과만 저장하고 가져올 수 있고, Goods2 클래스의 객체를 생성하면 연필만 저장하고 가져올 수 있다.
- 즉 사과와 연필을 저장하기 위해 각각의 기능을 수행하는 클래스를 2개 만든 것이다.
- 이렇게 되면 새로운 상품이 추가될 때마다 새롭게 클래스를 정의해야 하는 문제점이 발생한다.
- 이를 해결하기 위해 나온 것이 필드를 모든 자바 클래스의 최상위 클래스인 Object타입으로 선언하는 것이다.
- 여기에서 주의해야 할 점이 있다. 데이터를 저장할 때는 상관이 없지만 저장된 데이터를 각각의 타입으로 꺼낼 때는 저장된 형태로 캐스팅해야 한다.
- 캐스팅을 잘못 할 경우, 예외가 발생하고 프로그램은 강제 종료된다. 이를 '약한 타입 체크' 라고 한다.
```
class Apple{}

class Goods {
  private Object object;
  public Object getObject() {
   return object;
  }
  public void setObject(Object object) {
   this.object = object;
  }
}

public class Solution1_UsingObject {
  public static void main(String[] args) {
   Goods goods1 = new Goods();
   goods1.setObject(new Apple());
   Apple apple = (Apple)goods1.getObject();
  }
}
```
#### 제네릭의 문법
- 제네릭 클래스는 데이터 타입에 상관없이 하나의 클래스에서 여러 객체를 처리할 수 있도록 해준다. 이로 인해 각 타입별 클래스를 따로 만들 필요 없이, 다양한 객체를 효율적으로 저장하고 관리할 수 있다.
- setter 메서드에 잘못된 객체를 입력했을 때 바로 문법으로 체크해주고 , getter 메서드의 리턴 타입도 다운 캐스팅을 할 필요가 없다.
##### 제네릭 클래스와 인터페이스 정의하기
```
// 제네릭 타입 변수명이 1개일 때
접근 지정자 class 클래스명 <T> {
}
접근 지정자 interface 클래스명 <T> {
}

// 제네릭 타입 변수명이 2개일 때
접근 지정자 class 클래스명 <K,V> {
}
접근 지정자 interface 클래스명 <K,V> {
}
```
##### 제네릭 클래스의 객체 생성
- 객체를 생성할 때 제네릭 타입 변수에 실제 타입을 대입하는 것이다.
- 제네릭 클래스는 클래스를 정의하는 시점에 타입을 지정하는 것이 아니라 객체를 생성하는 시점에 타입을 지정하기에 하나의 제네릭 클래스로 다양한 타입의 객체를 저장 및 관리할 수 있다.
```
클래스명<실제 제네릭 타입> 참조 변수명 = new 클래스명<실제 제네릭 타입>();
또는
클래스명<실제 제네릭 타입> 참조 변수명 = new 클래스명<>();
```
```
class MyClass<T> {
	private T t;

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}

}

public class SingleGenenricArgument {

	public static void main(String[] args) {
		MyClass<String> mc1 = new MyClass<String>();
		mc1.set("안녕");
		System.out.println(mc1.get());
		MyClass <Integer> mc2 = new MyClass<>();
		mc2.set(100);
		System.out.println(mc2.get());
	}

}
```
##### 제네릭 타입 변수가 2개인 경우
```
class KeyValue<K, V> {
	private K key;
	private V value;

	public K getKey() {
		return key;
	}

	public void setkey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}

public class TwoGenenricArguments {

	public static void main(String[] args) {
		KeyValue<String, Integer> kv1 = new KeyValue<>();
		kv1.setkey("사과");
        kv1.setValue(1000);
        String key1 = kv1.getKey();
        int value1 = kv1.getValue();
        System.out.println("key: " + key1 + " value: " + value1);
        
		KeyValue<Integer,String> kv2 = new KeyValue<>();
		kv2.setkey(404);
        kv2.setValue("Not Found(요청한 페이지를 찾을 수 없습니다.)");
        int key2 = kv2.getKey();
        String value2 = kv2.getValue();
        System.out.println("key: " + key2 + " value: " + value2);
        
        KeyValue<String, Void> kv3 = new KeyValue<>();
        kv3.setkey("키 값만 사용");
        String key3 = kv3.getKey();
        System.out.println("key: " + key3);
	}

}
```
#### 제네릭 메서드
- 클래스 내부의 특정 메서드만 제네릭으로 선언하는 것을 말한다.
- 리턴타입, 입력 매개변수의 타입을 제네릭 타입 변수로 선언한다.
- 제네릭 메서드는 객체를 생성하는 시점에서 타입이 결정되는 제네릭 클래스와 다르게 호출되는 시점에 실제 제네릭 타입을 지정한다.
- 메서드를 호출할 때 호출할 메서드명 앞에 <실제 제네릭 타입>을 삽입해 표현한다.
- 다만 입력 매개변수에 제네릭 타입 변수가 사영돼 입력매개변수의 타입만으로 실제 제네릭 타입을 예측할 수 있을 때 생략가능하다.
```
class GenericMethods {
	public <T> T method1(T t) {
		return t;
	}
	public <T> boolean method2(T t1, T t2) {
		return t1.equals(t2);
	}
	public <K,V>void method3(K k, V v) {
		System.out.println(k + " : " + v);
	}
	
}

public class GenericMethod {

	public static void main(String[] args) {
		GenericMethods gm = new GenericMethods();
		
		String str1 = gm.<String>method1("안녕");
		String str2 = gm.method1("안녕");
		System.out.println(str1);
		System.out.println(str2);
		
		boolean bool1 = gm.<Double>method2(2.5, 2.5);
		boolean bool2 = gm.method2(2.5,2.5);
		System.out.println(bool1);
		System.out.println(bool2);
		
		gm.<String, Integer>method3("국어",80);
	    gm.method3("국어",80);

	}

}
```
#### 제네릭 메서드 내에서 사용할 수 있는 메서드
- 제네릭 메서드의 제네릭 타입 변수는 메서드가 호출되는 시점에 결정된다.
- 즉, 제네릭 메서드를 정의하는 시점에서는 아직 어떤 타입이 입력될지 전혀 모른다.
- 따라서 특정 타입에 포함되 있는 메서드는 메서드를 정의하는 시점에서 사용할 수 없다.
- 제네릭 메서드는 타입이 호출 시점에 결정되기 때문에 구체적인 타입의 메서드를 바로 사용할 수 없다.
- 하지만 모든 클래스가 Object를 상속하므로, 제네릭 타입에서도 Object 클래스의 메서드는 사용할 수 있다.
```
class A {
	public <T> void method(T t) {
		// System.out.println(t.length()); 불가능
		System.out.println(t.equals("안녕"));
	}
}

public class AvailableMethodInGenericMethod {

	public static void main(String[] args) {
		A a = new A();
		a.<String>method("안녕");

	}

}
```
#### 제네릭 타입 범위 제한




