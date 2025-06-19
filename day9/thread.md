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



