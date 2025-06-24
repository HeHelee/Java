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
- 쓰레드의 데몬 설정 (일반 쓰레드)
```
package sec03_threadproperties.EX03_ThreadProperties_3_1;

class MyThread extends Thread {
    @Override
    public void run () {
        System.out.println(getName() + ": " + (isDaemon()?"데몬 쓰레드":"일반 쓰레드"));
        for (int i = 0; i < 6; i++) {
            System.out.println(getName() + ": " + i + "초");
            try{Thread.sleep(1000);}catch (InterruptedException e){}
        }
    }
}

public class ThreadProperties_3_1 {
    public static void main(String[] args) {
        
        //일반  쓰레드
        Thread thread1 = new MyThread();
        thread1.setDaemon(false);
        thread1.setName("thread1");
        thread1.start();
        
        //3.5초 후 main 쓰레드 종료
        try{Thread.sleep(3500);}catch (InterruptedException e) {}
        System.out.println("main Thread 종료");
        
    }
}

```
- 쓰레드의 데몬 설정 (데몬 쓰레드)
```
package sec03_threadproperties.EX03_ThreadProperties_3_1;

class MyThread1 extends Thread {
    @Override
    public void run () {
        System.out.println(getName() + ": " + (isDaemon()?"데몬 쓰레드":"일반 쓰레드"));
        for (int i = 0; i < 6; i++) {
            System.out.println(getName() + ": " + i + "초");
            try{Thread.sleep(1000);}catch (InterruptedException e){}
        }
    }
}
public class ThreadProperties_3_2 {
    public static void main(String[] args) {
        //일반  쓰레드
        Thread thread1 = new MyThread1();
        thread1.setDaemon(true);
        thread1.setName("thread1");
        thread1.start();

        //3.5초 후 main 쓰레드 종료
        try{Thread.sleep(3500);}catch (InterruptedException e) {}
        System.out.println("main Thread 종료");
    }
}
```
- 데몬 쓰레드는 주 쓰레드가 아니라 프로세스 내의 모든 일반 쓰레드가 종료되어야 종료된다.
```
class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println(getName() + ": " + (isDaemon()?"데몬 쓰레드":"일반 쓰레드"));
        for (int i = 0; i < 6; i++) {
            System.out.println(getName() + ": " + i + "초");
            try {Thread.sleep(1000);}catch (InterruptedException e){}
        }
    }
}
public class ThreadProperties_3_3 {
    public static void main(String[] args) {
        //일반 쓰레드
        Thread thread1 = new MyThread2();
        thread1.setDaemon(false);
        thread1.setName("thread1");
        thread1.start();

        //데몬 쓰레드
        Thread thread2 = new MyThread2();
        thread2.setDaemon(true);
        thread2.setName("thread2");
        thread2.start();
        
        //3.5초 후 main 쓰레드 종료
        try {Thread.sleep(3500);}catch(InterruptedException e){}
        System.out.println("main Thread 종료");
    }
}
```
### 쓰레드의 동기화
#### 동기화란
- 하나의 작업이 완전히 안료된 후 다른 작업을 수행하는 것을 말한다.
#### 동기화가 필요한 이유
- 멀티 쓰레드 환경에서 여러 쓰레드가 동일한 자원에 접근하거나 수정할 때 데이터의 일관성이 깨질 수 있습니다.
- 예를 들어 은행 계좌에서 동시에 입출금을 처리하는 두개의 쓰레드가 있다고 가정하면 동기화 없이 작업이 수행될 경우, 계좌의 잔액이 잘못 계산될 수 있습니다.
- 그래서 하나의 쓰레드가 자원을 사용하는 동안 다른 쓰레드가 동일한 자원에 접근하지 못하도록 보장합니다.
### 동기화 방법
#### 메서드 동기화
- 2개의 쓰레드가 동시에 메서드를 실행할 수 없다는 것을 의미한다.
- 메서드를 동기화하고자 할 때는 동기화하고자 하는 메서드의 리턴 타입 앞에 synchronized 키워드를 넣으면 된다.
```
접근 지정자 synchronized 리턴 타입 메서드명(입력매개변수) {
  // 동기화가 필요한 코드
}
```
```
// 공유 객체
class MyData {
	int data = 3;
	
	public synchronized void plusData() {
		int mydata = data; //데이터 가져오기
		try {Thread.sleep(2000);} catch (InterruptedException e) {}
		data = data + 1;
	}
}

//공유 객체를 사용하는 쓰레드
class PlusThread extends Thread {
	MyData myData;
	public PlusThread(MyData myData) {
		this.myData = myData;
	}
	@Override
	public void run() {
		myData.plusData();
		System.out.println(getName() + "실행 결과: " + myData.data );
	}
}

public class TheNeedSynchronized {

	public static void main(String[] args) {
		//공유 객체 생성
		MyData myData = new MyData();
		
		//PlusThread1
	    Thread plusThread1 = new PlusThread(myData);
	    plusThread1.setName("plusThread1");
	    plusThread1.start();
	    
	    try {Thread.sleep(1000);}catch(InterruptedException e) {}
	    
	    //PlusThread2
	    Thread plusThread2 = new PlusThread(myData);
	    plusThread2.setName("plusThread2");
	    plusThread2.start();

	}

}
```
#### 블록 동기화
- 2개의 쓰레드가 동시에 해당 블록을 사용할 수 없다는 것을 의미한다.
- 전체 메서드 중에 일부만 동기화가 필요할 경우 해당 부분만 동기화를 할 수 있는데 이를 '블록 동기화'라고 한다.
```
synchronized (임의의 객체) {
}
```
- 여기서 임의의 객체는 어떤 객체도 올 수 있지만, 일반적으로 this를 넣어 자기 객체를 가리킨다.
```
class MyData {
	int data = 3;
	
	public void plusData() {
		synchronized (this) {
			int mydata = data;
			try {Thread.sleep(2000);}catch(InterruptedException e) {}
			data = mydata+1;
		}
	}
}
//공유 객체를 사용하는 쓰레드
class PlusThread extends Thread {
	MyData myData;
	public PlusThread(MyData myData) {
		this.myData = myData;
	}
	@Override
	public void run() {
		myData.plusData();
		System.out.println(getName() + "실행 결과: " + myData.data );
	}
}


public class SynchronizedBlock {

	public static void main(String[] args) {
	MyData myData = new MyData();
		
		//PlusThread1
	    Thread plusThread1 = new PlusThread(myData);
	    plusThread1.setName("plusThread1");
	    plusThread1.start();
	    
	    try {Thread.sleep(1000);}catch(InterruptedException e) {}
	    
	    //PlusThread2
	    Thread plusThread2 = new PlusThread(myData);
	    plusThread2.setName("plusThread2");
	    plusThread2.start();


	}

}
```
#### 동기화의 원리
- 모든 객체는 자신만의 열쇠를 가지고 있다.
- 한 시점에 하나의 쓰레드만 락을 가진 코드를 실행할 수 있다.
- 다른 쓰레드는 해당 락이 풀릴 때까지 기다려야 한다.
- 서로 다른 객체의 락은 독립적으로, 값은 같더라도 객체가 다르면, 각각의 락을 가지고 동시에 접근할 수 있다.

- 3개의 동기화 영역이 동일한 열쇠로 동기화됐을 때
```
package src.day9_sec04_synchronizedmethodandblock.EX04_KeyObject_1;

class MyData {
	synchronized void abc() {
		for (int i = 0; i < 3; i++) {
			System.out.println(i + "sec");
			try {Thread.sleep(1000);} catch(InterruptedException e) {}
		}
	}
	synchronized void bcd() {
		for (int i = 0; i < 3; i++) {
			System.out.println(i + "초");
			try {Thread.sleep(1000);} catch(InterruptedException e) {}
		}
	}
	synchronized void cde() {
		for (int i = 0; i < 3; i++) {
			System.out.println(i + "번째");
			try {Thread.sleep(1000);} catch(InterruptedException e) {}
		}
	}
}

public class KeyObject_1 {

	public static void main(String[] args) {
		//공유 객체
		MyData myData = new MyData();
		//3개의 쓰레드가 각각의 메서드 호출
		new Thread() {
			public void run() {
				myData.abc();
			};
		}.start();
		new Thread() {
			public void run() {
				myData.bcd();
			}
		}.start();
		new Thread() {
			public void run() {
				myData.cde();
			}
 		}.start();
	}
}
```

- 동기화 메서드와 동기화 블록이 다른 열쇠를 사용할 때
```
class MyData {
	synchronized void abc() {
		for (int i = 0; i < 3; i++) {
			System.out.println(i + "sec");
			try {Thread.sleep(1000);} catch(InterruptedException e) {}
		}
	}
	synchronized void bcd() {
		for (int i = 0; i < 3; i++) {
			System.out.println(i + "초");
			try {Thread.sleep(1000);} catch(InterruptedException e) {}
		}
	}
    void cde() {
		synchronized (new Object()) {
			for (int i = 0; i < 3; i++) {
				System.out.println(i + "번째");
				try{Thread.sleep(1000);} catch (InterruptedException e) {}
			}
		}
	}
}

public class KeyObject_1 {

	public static void main(String[] args) {
		//공유 객체
		MyData myData = new MyData();
		//3개의 쓰레드가 각각의 메서드 호출
		new Thread() {
			public void run() {
				myData.abc();
			};
		}.start();
		new Thread() {
			public void run() {
				myData.bcd();
			}
		}.start();
		new Thread() {
			public void run() {
				myData.cde();
			}
 		}.start();

	}

}
```
### 쓰레드의 상태
- 각 쓰레드의 상태는 Thread.State 타입으로 정의되어 있다.
- Thread의 인스턴스 메서드인 getState()로 가져올 수 있다.
- 쓰레드의 상태를 Thread.State 타입에 저장된 문자열 상숫값 중 하나로 리턴한다.

- 쓰레드의 상태 값 가져오기
```
Tread.State getState()
```
#### 쓰레드의 6가지 상태
##### NEW, RUNNABLE, TERMINATED
- 처음 객체가 생성되면 NEW 상태를 가진다.
- 이후 start() 메서드로 실행되면 RUNNABLE 상태가 된다.
- 실행 대기를 반복하면서 CPU를 다르 쓰레드들과 나눠서 사용한다.
- 이후 run() 메서드가 종료되면 TERMINATED 상태가 된다.
- RUNNABLE 상태에서는 TIMED_WATING, BLOCKED, WAITING 상태가 된다.

##### TIMED_WAITING
- 정적 메서드인 Thread.sleep(long millis) 또는 인스턴스 메서드인 join (long mills)가 호출되면 쓰레드는 TIME_WAITING 상태가 된다.
- 만일 일시정지 시간이 지나거나 외부에서 interrupt() 메서드가 호출되면 다시 RUNNABLE 상태가 된다.
- 그러면 Thread.sleep(long millis)와 join (long mills)의 차이점은 무엇일까?
- 예를 들어 쓰레드 A에서 Thread.sleep(1000)을 실행했다면 쓰레드 A는 외부에서 interrupt() 메서드가 호출되지 않는 한 1초 동안 일시정지 상태가 된다.
- 반면, '쓰레드 B 객체.join(1000)을 실행하게 된다면 쓰레드 A는 일시정지 되고 그동안 쓰레드 B가 실행된다.

##### BLOCKED
- 동기화 메서드 또는 동기화 블록을 실행하기 위해 먼저 실행 중인 쓰레드의 실행 완료를 기다리는 상태다.
- 앞의 쓰레드의 동기화 수행이 완료되면 BLOCKED 상태의 쓰레드는 RUNNABLE 상태가 된다.

##### WAITING
- 시간 정보가 없는 join()메서드가 호출되거나 wait() 메서드가 호출되면 WAITING 상태가 된다.
- join() 메서드로 호출로 WAITING 상태가 됐을 때 TIMED_WAITING의 상태와 마찬가지로 join()의 대상이 된 쓰레드가 종료되거나 외부에서 interrupt() 메서드가 호출되면 다시 RUNNABLE 상태로 돌아간다.
- wait() 메서드의 호출로 WAITING 상태가 됐을 떄는 Object 클래스의 notify() 또는 notifyAll() 메서드를 이용해 RUNNABLE 상태로 되돌아간다.
- 다만 wait(), notify(), notifyAll()은 동기화 블록 내에서만 사용할 수 있다.

#### Thread.yield()란?
- RUNNABLE 상태에서는 쓰레드 간의 동시성에 따라 실행과 실행 대기를 반복한다.
- Thread.yield()는 정적 메서드로 yield()를 호출하면 다른 쓰레드에게 CPU 사용을 인위적으로 양보하고, 자신은 실행 대기 상태로 전환할 수 있다.
```
class MyThread extends Thread {
	boolean yieldFlag;
	@Override
	public void run() {
		while(true) {
			if(yieldFlag) {
				try {
					Thread.sleep(500);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println(getName() + " 실행");
				for (long i = 0; i < 1000000000L; i++) {} //시간 지연
			}
		}
	}
}

public class YieldInRunnableState {

	public static void main(String[] args) {
		MyThread thread1 = new MyThread();
		thread1.setName("thread1");
		thread1.yieldFlag = false;
		thread1.setDaemon(true);
		thread1.start();
		
		MyThread thread2 = new MyThread();
		thread2.setName("thread2");
		thread2.yieldFlag = false;
		thread2.setDaemon(true);
		thread2.start();
		
		//6초 지연
		for (int i = 0; i < 6; i++) {
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
			thread1.yieldFlag = !thread1.yieldFlag;
			thread2.yieldFlag = !thread2.yieldFlag;
		}
	}
}
```

  
