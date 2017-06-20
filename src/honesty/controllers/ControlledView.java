package honesty.controllers;

import honesty.ScreensController;

public class ControlledView {

	private ScreensController parent;

	public void setControllerParent(ScreensController controller){
		parent = controller;
	}
	
	public ScreensController getControllerParent(){
		return parent;
	}
	
}
