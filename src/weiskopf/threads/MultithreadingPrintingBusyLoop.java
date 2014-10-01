package weiskopf.threads;

import java.util.concurrent.CountDownLatch;

public class MultithreadingPrintingBusyLoop {

	public static void main(String[] args) throws InterruptedException {
		
		Thread [] threads = new Thread[5];
		CountDownLatch latch = new CountDownLatch(5);//tell it how many count downs there will be
		for(int i = 0; i<threads.length; i++){
			final int current = i;
			threads[i] = new Thread(){
				public void run(){
					System.out.println(current);
					latch.countDown();
				}
			};
			threads[i].start();
		}
		
		latch.await();//waits until the condition is met, will wait forever if need be
		
		/*int alive = threads.length;
		while(alive > 0){
			alive = 0;
			for(int i = 0; i<threads.length; i++){//if no threads are alive then alive will
				                                 //stay = 0, and loop will end
				if(threads[i].isAlive()){
					alive++;
				}
			}
		}*/
		
		System.out.println("finished");

	}
	

}
