// This class represents the fridge unit of the refrigerator and inherits from 
// the RefrigeratorUnit super class.

public class Fridge  extends RefrigeratorUnit{
	private int minTemp = 37;
	private int maxTemp = 41;
	private int currentTemp;
	private Fridge instance;
	
	public Fridge(RefrigeratorDisplay display, int min, int max, int rateLossDoorClosed, int rateLossDoorOpen, int compressorStartDiff, int coolRate) {
		super.instance(display, min, max, rateLossDoorClosed, rateLossDoorOpen, compressorStartDiff, coolRate);
		display.setFridge(this);
	}
	
	public void OpenDoor(){
		if(!doorOpened){
			doorOpened = true;
			display.turnFridgeLightOn();
		}
	}
	
	public void CloseDoor(){
		if(doorOpened){
			doorOpened = false;
			display.turnFridgeLightOff();
		}
	}
}
