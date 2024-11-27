package org.example.javafx;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
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
            this.count = 0;
        }
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Menu Вкусно и точка");
        primaryStage.setWidth(800);
        primaryStage.setHeight(450);

        InputStream icon = getClass().getResourceAsStream("/images/exercise3.png");
        assert icon != null;
        primaryStage.getIcons().add(new Image(icon));

        List<Menu> menu = initialization();
        //List<Menu> order = new ArrayList<>();
        List<TextField> textFieldList = new ArrayList<>();

        GridPane gridpane = new GridPane();
        gridpane.setHgap(10); // Расстояние в 10 пикселей между столбцами
        gridpane.setVgap(10);

        TextArea text = new TextArea();
        text.setEditable(false);
        text.setMaxWidth(300);
        text.setMaxHeight(300);

        for (Menu product:menu){
            TextField textProduct = new TextField(product.name + " - " + product.price);
            textProduct.setEditable(false);
            textProduct.setAlignment(Pos.CENTER);
            textProduct.setMinWidth(300);

            Button plus = new Button("+");

            TextField count = new TextField(String.valueOf(product.count));
            count.setAlignment(Pos.CENTER);
            count.setEditable(false);
            count.setMaxSize(30, 30);
            count.setMinSize(30,30);
            textFieldList.add(count);

            Button minus = new Button("-");
            plus.setOnAction(event -> plusToOrder(product,count));
            minus.setOnAction(event -> minusToOrder(product,count));
            int countRow = gridpane.getRowCount();
            gridpane.add(textProduct,0, countRow);
            gridpane.add(plus,1, countRow);
            gridpane.add(count,2, countRow);
            gridpane.add(minus,3, countRow);

        }

        Button order = new Button ("Заказать");
        Button reset = new Button ("Сбросить");
        order.setOnAction(event -> order(menu, text, order));
        reset.setOnAction(even -> reset(menu, text, order,textFieldList));
        HBox boxButton = new HBox(30, order, reset);
        boxButton.setAlignment(Pos.CENTER);

        VBox box = new VBox(10,gridpane,boxButton);
        box.setLayoutX(150);
        box.setLayoutY(20);

        HBox box1 = new HBox(50,box,text);

        Scene primaryScene = new Scene(box1);


        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }

    private List<Menu> initialization() {
        List<Menu> menu = new ArrayList<>();
        Menu product;

        product = new Menu("Капучино",100);
        menu.add(product);

        product = new Menu("Латте",110);
        menu.add(product);

        product = new Menu("Кола",90);
        menu.add(product);

        product = new Menu("Чизбургер",150);
        menu.add(product);

        product = new Menu("Гранд",200);
        menu.add(product);

        product = new Menu("Биг Хит",180);
        menu.add(product);

        product = new Menu("Картофель Фри",120);
        menu.add(product);

        product = new Menu("Наггетсы",140);
        menu.add(product);

        return menu;
    }

    void plusToOrder(Menu product,TextField count){
        if(product.count < 99){
            product.count++;
            count.setText(String.valueOf(product.count));
        }
        //System.out.println(product.count);
    }

    void minusToOrder(Menu product,TextField count){
        if(product.count > 0){
            product.count--;
            count.setText(String.valueOf(product.count));
        }
    }

    void order(List<Menu> menu, TextArea text, Button button){
        text.setWrapText(true);
        int sum = 0;
        for(Menu product : menu){
            if(product.count!=0){
                String newText = String.valueOf(product.count) + "X " + product.name + "    " + String.valueOf(product.price * product.count);
                text.appendText(newText + "\n");
                sum += product.count* product.price;
            }

        }

        text.appendText("Итого:  "+ String.valueOf(sum));
        button.setDisable(true);
    }

    void reset(List<Menu> menu, TextArea text, Button button, List<TextField> textFields){
        for(Menu product: menu){
            product.count = 0;
        }
        for(TextField textField: textFields){
            textField.setText("0");
        }
        text.clear();
        button.setDisable(false);

    }
}