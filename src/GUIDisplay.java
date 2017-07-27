import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;


/**
 * This GUI class implements the RefrigeratorDisplay interface
 */
public class GUIDisplay extends JFrame implements ActionListener, RefrigeratorDisplay {
	private Freezer freezer;
	private Fridge fridge;
	private JButton fridgeDoorOpener = new JButton("Open fridge door");
	private JButton fridgeDoorCloser = new JButton("Close fridge door");
	private JButton freezerDoorOpener = new JButton("Open freezer door");
	private JButton freezerDoorCloser = new JButton("Close freezer door");
	private JButton setRoomTemp = new JButton("Set room temp");
	private JButton setFridgeTemp = new JButton("Set desired fridge temp");
	private JButton setFreezerTemp = new JButton("Set desired freezer temp");
	private JTextField inRoomTemp = new JTextField(10);
	private JTextField inFridgeTemp = new JTextField(10);
	private JTextField inFreezerTemp = new JTextField(10);
	private JLabel roomTemp = new JLabel("Room temp");
	private JLabel desiredFridgeTemp = new JLabel("Desired fridge temp");
	private JLabel desiredFreezerTemp = new JLabel("Desired freezer temp");
	private JLabel status = new JLabel("Status");
	private JLabel fridgeLight = new JLabel("Fridge light <on/off>");
	private JLabel freezerLight = new JLabel("Freezer light <on/off>");
	private JLabel fridgeTemp = new JLabel("Fridge temp: ");
	private JLabel freezerTemp = new JLabel("Freezer temp: ");
	private JLabel fridgeState = new JLabel("Fridge <cooling/idle>");
	private JLabel freezerState = new JLabel("Freezer <cooling/idle>");

	/**
	 * Do the usual layout of the frame
	 */
	public GUIDisplay() {
		super("Refrigerator");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});
		
		
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel temps = new JPanel(new GridLayout(0,3,20,20));
		temps.add(roomTemp);
		temps.add(inRoomTemp);
		temps.add(setRoomTemp);
		temps.add(desiredFridgeTemp);
		temps.add(inFridgeTemp);
		temps.add(setFridgeTemp);
		temps.add(desiredFreezerTemp);
		temps.add(inFreezerTemp);
		temps.add(setFreezerTemp);
		
		JPanel doors = new JPanel(new GridLayout(0,2,20,20));
		doors.add(fridgeDoorOpener);
		doors.add(fridgeDoorCloser);
		doors.add(freezerDoorOpener);
		doors.add(freezerDoorCloser);
		
		JPanel states = new JPanel(new GridLayout(0,2,20,20));
		states.add(fridgeLight);
		states.add(freezerLight);
		states.add(fridgeTemp);
		states.add(freezerTemp);
		states.add(fridgeState);
		states.add(freezerState);
		
		getContentPane().add(Box.createRigidArea(new Dimension(20,20)));
		getContentPane().add(temps);	
		getContentPane().add(Box.createRigidArea(new Dimension(20,20)));
		getContentPane().add(doors);
		getContentPane().add(Box.createRigidArea(new Dimension(20,20)));
		getContentPane().add(states);	
		getContentPane().add(Box.createRigidArea(new Dimension(20,20)));
		getContentPane().add(states);
		getContentPane().add(Box.createRigidArea(new Dimension(20,20)));

		setRoomTemp.addActionListener(this);
		setFridgeTemp.addActionListener(this);
		setFreezerTemp.addActionListener(this);
		fridgeDoorOpener.addActionListener(this);
		fridgeDoorCloser.addActionListener(this);
		freezerDoorOpener.addActionListener(this);
		freezerDoorCloser.addActionListener(this);

		pack();
		setVisible(true);
	}

	/**
	 * Process the door buttons (closer and opener) and cook button by simply
	 * calling the Microwave object's methods.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(setRoomTemp)) {
			// set room temp
			if (inRoomTemp.getText() == null) {
				JOptionPane.showMessageDialog(null, "Set room temperature first!");
			}
		} else if (event.getSource().equals(setFridgeTemp)) {
			if (inFridgeTemp.getText() == null) {
				JOptionPane.showMessageDialog(null, "Set fridge temperature first!");
			}
			fridge.SetTemperature(Integer.parseInt(inFridgeTemp.getText()));
		} else if (event.getSource().equals(setFreezerTemp)) {
			if (inFridgeTemp.getText() == null) {
				JOptionPane.showMessageDialog(null, "Set fridge temperature first!");
			}
			freezer.SetTemperature(Integer.parseInt(inFridgeTemp.getText()));
		} else if (event.getSource().equals(fridgeDoorOpener)) {
			fridge.OpenDoor();
		} else if (event.getSource().equals(fridgeDoorCloser)){
			fridge.CloseDoor();
		}else if (event.getSource().equals(freezerDoorOpener)){
			freezer.OpenDoor();
		}else if (event.getSource().equals(freezerDoorCloser)){
			freezer.CloseDoor();
		}
	}

	/**
	 * @param Freezer object
	 */
	public void setFreezer(Freezer freezer){
		this.freezer = freezer;
	}
	
	/**
	 * @param Fridge object
	 */
	public void setFridge(Fridge fridge){
		this.fridge = fridge;
	}

	/**
	 * Turns the freezer light on
	 */
	public void turnFreezerLightOn(){
		freezerLight.setText("Freezer light <ON>");
	}

	/**
	 * Turns the freezer light off
	 */
	public void turnFreezerLightOff(){
		freezerLight.setText("Freezer light <OFF>");
	}
	
	/**
	 * Turns the fridge light on
	 */
	public void turnFridgeLightOn(){
		fridgeLight.setText("Fridge light <ON>");
	}

	/**
	 * Turns the fridge light off
	 */
	public void turnFridgeLightOff(){
		fridgeLight.setText("Fridge light <OFF>");
	}

	/**
	 * Show the current temperature of freezer
	 */
	public void freezerTemp(int value){
		freezerTemp.setText("Freezer temp: " + value);
	}
	
	/**
	 * Show the current temperature of fridge
	 */
	public void fridgeTemp(int value){
		fridgeTemp.setText("Fridge temp: " + value);
	}

	/**
	 * Indicate that state of the freezer
	 */
	public void setFreezerState(RefrigeratorUnit.States status){
		if(status == RefrigeratorUnit.States.COOLING){
			freezerState.setText("Freezer <COOLING>");
		} else if (status == RefrigeratorUnit.States.IDLE){
			freezerState.setText("Freezer <IDLE>");
		}
	}

	/**
	 * Indicate that state of the fridge
	 */
	public void setFridgeState(RefrigeratorUnit.States status){
		if(status == RefrigeratorUnit.States.COOLING){
			fridgeState.setText("Fridge <COOLING>");
		} else if (status == RefrigeratorUnit.States.IDLE){
			fridgeState.setText("Fridge <IDLE>");
		}
	}
}
