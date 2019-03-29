package zadanie4.calculator;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
	
	private static Action oper;
	
	public static void main(String[] args) {

		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane root = new GridPane();
		TextField text = new TextField();
		text.setEditable(false);
		root.add(text, 0, 0);
		
		
		GridPane numbers = new GridPane();
		for (int i=0; i<10; i++) {
			Button btn = new Button(String.valueOf(i));
			btn.setOnMouseClicked(e -> text.appendText(btn.getText()));
			numbers.add(btn, i, 0);
		}
		root.add(numbers, 0, 1);
		
		VBox operations = new VBox();
		for (Action action : Action.values()) {
			Button btn = new Button(action.getSign());
			btn.setUserData(action);
			btn.setOnMouseClicked(e -> {
				App.oper = action;
				text.appendText(action.getSign());
			}); 
			operations.getChildren().add(btn);
		}
		Button clr = new Button("clr");
		clr.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				text.clear();
			}
		});
		operations.getChildren().add(clr);
		Button res = new Button("=");
		res.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				OperationFactory factory = new OperationFactory();
				String a,b;
				int pos1 = text.getText().indexOf(App.oper.getSign());
				a = text.getText().substring(0, pos1);
				b = text.getText().substring(pos1 + 1);
				double result = factory.getOperation(App.oper).calculate(Double.valueOf(a), Double.valueOf(b));
				text.setText(String.valueOf(result));
			}
		});
		
		operations.getChildren().add(res);
		root.add(operations, 1, 1);
		
		primaryStage.setScene(new Scene(root, 300, 500));
		primaryStage.show();
	}

}
