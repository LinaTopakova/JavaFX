package org.example.javafx;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.InputStream;

public class Exercise3 extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Menu Вкусно и точка");
        primaryStage.setWidth(600);
        primaryStage.setHeight(800);

        InputStream icon = getClass().getResourceAsStream("/images/exercise3.png");
        assert icon != null;
        primaryStage.getIcons().add(new Image(icon));

        Button cappuccino = new Button("Капучино");
        cappuccino.setMinWidth(300);
        Button latte = new Button("Латте");
        latte.setMinWidth(300);
        Button cocaCola = new Button("Кола");
        cocaCola.setMinWidth(300);
        Button cheeseburger = new Button("Чизбургер");
        cheeseburger.setMinWidth(300);
        Button grandee = new Button("Гранд");
        grandee.setMinWidth(300);
        Button bigHit = new Button("Биг Хит");
        bigHit.setMinWidth(300);
        Button frenchFries = new Button("Картофель Фри");
        frenchFries.setMinWidth(300);
        Button nuggets = new Button("Наггетсы");
        nuggets.setMinWidth(300);

        FlowPane root = new FlowPane(Orientation.VERTICAL ,cappuccino, latte, cocaCola, cheeseburger, grandee, bigHit, frenchFries, nuggets);
        Scene primaryScene = new Scene(root);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }

}