package day9_sec05_threadstates.EX03_TimedWaiting_Sleep;

class MyThread extends Thread {
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(" -- sleep() 진행 중 interrupt() 발생");
			for (long i = 0; i < 1000000000000000000L; i++) {} //시간 지연
		}
	}
}

public class TimeWaiting_Sleep {

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start();
		
		try {Thread.sleep(100);} catch (InterruptedException e) {};
		System.out.println("MyThread State = " + myThread.getState());
		//TIMED_WAITING
		myThread.interrupt();
		try {Thread.sleep(100);} catch (InterruptedException e) {};
		System.out.println("MyThread State = " + myThread.getState());
		try {Thread.sleep(2000);} catch (InterruptedException e) {};
		System.out.println("MyThread State = " + myThread.getState());
	}

}
