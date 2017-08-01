
public class FreedgeContext {
	private static RefrigeratorDisplay refrigeratorDisplay;
	private FreedgeState currentState;
	private static FreedgeContext instance;
	

	/**
	 * Make it a singleton
	 */
	private FreedgeContext() {
		instance = this;
		refrigeratorDisplay = RefrigeratorDisplay.instance();
		currentState = FreedgeDoorClosedState.instance();
	}


	public static FreedgeContext instance() {
		
		return instance;
	}


	public RefrigeratorDisplay getDisplay() {
		
		return refrigeratorDisplay;
	}

}
