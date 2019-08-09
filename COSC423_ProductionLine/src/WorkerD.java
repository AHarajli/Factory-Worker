/*
 * Alaa Harajli
 * 
 * Worker D is strictly a consumer it takes from the belt and works on 
 * it but does not place it on another belt
 * when Worker D finishes widget 24 it terminates the threads thus ending the program
 * 
 * 
 * 
 * 
 *  conveyer belt class based after boundered buffer class
 * writen by Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 * 
 * 
 * 
 * 
 * 
 */
public class WorkerD implements Runnable {
	private ConveyerBelt belt;
	private int count=0;
	public WorkerD(ConveyerBelt b) {
		belt = b;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Widget widge;
		while (true) {
			try {
				productionSpeed();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// consume an item from the buffer

			try {
				productionSpeed();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			widge = (Widget) belt.removeCD();
			count++;
			System.out.println("Worker D is Retriving " + widge.buildWidget());

			System.out.println("Worker D is working on" + widge.buildWidget() + "<handled by C,D> ");
			if(count==24) {
				System.out.println("THE WORK IS DONE GO HOME");
				System.exit(0);
			}
		}
	}

	public static void productionSpeed() throws InterruptedException {
		Thread.sleep((long) (Math.random() * 1000));
	}
}
