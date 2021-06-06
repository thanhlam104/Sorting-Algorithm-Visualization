package application;

import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

import algorithm.*;
import element.CreateArray;
import element.Element;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SortController {
	private int width = 30;
	private int space = 50;
	private Element[] arr;
	
    @FXML
    private TextField textInput;

    @FXML
    private Button btnConfirm;

    @FXML
    private ChoiceBox<Integer> cbLength;
    
    @FXML
    private ChoiceBox<String> cbType;

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnSort;

    @FXML
    private Button btnMenu;

    @FXML
    private Pane mainPane;

    @FXML
    void btnBackPressed(ActionEvent event) throws IOException {
    	Stage stage = (Stage) btnMenu.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("/application/MainMenu.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Sorting Algorithm");
		stage.setScene(scene);
    }

    @FXML
    void btnConfirmPressed(ActionEvent event) {
    	try {
    	String[] arrText = textInput.getText().split(",");
    	if (arrText.length < 16) {
    	this.arr = new Element[arrText.length];
    	for (int i = 0; i< arrText.length; i++) {
    		this.arr[i]= new Element(Integer.parseInt(arrText[i]));
    	}
    	addElements(arr);
    	} else {
    		JOptionPane.showMessageDialog(null, "Number of elements in array cannot exceed 15");
    	}

    	} catch (NumberFormatException e) {
    		JOptionPane.showMessageDialog(null, "Please input an array of integers, separated by \",\" and contains no space");
    	}
    }

    @FXML
    void btnCreatePressed(ActionEvent event) { 
    	int arrLength = cbLength.getSelectionModel().getSelectedItem();
    	String arrType = cbType.getSelectionModel().getSelectedItem();
		CreateArray crt = new CreateArray();
		if (arrType == "Random Array")
			arr = crt.createRandom(arrLength);
		else if (arrType == "Nearly Sorted Array")
			arr = crt.createNearlySorted(arrLength,1);
		else if (arrType == "Ascending Sorted Array") 
			arr = crt.createSorted(arrLength, 1);
		else if (arrType == "Descending Sorted Array")
			arr = crt.createSorted(arrLength, -1);
    	addElements(arr);
    }
    
    void addElements(Element[] arr) {
    	mainPane.getChildren().clear();
        for (int i = 0; i < arr.length; i++) {
            arr[i].setFill(Color.GRAY);
            
            arr[i].setWidth(width);
            arr[i].setX((mainPane.getWidth()-space*arr.length+space-width)/2 + i * space); 
            
            arr[i].setHeight(mainPane.getHeight()/getMax(arr)*arr[i].getValue());
            arr[i].setLayoutY(mainPane.getHeight() - arr[i].getHeight());
            mainPane.getChildren().add(arr[i]);
          }
    }
    int getMax(Element[] arr) {
    	int max = 0;
    	for (Element e : arr) {
    		if (e.getValue() > max)
    			max = e.getValue();
    	}
    	return max;
    }

    @FXML
    void btnSortPressed(ActionEvent event) {
    	String sortType = btnSort.getText();
    	if (sortType.equals("BUBBLE SORT")) {
    		BubbleSort sort = new BubbleSort();
        	SequentialTransition st = new SequentialTransition();
        	Transition[] trans = sort.startSort(arr);
        	for (int i= 0; i < sort.transitionsCount; i++) {
        		st.getChildren().add(trans[i]);
        	}
        	st.play();
    	}
    	else if (sortType.equals("QUICK SORT")) {
    		QuickSort sort = new QuickSort();
        	SequentialTransition st = new SequentialTransition();
        	Transition[] trans = sort.startSort(arr);
        	for (int i= 0; i < sort.transitionsCount; i++) {
        		st.getChildren().add(trans[i]);
        	}
        	st.play();
    	}
    	else {
    		InsertionSort sort = new InsertionSort();
        	SequentialTransition st = new SequentialTransition();
        	Transition[] trans = sort.startSort(arr);
        	for (int i= 0; i < sort.transitionsCount; i++) {
        		st.getChildren().add(trans[i]);
        	}
        	st.play();
    	}


    }
    @FXML
    private void initialize() {
    	ObservableList<Integer> lengthList = FXCollections.observableArrayList();
    	for (int i = 1; i<16; i++) {
    		lengthList.add(i);
    	}
    	cbLength.setItems(lengthList);
    	ObservableList<String> typeList = FXCollections.observableArrayList();
    	typeList.add("Random Array");
    	typeList.add("Nearly Sorted Array");
    	typeList.add("Ascending Sorted Array");
    	typeList.add("Descending Sorted Array");
    	cbType.setItems(typeList);
    	cbType.setValue("Random Array");
    	cbLength.setValue(10);
    }

}
