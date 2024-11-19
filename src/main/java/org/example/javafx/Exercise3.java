package org.example.javafx;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Exercise3 extends Application {

    public static class Menu {
        String name;
        int price;
        int count;

        Menu(String name, int price) {
            this.name = name;
            this.price = price;
            this.count = 1;
        }
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Menu Вкусно и точка");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(400);

        InputStream icon = getClass().getResourceAsStream("/images/exercise3.png");
        assert icon != null;
        primaryStage.getIcons().add(new Image(icon));

        List<Menu> menu = new ArrayList<>();
        Menu product;

        TextField cappuccino = new TextField("Капучино     -     100р");
        cappuccino.setEditable(false);
        cappuccino.setAlignment(Pos.CENTER);
        product = new Menu("Капучино",100);
        menu.add(product);
        cappuccino.setMinWidth(300);

        Button latte = new Button("Латте            -     100р");
        product = new Menu("Латте",110);
        menu.add(product);
        latte.setMinWidth(300);

        Button cocaCola = new Button("Кола              -     100р");
        product = new Menu("Кола",90);
        menu.add(product);
        cocaCola.setMinWidth(300);

        Button cheeseburger = new Button("Чизбургер     -     100р");
        product = new Menu("Чизбургер",150);
        menu.add(product);
        cheeseburger.setMinWidth(300);

        Button grandee = new Button("Гранд            -     100р");
        product = new Menu("Гранд",200);
        menu.add(product);
        grandee.setMinWidth(300);

        Button bigHit = new Button("Биг Хит          -     100р");
        product = new Menu("Биг Хит",180);
        menu.add(product);
        bigHit.setMinWidth(300);

        Button frenchFries = new Button("Картофель     -     100р");
        product = new Menu("Картофель Фри",120);
        menu.add(product);
        frenchFries.setMinWidth(300);

        Button nuggets = new Button("Наггетсы         -     100р");
        product = new Menu("Наггетсы",140);
        menu.add(product);
        nuggets.setMinWidth(300);

        TextArea textArea = new TextArea();
        textArea.setPrefWidth(350);

        Spinner<Integer> quantitySpinner = new Spinner<>(1, 10, 1);
        HBox box2 = new HBox(10,cappuccino,quantitySpinner);

        VBox box = new VBox(0,box2 , latte, cocaCola, cheeseburger, grandee, bigHit, frenchFries, nuggets);
        box.setLayoutX(150);
        box.setLayoutY(20);

        HBox box1 = new HBox(100,box,textArea);
        Scene primaryScene = new Scene(box1);

        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }

}