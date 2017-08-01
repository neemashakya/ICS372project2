
public abstract class RefrigeratorState {
	protected static FreedgeContext freedgeContext;
	protected static FreezerContext freezerContext;
	protected static RefrigeratorDisplay displayFreedge;
	protected static RefrigeratorDisplay displayFreezer;

	/**
	 * Initialzies the context and display
	 */
	protected RefrigeratorState() {
		freedgeContext = FreedgeContext.instance();
		freezerContext = FreezerContext.instance();
		displayFreedge = freedgeContext.getDisplay();
		displayFreezer = freezerContext.getDisplay();
	}

	/**
	 * Initializes the state
	 */
	public abstract void run();

	/**
	 * When the Microwave leaves from this state, this method is called to
	 * remove the state as a listener for the appropriate events.
	 */
	public abstract void leave();

}
