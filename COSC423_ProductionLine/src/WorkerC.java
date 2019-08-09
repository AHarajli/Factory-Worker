/*
 * Alaa Harajli
 * 
 * Worker C is both a consumer and Producer 
 * it consumes form belt BC using the belt.remove method and produces to belt
 * CD using the belt.enterCD method
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
 */
public class WorkerC implements Runnable {
	private ConveyerBelt belt;

	public WorkerC(ConveyerBelt b) {
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
			widge = (Widget) belt.removeBC();

			System.out.println("Worker C is Retriving " + widge.buildWidget());

			System.out.println("Worker C is working on " + widge.buildWidget() + "<handled by B,C>");
			System.out.println("Worker C is placing " + widge.buildWidget() + " <handled by B,C> on the belt");
			belt.enterCD(widge);
			belt.setMyD(true);
		}
	}

	public static void productionSpeed() throws InterruptedException {
		Thread.sleep((long) (Math.random() * 1000));
	}
}
