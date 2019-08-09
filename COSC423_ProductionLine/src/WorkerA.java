/*
 * Alaa Harajli 
 * Worker A is strictly a producer 
 * it creates a widget and places it on the belt
 * using the belt.enterAB() method
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




class WorkerA implements Runnable {
	private ConveyerBelt belt;
	private Thread work;
	final static int DaysWork = 25;
	final static String wid = "Widget";
	private boolean workNotDone = true;
	public int count = 1;

	public WorkerA(ConveyerBelt b) {
		belt = b;
	}

	@Override
	public void run() {
		Widget widge;

		// TODO Auto-generated method stub
		while (workNotDone) {
			try {
				productionSpeed();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			widge = new Widget(count);
			count++;

			System.out.println("Worker A is workering on " + widge.buildWidget() + "<Handeled by A>");
			System.out.println("Worker A is placing " + widge.buildWidget() + "<handeled by A> on belt");

			belt.enterAB(widge);
			if (count == 25) {
				System.out.println("Days work is finished go home");
				break;

			}
			belt.setMyB(true);
		}
	}

	public static void productionSpeed() throws InterruptedException {
		Thread.sleep((long) (Math.random() * 1000));
	}
}
