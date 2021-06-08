package algorithm;

import element.Element;
import javafx.animation.Transition;

public class QuickSort extends GeneralSort{

	private int partition(Element[] arr, int l, int h) {
		Element pivot = arr[h];
		colorElements(arr, CompareColor, h);
		int i = l - 1;
		for (int j = l; j < h; j++) {
			colorElements(arr, CompareColor, j);
			if (arr[j].getValue() < pivot.getValue()) {
				i++;
				swap(arr, i, j);
				colorElements(arr, StartColor, i);
			}
			else
				colorElements(arr, StartColor, j);
		}			
		swap(arr, h, i+1);
		colorElements(arr, SortedColor, i+1);
	return (i+1);	
	}
	private void quickSort(Element[] arr, int l, int h) {
		if (l<h) {
			int p = partition(arr, l, h);
			quickSort(arr, l, p-1);
			quickSort(arr, p+1, h);
		}
	}

	@Override
	public Transition[] startSort(Element[] arr) {
		quickSort(arr, 0, arr.length-1);
		colorArray(arr, SortedColor);
		return this.transitions;
	}

}
