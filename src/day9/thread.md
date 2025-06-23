### 프로그램, 프로세스, 쓰레드
#### 프로그램
- 하드디스크에 저장된 파일들의 모임
#### 프로세스
- 메모리에 로딩된 프로그램
- 동일한 프로그램을 메모리에 2번 로딩하면 두개의 프로세스가 동작하는 데 이걸 멀티 프로세스라고 한다.
#### 쓰레드
- CPU를 사용하는 최소 단위
- 프로세스 안에 존재하므로 CPU는 쓰레드를 사용한다는 것을 의미한다.
- 쓰레드 내부에서 2개 이상의 쓰레드를 생성해 실행하면 '멀티 쓰레드 프로세스' 라고 한다.
- 멀티 쓰레드가 필요한 이유는 작업을 동시에 실행하기 위해서 필요하다.
#### 쓰래드의 동작 방식
##### 동시성
- 처리할 작업의 수가 CPU의 코어 수보다 많을 때 사용한다.
- 쓰레드는 각 요청 작업을 번갈아 가면서 수행한다.
- 짧은 간격으로 교차 실행하기 때문에 사용자는 마치 동시에 실행하는 것처럼 보인다.
##### 병렬성 
- CPU가 작업 수보다 많을 때 사용한다.
- 각각의 작업을 각각의 코어에 할당에 동시에 실행할 수 있다.

### 쓰레드의 생성 및 실행 방법
#### Thread 클래스를 상속받아 run() 메서드 재정의
```
public class SMIFileThread extends Thread {
    public SMIFileThread() {
    }

    public void run() {
        String[] strArray = new String[]{"하나", "둘", "셋", "넷", "다섯"};

        try {
            Thread.sleep(100L);
        } catch (InterruptedException var5) {
        }

        for(int i = 0; i < strArray.length; ++i) {
            System.out.println("- (자막 번호) " + strArray[i]);

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException var4) {
            }
        }

    }

    public static void main(String[] args) {
        Thread smiFileThread = new SMIFileThread();
        smiFileThread.start();
        int[] intArray = new int[]{1, 2, 3, 4, 5};

        for(int i = 0; i < intArray.length; ++i) {
            System.out.print("(비디오 프레임) " + intArray[i]);

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException var5) {
            }
        }

    }
}
```
#### run() 메서드와 start() 메서드의 차이는 ?
- run() 메서드는 Runnable 인터페이스를 구현할 때 오버라이딩하는 메서드이다.
- 그냥 run()을 호출하면 일반 메서드처럼 실행되고 새로운 쓰레드가 생성되지 않습니다.
- 다만 start() 메서드는 호출 시 JVM이 새로운 쓰레드를 생성하고, 내부적으로 run() 메서드를 호출합니다.
- 즉 병렬 실행이 가능합니다.
```
class SMIFileThread extends Thread {
    SMIFileThread() {
    }

    public void run() {
        String[] strArray = new String[]{"하나", "둘", "셋", "넷", "다섯"};

        try {
            Thread.sleep(10L);
        } catch (InterruptedException var5) {
        }

        for(int i = 0; i < strArray.length; ++i) {
            System.out.println(" - (자막 번호) " + strArray[i]);

            try {
                Thread.sleep(200L);
            } catch (InterruptedException var4) {
            }
        }

    }
}

class VideoFileThread extends Thread {
    VideoFileThread() {
    }

    public void run() {
        int[] intArray = new int[]{1, 2, 3, 4, 5};

        for(int i = 0; i < intArray.length; ++i) {
            System.out.print("(비디오 프레임)" + intArray[i]);

            try {
                Thread.sleep(200L);
            } catch (InterruptedException var4) {
            }
        }

    }
}

public class CreateAndStartThread_M1C2 {

    public static void main(String[] args) {
        Thread smiFileThread = new SMIFileThread();
        smiFileThread.start();
        Thread videoFileThread = new VideoFileThread();
        videoFileThread.start();
    }
}
```
#### Runnable 인터페이스 구현 객체를 생성한 후 Thread 생성자로 Runnable 객체 전달
```
class SMIFileRunnable implements Runnable {
    SMIFileRunnable() {
    }

    public void run() {
        String[] strArray = new String[]{"하나", "둘", "셋", "넷", "다섯"};

        try {
            Thread.sleep(10L);
        } catch (InterruptedException var5) {
        }

        for(int i = 0; i < strArray.length; ++i) {
            System.out.println("- (자막 번호) " + strArray[i]);

            try {
                Thread.sleep(200L);
            } catch (InterruptedException var4) {
            }
        }

    }
}

class VideoFileRunnable implements Runnable {
    VideoFileRunnable() {
    }

    public void run() {
        int[] intArray = new int[]{1, 2, 3, 4, 5};

        for(int i = 0; i < intArray.length; ++i) {
            System.out.print("(비디오 프레임) " + intArray[i]);

            try {
                Thread.sleep(200L);
            } catch (InterruptedException var4) {
            }
        }

    }
}

public class CreateAndStartThread_M2C2 {
    public static void main(String[] args) {
        Runnable smiFileRunnable = new SMIFileRunnable();
        Thread thread1 = new Thread(smiFileRunnable);
        thread1.start();
        Runnable videoFileRunnable = new VideoFileRunnable();
        Thread thread2 = new Thread(videoFileRunnable);
        thread2.start();
    }
}
```
### 쓰레드 속성
#### 현재 쓰래드 객체 참좃값 얻어오기
- 쓰레드 객체를 생성할 때 참조 변ㅅ를 정의하지 않을 경우에는 (new Thread().start()) 객체를 참조할 수 없다.
- 객체를 참조할 수 없을 때 Thread 클래스의 정적 메서드인 currentThread()메서드를 이용해 현재 쓰레드 객체의 참조값을 얻어올 수 있다.
```
static Thread Thread.currentThread()
```
#### 실행 중인 쓰레드의 개수 가져오기
- 여러 개의 쓰레드가 실행되고 있을 때 현재 실행 중인 쓰레드의 개수를 알고 싶다면 Thread 클래스 내의 정적 메서드인 activeCount()를 사용해야 한다.
- activeCount()는 동일한 쓰레드 그룹 내에서 실행 중인 쓰레드의 개수를 리턴한다.
```
static int Thread.activeCount();
```
#### 쓰레드의 이름 지정 및 가져오기
- 여러 개의 쓰레드를 생성하고 실행하다 보면 각각의 쓰레드를 구분할 필요가 있다.
- Thread 클래스의 인스턴스 메서드인 setName() 메서드를 사용한다.
```
String setName(String name)
```
- 해당 메서드는 쓰레드 객체를 생성한 후에 적용할 수 있다.
- 직접 지정하거나 자동으로 부여된 쓰레드의 이름을 가져올 때는 인스턴스 메서드 getName()을 사용한다.
```
String getName()
```
```
public class ThreadProperties_1 {
    public ThreadProperties_1() {
    }

    public static void main(String[] args) {
        Thread curThread = Thread.currentThread();
        System.out.println("현재 쓰레드의 이름 = " + curThread.getName());
        System.out.println("동작하는 쓰레드의 개수 = " + Thread.activeCount());

        int i;
        Thread thread;
        for(i = 0; i < 3; ++i) {
            thread = new Thread();
            System.out.println(thread.getName());
            thread.start();
        }

        for(i = 0; i < 3; ++i) {
            thread = new Thread();
            thread.setName("" + i + "번째 스레드");
            System.out.println(thread.getName());
            thread.start();
        }

        System.out.println("동작하는 쓰레드의 개수 = " + Thread.activeCount());
    }
}
```
#### 쓰레드의 우선순위 
- 모든 쓰레드는 1 ~ 10 사이의 우선순위를 가지고 있다. 1이 가장 낮고, 10이 가장 높은 순위 값이다.
- 우선 순위를 지정하지 않으면 기본값으로 5의 우선순위를 갖는다.
- 2개의 작업이 하나의 CPU 코어에서 동작할 때 쓰레드의 동시성에 따라 2개의 작업은 일정 시간 간격으로 번갈아가면서 작업한다.
- 쓰레드 객체의 우선순위 정하기
```
void setPriority(int priority)
```
- 쓰레드 객체의 우선순위 가져오기
```
int getPriority()
```
```
import java.io.PrintStream;

class MyThread extends Thread {
    MyThread() {
    }

    public void run() {
        for(long i = 0L; i < 10000000000L; ++i) {
        }

        PrintStream var10000 = System.out;
        String var10001 = this.getName();
        var10000.println(var10001 + " 우선순위: " + this.getPriority());
    }
}
public class ThreadProperties_2 {

    public static void main(String[] args) {
        System.out.println("코어 수: " + Runtime.getRuntime().availableProcessors());

        int i;
        MyThread thread;
        for(i = 0; i < 3; ++i) {
            thread = new MyThread();
            thread.start();
        }

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException var3) {
        }

        for(i = 0; i < 10; ++i) {
            thread = new MyThread();
            if (i == 9) {
                thread.setPriority(10);
            }

            thread.start();
        }

    }
}
```
#### 쓰레드의 데몬 설정
- 일반 쓰레드가 모두 종료되면 함께 종료되는 쓰레드를 데몬 쓰레드라고 한다.
- 예를 들어 문서 편집 프로그램에 일정 시간 간격으로 자동 저장을 하는 쓰레드가 있다고 하면, 문서 편집 프로그램이 종료되면 자동 저장 쓰레드는 더이상 동작할 필요가 없다.
- 데몬 설정은 쓰레드가 실행되기 전, 즉 start() 메서드 호출 전에 설정해야 한다.
- 쓰레드의 데몬 설정
```
void setDeamon(boolean on)
```
- 쓰레드의 설정 확인
```
boolean isDeamon()
```
