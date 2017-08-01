import java.util.Observable;

/**
 * This class represents the GUI of the refrigerator display.
 */
public abstract class RefrigeratorDisplay extends Observable{
	protected static FreedgeContext context;
	protected static RefrigeratorDisplay instance;

	/**
	 * Initializes the context and instance
	 */
	protected RefrigeratorDisplay() {
		instance = this;
		context = FreedgeContext.instance();
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static RefrigeratorDisplay instance() {
		return instance;
	}

	/**
	 * @param Freezer object
	 */
	public abstract void setFreezer(Freezer freezer);
	
	/**
	 * @param Fridge object
	 */
	public abstract void setFridge(Fridge fridge);

	/**
	 * Turns the freezer light on
	 */
	public abstract void turnFreezerLightOn();

	/**
	 * Turns the freezer light off
	 */
	public abstract void turnFreezerLightOff();
	
	/**
	 * Turns the fridge light on
	 */
	public abstract void turnFridgeLightOn();

	/**
	 * Turns the fridge light off
	 */
	public abstract void turnFridgeLightOff();

	/**
	 * Show the current temperature of freezer
	 */
	public abstract void freezerTemp(int value);
	
	/**
	 * Show the current temperature of fridge
	 */
	public abstract void fridgeTemp(int value);

	/**
	 * Indicate that state of the freezer
	 */
	public abstract void setFreezerState(RefrigeratorUnit.States status);

	/**
	 * Indicate that state of the fridge
	 */
	public abstract void setFridgeState(RefrigeratorUnit.States  status);

	
	
}
