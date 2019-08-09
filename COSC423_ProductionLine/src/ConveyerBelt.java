/*Alaa Harajli 
 * COSC 423 production line
 * 
 * Changes made to this class vs the original sited are that more two more
 * belts are made vs the original. in order to handel the AB ,BC and CD belts
 * we had to create their own variables Such as countAB, BC ect 
 * 
 * 
 * 
 * conveyer belt class based after boundered buffer class
 * writen by Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */
public class ConveyerBelt {
	public static final int Max_Capacity = 3;
	public static final int SleepTime = 3;
	public boolean myB = false;
	public boolean myC = false;
	public boolean myD = false;

	public void setMyB(boolean myB) {
		this.myB = myB;
	}

	public void setMyC(boolean myC) {
		this.myC = myC;
	}

	public void setMyD(boolean myD) {
		this.myD = myD;
	}

	private Object[] beltAB;
	private Object[] beltBC;
	private Object[] beltCD;
	private int countAB;
	private int countBC;
	private int countCD;
	private int inAB, outAB;
	private int inBC,outBC;
	private int inCD , outCD;
	

	public ConveyerBelt() {
		// count = 0;
		inAB = 0;
		outAB = 0;
		inBC = 0;
		outBC = 0;
		inCD = 0;
		outCD = 0;
		beltAB = new Object[Max_Capacity];
		beltBC = new Object[Max_Capacity];
		beltCD = new Object[Max_Capacity];
	}



	public synchronized void enterAB(Object item) {
		while (countAB == Max_Capacity) {
			try {
				System.out.println("Warning WorkerA trying to place widget <handeled by A> into full AB belt ");
				wait();
			} catch (InterruptedException e) {
			}
		}

		// add an item to the buffer
		++countAB;
		beltAB[inAB] = item;
		inAB = (inAB + 1) % Max_Capacity;

		notify();
	}

	// consumer calls this method
	public synchronized Object removeAB() {
		Object item;

		while (countAB == 0) {
			try {
				System.out.println("WARNING Worker B is idle");
				wait();

			} catch (InterruptedException e) {
			}
		}

		// remove an item from the buffer
		--countAB;
		item = beltAB[outAB];
		outAB = (outAB + 1) % Max_Capacity;

		notify();

		return item;
	}

	public synchronized void enterBC(Object item) {
		while (countBC == Max_Capacity) {
			try {
				System.out.println("Warning WorkerB trying to place widget handeld by <A B> into full BC belt ");
				wait();

			} catch (InterruptedException e) {
			}
		}

		// add an item to the buffer
		++countBC;
		beltBC[inBC] = item;
		inBC = (inBC + 1) % Max_Capacity;

		notify();
	}

	// consumer calls this method
	public synchronized Object removeBC() {
		Object item;

		while (countBC == 0) {
			try {
				System.out.println("WARNING Worker C is IDLE");
				wait();
			} catch (InterruptedException e) {
			}
		}

		// remove an item from the buffer
		--countBC;
		item = beltBC[outBC];
		outBC = (outBC + 1) % Max_Capacity;

		notify();

		return item;
	}

	public synchronized void enterCD(Object item) {
		while (countCD == Max_Capacity) {
			try {
				System.out.println("Warning Worker C trying to place Widget into full belt ");
				wait();

			} catch (InterruptedException e) {
			}
		}

		// add an item to the buffer
		++countCD;
		beltCD[inCD] = item;
		inCD = (inCD + 1) % Max_Capacity;

		notify();
	}

	// consumer calls this method
	public synchronized Object removeCD() {
		Object item;

		while (countCD == 0) {
			try {
				System.out.println("WARNING Worker D is IDLE");
				wait();

			} catch (InterruptedException e) {
			}
		}

		// remove an item from the buffer
		--countCD;
		item = beltCD[outCD];
		outCD = (outCD + 1) % Max_Capacity;

		notify();

		return item;
	}
}
