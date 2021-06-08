package algorithm;

import element.Element;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;


public class InsertionSort extends GeneralSort {
	


	private void insertionSort(Element[] arr) {
		for (int i = 1; i < arr.length; i++) {
			Element key = arr[i];
			colorElements(arr, CompareColor, i);
			ParallelTransition pt = new ParallelTransition();
			int j = i-1;
			while(j >= 0 && key.getValue() < arr[j].getValue()) {
				colorElements(arr, CompareColor, j);
				colorElements(arr, StartColor, j);
				pt.getChildren().add(arr[j].moveX(50));
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
			pt.getChildren().add(key.moveX(-50*(i-j-1)));
			this.transitions[transitionsCount] = pt;
			transitionsCount += 1;
			colorElements(arr, StartColor, j+1);
		}

	}
	@Override
	public Transition[] startSort(Element[] arr) {
		insertionSort(arr);
		colorArray(arr, SortedColor);
		return this.transitions;
	}

}


