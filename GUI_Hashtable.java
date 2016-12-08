package aufgabenblatt11;

import aufgabenblatt11.Hashtable;
import aufgabenblatt11.Hashtable.Item;

import java.util.Iterator;
import java.util.PriorityQueue;

import aufgabenblatt10.Main;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI_Hashtable extends Application {
	private Hashtable hashtable = new Hashtable();
	String filename="/home/tali/Desktop/webblog.txt" ;
	private FileGenerator file= new FileGenerator(1000,filename);

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Title
		primaryStage.setTitle("Web blog Information");
		
		//ListView
		ObservableList<String> items = FXCollections.observableArrayList();
		ObservableList<String> data = FXCollections.observableArrayList();
		ListView<String> list = new ListView<String>(data);
		list.setPrefSize(200, 400);
		list.setEditable(true);
		PriorityQueue<Item> queue = hashtable.writeItem(filename);
		hashtable.load(filename);
		Iterator<Item> it = queue.iterator();
		while (it.hasNext()) {
			items.add(it.next().getKey());
		}
		data.add("Please double click to choose the IP adress\n And click to confirm output");
		list.setItems(data);
		list.setCellFactory(ComboBoxListCell.forListView(items));
        
		//Button output = new Button("OUTPUT");
		//output.setStyle("-fx-text-fill: black; -fx-base: #009900");
		Text textField = new Text("OUTPUT");
		textField.setStyle("-fx-text-fill: black");
		
		//Event Handle
		list.setOnMouseClicked(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent me){
				String a=list.getSelectionModel().getSelectedItem();
				if(a!="Please double click to choose the IP adress"){
					int index = hashtable.code(a);
					textField.setText(hashtable.getHash()[index].getData());
				}
			}
		
		});
		
		//Display
		StackPane root = new StackPane();
		root.getChildren().add(list);
		root.getChildren().add(textField);
		primaryStage.setScene(new Scene(root, 500, 500));
		primaryStage.show();

	}
    
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
