// This class represents the freezer unit of the refrigerator and inherits from
// the RefrigeratorUnit super class.

public class Freezer extends RefrigeratorUnit{
	private int minTemp = 0;
	private int maxTemp = -9;
	private int currentTemp;
	private Freezer instance;
	
	
	public Freezer(RefrigeratorDisplay display, int min, int max, int rateLossDoorClosed, int rateLossDoorOpen, int compressorStartDiff, int coolRate) {
		super.instance(display, min, max, rateLossDoorClosed, rateLossDoorOpen, compressorStartDiff, coolRate);
		display.setFreezer(this);
	}
	
	public void OpenDoor(){
		if(!doorOpened){
			doorOpened = true;
			display.turnFreezerLightOn();
		}
	}
	
	public void CloseDoor(){
		if(doorOpened){
			doorOpened = false;
			display.turnFreezerLightOff();
		}
	}
}
