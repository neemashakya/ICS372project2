
public class FreezerContext {

	private static RefrigeratorDisplay refrigeratorDisplay;
	private FreedgeState currentState;
	private static FreezerContext instance;
	

	/**
	 * Make it a singleton
	 */
	private FreezerContext() {
		instance = this;
		refrigeratorDisplay = RefrigeratorDisplay.instance();
		currentState = FreedgeDoorClosedState.instance();
	}


	public static FreezerContext instance() {
		
		return instance;
	}


	public RefrigeratorDisplay getDisplay() {
		
		return refrigeratorDisplay;
	}

}
