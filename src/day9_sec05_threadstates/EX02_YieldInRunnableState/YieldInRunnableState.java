package day9_sec05_threadstates.EX02_YieldInRunnableState;

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
