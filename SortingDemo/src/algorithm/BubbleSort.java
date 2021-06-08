package algorithm;

import element.Element;
import javafx.animation.Transition;
import javafx.scene.paint.Color;

public class BubbleSort extends GeneralSort{

	
	private boolean swapped;
	
	private void compareElement(Element[] arr, int i, int j) {
		colorElements(arr, CompareColor, i, j);
		if (arr[i].getValue() > arr[j].getValue()) {
			swap(arr, i, j);
			swapped = true;
		}
		colorElements(arr, StartColor, i, j);

	}
	
	private void bubbleSort(Element[] arr) {
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

}
