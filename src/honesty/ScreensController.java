package honesty;

import java.io.IOException;
import java.util.HashMap;

import honesty.controllers.ControlledView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Pair;

public class ScreensController extends AnchorPane {
	
	private HashMap<String, Pair<ControlledView, Node>> screens = new HashMap<>();

	public Node getScreen(String key){
		return screens.get(key).getValue();
	}
	
	public ControlledView getControlledView(String key){
		return screens.get(key).getKey();
	}
	
	public void addScreen(String name, ControlledView controller, Node screen){
		screens.put(name, new Pair<ControlledView, Node>(controller, screen));
	}
	
	public boolean loadScreen(String name, String res) {
        try {
            FXMLLoader screenLoader = new FXMLLoader(getClass().getResource(res));
            Parent loadedScreen = screenLoader.load();
            ControlledView controller = (ControlledView) screenLoader.getController();
            controller.setControllerParent(this);
            addScreen(name, controller, loadedScreen);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public boolean setScreen(String name) {
        if (screens.get(name) != null) {
            if (!getChildren().isEmpty()) {
                getChildren().remove(0);
                getChildren().add(0, screens.get(name).getValue());
            } else {
                getChildren().add(screens.get(name).getValue());
            }
            return true;
        } else {
            System.out.println("Screen not loaded");
            return false;
        }
    }
	
	public boolean unloadScreen(String name) {
        if (screens.remove(name) == null) {
            System.out.println("Screen was not in hashmap");
            return false;
        } else {
            return true;
        }
    }
}
