/*
 * Alaa Harajli COSC 423 
 * 
 * 
 * 
 * The factory calls the threads using new thread
 * Because the worker classes implement Runnable
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
 */
public class Factory {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ConveyerBelt b = new ConveyerBelt();

		(new Thread(new WorkerA(b))).start();
		(new Thread(new WorkerB(b))).start();
		(new Thread(new WorkerC(b))).start();
		(new Thread(new WorkerD(b))).start();

	}

}
