package org.example.javafx;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
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
        primaryStage.setWidth(800);
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

        TextField latte = new TextField("Латте            -     100р");
        latte.setEditable(false);
        latte.setAlignment(Pos.CENTER);
        product = new Menu("Латте",110);
        menu.add(product);
        latte.setMinWidth(300);

        TextField cocaCola = new TextField("Кола              -     100р");
        cocaCola.setEditable(false);
        cocaCola.setAlignment(Pos.CENTER);
        product = new Menu("Кола",90);
        menu.add(product);
        cocaCola.setMinWidth(300);

        TextField cheeseburger = new TextField("Чизбургер     -     100р");
        cheeseburger.setEditable(false);
        cheeseburger.setAlignment(Pos.CENTER);
        product = new Menu("Чизбургер",150);
        menu.add(product);
        cheeseburger.setMinWidth(300);

        TextField grandee = new TextField("Гранд            -     100р");
        grandee.setEditable(false);
        grandee.setAlignment(Pos.CENTER);
        product = new Menu("Гранд",200);
        menu.add(product);
        grandee.setMinWidth(300);

        TextField bigHit = new TextField("Биг Хит          -     100р");
        bigHit.setEditable(false);
        bigHit.setAlignment(Pos.CENTER);
        product = new Menu("Биг Хит",180);
        menu.add(product);
        bigHit.setMinWidth(300);

        TextField frenchFries = new TextField("Картофель     -     100р");
        frenchFries.setEditable(false);
        frenchFries.setAlignment(Pos.CENTER);
        product = new Menu("Картофель Фри",120);
        menu.add(product);
        frenchFries.setMinWidth(300);

        TextField nuggets = new TextField("Наггетсы         -     100р");
        nuggets.setEditable(false);
        nuggets.setAlignment(Pos.CENTER);
        product = new Menu("Наггетсы",140);
        menu.add(product);
        nuggets.setMinWidth(300);

        //Text textArea = new Text();
        //textArea.setPrefWidth(350);
        TextArea text = new TextArea();
        text.setEditable(false);
        text.setMaxWidth(300);
        text.setMaxHeight(300);


        Spinner<Integer> quantitySpinner1 = new Spinner<>(0, 69, 0);
        HBox box2 = new HBox(10,cappuccino,quantitySpinner1);

        Spinner<Integer> quantitySpinner2 = new Spinner<>(0, 69, 0);
        HBox box3 = new HBox(10,latte,quantitySpinner2);

        Spinner<Integer> quantitySpinner3 = new Spinner<>(0, 69, 0);
        HBox box4 = new HBox(10,cocaCola,quantitySpinner3);

        Spinner<Integer> quantitySpinner4 = new Spinner<>(0, 69, 0);
        HBox box5 = new HBox(10,cheeseburger,quantitySpinner4);

        Spinner<Integer> quantitySpinner5 = new Spinner<>(0, 69, 0);
        HBox box6 = new HBox(10,grandee,quantitySpinner5);

        Spinner<Integer> quantitySpinner6 = new Spinner<>(0, 69, 0);
        HBox box7 = new HBox(10,bigHit,quantitySpinner6);

        Spinner<Integer> quantitySpinner7 = new Spinner<>(0, 69, 0);
        HBox box8 = new HBox(10,frenchFries,quantitySpinner7);

        Spinner<Integer> quantitySpinner8 = new Spinner<>(0, 69, 0);
        HBox box9 = new HBox(10,nuggets,quantitySpinner8);

        Button button1 = new Button ("Заказать");
        Button button2 = new Button ("Сбросить");
        VBox boxButton = new VBox(15, button1, button2);
        boxButton.setAlignment(Pos.CENTER);

        VBox box = new VBox(10,box2 , box3, box4, box5, box6, box7, box8, box9,boxButton);
        box.setLayoutX(150);
        box.setLayoutY(20);

        HBox box1 = new HBox(50,box,text);

        Scene primaryScene = new Scene(box1);


        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }

    private List<Menu> initialization() {
        List<Menu> menu = new ArrayList<>();


        return menu;
    }

}