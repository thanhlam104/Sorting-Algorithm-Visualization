package element;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Element extends Rectangle {
	private int value;
	
	public Element(int i) {
		this.value = i;
	}
	public int getValue() {
		return this.value;
	}
	  public TranslateTransition moveX(int x) {
		    TranslateTransition t = new TranslateTransition(Duration.millis(100), this);
		    t.setByX(x);
		    return t; 
	  }

}
