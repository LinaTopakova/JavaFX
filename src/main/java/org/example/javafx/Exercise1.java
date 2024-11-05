package org.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;

import java.io.InputStream;

public class Exercise1 extends Application {

    private boolean flag = true; // Флаг для отслеживания направления

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Shifting Words");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);

        InputStream icon = getClass().getResourceAsStream("/images/exercise1.png");
        assert icon != null;
        primaryStage.getIcons().add(new Image(icon));

        TextField input1 = new TextField();
        TextField input2 = new TextField();
        input2.setDisable(true);
        Button button = new Button("->");

        button.setOnAction(actionEvent ->  {
            if (flag){
                input2.setText(input1.getText());
                input1.clear();
                //input2.setDisable(false);
                //input1.setDisable(true);
                button.setText("<-");
            }
            else{
                input1.setText(input2.getText());
                input2.clear();
                //input2.setDisable(true);
                //input1.setDisable(false);
                button.setText("->");
            }
            flag = !flag;
            input2.setDisable(flag);
            input1.setDisable(!flag);
        });

        FlowPane root = new FlowPane(20,0,input1,button,input2);
        root.setAlignment(Pos.CENTER);
        Scene primaryScene = new Scene(root);
        primaryStage.setScene(primaryScene);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
