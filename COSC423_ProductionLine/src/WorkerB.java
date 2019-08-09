/*
 * Alaa Harajli
 * 
 * Worker B is both a consumer and producer 
 * it consumes from belt AB using the belt.remove() method and then 
 * produces to the beltBC using the belt.enterBC method
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
public class WorkerB implements Runnable {
	private ConveyerBelt belt;

	public WorkerB(ConveyerBelt b) {
		belt = b;
	}

	@Override
	public void run() {
		Widget widge;
		while (true) {

			try {
				productionSpeed();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// consume an item from the buffer

			try {
				productionSpeed();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			widge = (Widget) belt.removeAB();
			System.out.println("Worker B is Retriving " + widge.buildWidget() + " <handeled by A> from the belt");

			System.out.println("Worker B is working on" + widge.buildWidget() + "<handled by A,B> ");
			System.out.println("Worker B is placing" + widge.buildWidget() + "<handled by A,B> on the belt ");
			belt.setMyC(true);
			belt.enterBC(widge);

		}
	}

	public static void productionSpeed() throws InterruptedException {
		Thread.sleep((long) (Math.random() * 1000));
	}
}
