package algorithm;

import element.Element;
import javafx.animation.Transition;
import javafx.scene.paint.Color;

public class BubbleSort extends GeneralSort{
	private Color StartColor = Color.GRAY;
	private Color CompareColor = Color.PLUM;
	private Color SortedColor = Color.LIGHTSTEELBLUE;
	
	private boolean swapped;
	
	public BubbleSort() {
		this.transitions = new Transition[500];
		this.transitionsCount = 0;
	}
	public void compareElement(Element[] arr, int i, int j) {
		colorElements(arr, CompareColor, i, j);
		if (arr[i].getValue() > arr[j].getValue()) {
			swap(arr, i, j);
			swapped = true;
		}
		colorElements(arr, StartColor, i, j);

	}
	
	public void bubbleSort(Element[] arr) {
		for (int i = 0; i< arr.length; i++) {
			swapped = false;
			for (int j = 0; j < arr.length-i-1; j++) {
				compareElement(arr, j, j+1);
			}
			colorElements(arr, SortedColor, arr.length-i-1);
			if (!swapped) 
				break;
		}
	}
	
	@Override
	public Transition[] startSort(Element[] arr) {
		bubbleSort(arr);
		colorArray(arr, SortedColor);
		return this.transitions;
	}
	public static void main(String[] args) {
		Element[] arr = {new Element(1),new Element(4),new Element(3),new Element(2)};
		BubbleSort sort = new BubbleSort();
		sort.bubbleSort(arr);
	}
}
