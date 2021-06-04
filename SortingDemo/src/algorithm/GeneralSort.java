package algorithm;

import element.Element;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public abstract class GeneralSort {
	private int width = 30;
	private int space = 50;
	protected Color CompareColor ;
	protected Color SortedColor;
	protected Color FinalColor;
	protected Color StartColor;
	public Transition[] transitions = new Transition[500];
	public int transitionsCount = 0;
	
	void swap(Element[] arr, int i, int j) {
		ParallelTransition pt = new ParallelTransition();
		Element tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		System.out.println("Swap:"+arr[i].getValue()+" "+ arr[j].getValue());
		pt.getChildren().addAll(arr[i].moveX(space*(i-j)),arr[j].moveX(space*(j-i)));
		transitions[transitionsCount] = pt;
		transitionsCount += 1;
	}
	void colorElements(Element[] arr, Color color, int...a) {
		ParallelTransition pt = new ParallelTransition();
		for (int i = 0; i < a.length; i++) {
			FillTransition ft = new FillTransition();
			ft.setDuration(Duration.millis(500));
			ft.setShape(arr[a[i]]);
			ft.setToValue(color);
		pt.getChildren().add(ft);
		}
		transitions[transitionsCount] = pt;
		transitionsCount += 1;
		
	};
	void colorArray(Element[] arr, Color color) {
		ParallelTransition pt = new ParallelTransition();
		for (int i = 0; i < arr.length; i++) {
			FillTransition ft = new FillTransition();
			ft.setDuration(Duration.millis(500));
			ft.setShape(arr[i]);
			ft.setToValue(color);
		pt.getChildren().add(ft);
		}
		transitions[transitionsCount] = pt;
		transitionsCount += 1;
		
	};

	
	public abstract Transition[] startSort(Element[] arr);
	public static void main(String[] args) {
		Element[] arr = {new Element(1),new Element(2),new Element(3),new Element(4)};
	}

}
