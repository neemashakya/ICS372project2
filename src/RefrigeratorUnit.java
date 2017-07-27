// This class is the super class where the freezer and fridge unit inherits from.

public class RefrigeratorUnit {
	public enum States{ COOLING, IDLE};
	protected States currentState;
	protected int minTemp;
	protected int maxTemp;
	protected int rateLossDoorClosed;
	protected int rateLossDoorOpen;
	protected int compressorDiff;
	protected int coolRate;
	protected int currentTemp;
	protected boolean doorOpened;
	protected RefrigeratorDisplay display;
	protected RefrigeratorUnit instance;

	public RefrigeratorUnit(){}
	
	public RefrigeratorUnit instance(RefrigeratorDisplay display, int min, int max, int rateLossDoorClosed, int rateLossDoorOpen, int compressorStartDiff, int coolRate){
		this.display = display;
		this.minTemp = min;
		this.maxTemp = max;
		this.rateLossDoorClosed = rateLossDoorClosed;
		this.rateLossDoorOpen = rateLossDoorOpen;
		this.compressorDiff = compressorStartDiff;
		this.coolRate = coolRate;
		doorOpened = false;
		instance = new RefrigeratorUnit();
		return instance;
	}
	
	public void OpenDoor(){
		if(doorOpened){
			doorOpened = true;
			display.turnFridgeLightOff();
		}
	}
	
	public void CloseDoor(){
		if(!doorOpened){
			doorOpened = false;
			display.turnFreezerLightOff();
		}
	}
	
	public States IsDoorOpen(){
		return currentState;
	}
	
	public void SetTemperature(int temp){
		this.currentTemp = temp;
	}
	
	public int GetTemperature(){
		return currentTemp;
	}
	
	public void SetRoomTemp(int temp){
		
	}
	
	public void startCooling(){
		System.out.println("Current temp"+ currentTemp);
	}
}
