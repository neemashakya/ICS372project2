
/**
 * This class represents the GUI of the refrigerator display.
 */
public interface RefrigeratorDisplay {
	/**
	 * @param Freezer object
	 */
	public void setFreezer(Freezer freezer);
	
	/**
	 * @param Fridge object
	 */
	public void setFridge(Fridge fridge);

	/**
	 * Turns the freezer light on
	 */
	public void turnFreezerLightOn();

	/**
	 * Turns the freezer light off
	 */
	public void turnFreezerLightOff();
	
	/**
	 * Turns the fridge light on
	 */
	public void turnFridgeLightOn();

	/**
	 * Turns the fridge light off
	 */
	public void turnFridgeLightOff();

	/**
	 * Show the current temperature of freezer
	 */
	public void freezerTemp(int value);
	
	/**
	 * Show the current temperature of fridge
	 */
	public void fridgeTemp(int value);

	/**
	 * Indicate that state of the freezer
	 */
	public void setFreezerState(RefrigeratorUnit.States status);

	/**
	 * Indicate that state of the fridge
	 */
	public void setFridgeState(RefrigeratorUnit.States  status);
	
}
