package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class main2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane layout = new StackPane();
        Parent root = FXMLLoader.load(getClass().getResource("../login.fxml"));
                primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 550, 400));
        primaryStage.show();
      /*  Button button = new Button("Hello world");
        button.setOnAction(actionEvent -> {
            System.out.println(System.getProperty("java.version"));
        });
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 320, 240);
        stage.setScene(scene);
        stage.setTitle("Hello!");
        stage.show();*/










    }
    public static void main(String[] args) {
        launch(args);
    }

}


