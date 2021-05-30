package element;

import java.util.Random;

public class CreateArray {

	public Element[] createRandom(int length) {
		Random rd = new Random();
		Element[] arr = new Element[length];
		for (int i= 0; i < length; i++) {
			arr[i] = new Element(1+rd.nextInt(length));
			System.out.println(arr[i].getValue());
		}
		return arr;
		
	}
	public Element[] createSorted(int length, int order) {
		Element[] arr = new Element[length];
		for (int i = 0; i < length; i++) {
			if (order == 1)
				arr[i] = new Element(i+1);
			else if (order == -1)
				arr[i] = new Element(length - i);
		}
		for (int i= 0; i < length; i++) {
			System.out.println(arr[i].getValue());
		}

		return arr;
		
	}
	public Element[] createNearlySorted(int length, int order) {
		Element[] arr = createSorted(length, order);
		Random rd = new Random();
		int swap = 1 + rd.nextInt(3);
		for (int i = 0; i < swap; i++) {

			int a = rd.nextInt(length-1);
			int b = rd.nextInt(length-1);
			System.out.println(arr[a].getValue()+" "+arr[b].getValue());
			Element tmp = arr[a];
			arr[a] = arr[b];
			arr[b] = tmp;	
			System.out.println(arr[a].getValue()+" "+arr[b].getValue());
		}
		for (int i= 0; i < length; i++) {
			System.out.println(arr[i].getValue());
		}
		return arr;
	}
	public static void main(String[] args) {
		CreateArray crt = new CreateArray();
		crt.createNearlySorted(10,-1);
	}

}
