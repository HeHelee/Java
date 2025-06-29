### enum
- enum은 서로 관련된 상수들의 집합을 정의할 수 있는 특수한 클래수로 자바 1.5부터 도입된 개념입니다.
- 요일, 상태, 방향, 색깔 등 주로 한정된 값들만 표현할 때 사용합니다.

### 기본 문법
```
public enum PowerState {
  OFF,
  ON,
  SUSPEND
}
```
- PowerState는 열거형 타입입니다.
- OFF, ON, SUSPEND는 PowerState 타입의 객체이자 상수입니다.
- 자바에서 enum을 정의하면 그 내부에 선언된 값들은 암묵적으로 publuic static final로 선언된 상수 객체이며, 클래스처럼 작동하는 각각의 인스턴스이며 다른 값으로 변경할 수 없습니다.

### enum의 특징
  - enum은 java.leng.Enum 클래스를 상속받는 암묵적인 final 클래스로 컴파일 됩니다.
  - enum은 내부에 필드, 생성자, 메서드를 가질 수 있습니다.
  - enum 상수는 컴파일 시점에 암묵적으로 public static final 인스턴스로 생성됩니다.
  - enum은 싱글턴처럼 동작하며, JVM에서 상수는 단 한번만 생성됩니다.
  - enum은 swtich 문과 함께 사용할 수 있어 가독성을 높이고 유지보수를 용이하게 합니다.

```
public enum PowerState {
    OFF("전원이 꺼졌습니다."),
    ON("전원이 켜졌습니다."),
    SUSPEND("절전 모드입니다.");

    private final String message; // 필드

    // 생성자 (항상 private)
    PowerState(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void printStatus() {
        System.out.println("현재 상태: " + name() + ", 메시지: " + message);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}

```
### 주의할 점
- enum은 기본적으로 public static final 이면서 singleton 처럼 동작한다.
- 생성자를 직접 호출할 수 없다.
- 상수 외의 값으로는 변경할 수 없다.
