/*Alaa HArajli
 * Class that creates the widget object thatt way workerA can produce Widget for the others to work on 
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
 * */
public class Widget {
	
	public int count=0;
	public int increment=1;
	public String widget = "Widget";
	public Widget(int count1) {
		super();
		count=count1;
	}
	public String buildWidget() {
		
		return widget+count;
		
	}
	
}
