package org.example.javafx;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

import javafx.stage.Stage;

import java.io.InputStream;

public class Exercise2 extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Check boxes");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);

        InputStream icon = getClass().getResourceAsStream("/images/exercise2.png");
        assert icon != null;
        primaryStage.getIcons().add(new Image(icon));

        Button button = new Button("button");
        CheckBox checkBox = new CheckBox();
        TextArea textArea = new TextArea();

        CheckBox checkBoxButton = new CheckBox();
        CheckBox checkBox2 = new CheckBox();
        CheckBox checkBoxText = new CheckBox();

        checkBoxButton.setSelected(true);
        checkBox2.setSelected(true);
        checkBoxText.setSelected(true);

        checkBoxButton.setOnAction(actionEvent -> {
            button.setVisible(checkBoxButton.isSelected());
        });
        checkBox2.setOnAction(actionEvent -> {
            checkBox.setVisible(checkBox2.isSelected());
        });
        checkBoxText.setOnAction(actionEvent -> {
            textArea.setVisible(checkBoxText.isSelected());
        });

        HBox boxButton = new HBox (15, checkBoxButton, button);
        HBox boxCheckBox = new HBox(15, checkBox2, checkBox);
        HBox boxText = new HBox(15, checkBoxText, textArea);

        FlowPane root = new FlowPane(Orientation.VERTICAL ,20,15,boxButton,boxCheckBox,boxText);
        root.setAlignment(Pos.CENTER);
        Scene primaryScene = new Scene(root);
        primaryStage.setScene(primaryScene);

        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
