package org.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Exercise4 extends Application {

    private TextField textField;
    private String input1 = "";
    private String input2 = "";
    private String operator = "";
    private double result = 0;
    private boolean point = true;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Calculator");
        primaryStage.setWidth(305);
        primaryStage.setHeight(500);
        primaryStage.setResizable(false);

        InputStream icon = getClass().getResourceAsStream("/images/exercise4.png");
        assert icon != null;
        primaryStage.getIcons().add(new Image(icon));

        textField = new TextField();
        textField.setEditable(false);
        textField.setMinWidth(305);
        textField.setMinHeight(125);
        textField.setStyle("-fx-alignment: CENTER-RIGHT; -fx-font-size: 20px;");

        List<String> buttonsText = initialization();
        GridPane gridpane = new GridPane();

        Button button;
        String text;
        int index = 0; // Индекс для доступа к элементам списка
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                text = buttonsText.get(index);
                button = new Button(text);

                switch(text){
                    case ".":
                        gridpane.add(button, 0, 3);
                        button.setOnAction(event -> addValue("."));
                        col--;
                        break;
                    case "0":
                        gridpane.add(button, 1, 3);
                        col--;
                        button.setOnAction(event -> addValue("0"));
                        break;
                    case "=":
                        gridpane.add(button, 2, 3);
                        button.setOnAction(event -> calculate());
                        col--;
                        break;
                    case "+":
                        gridpane.add(button, 4, 0);
                        button.setOnAction(event -> setOperator("+"));
                        col--;
                        break;
                    case "-":
                        gridpane.add(button, 4, 1);
                        button.setOnAction(event -> setOperator("-"));
                        col--;
                        break;
                    case "*":
                        gridpane.add(button, 4, 2);
                        button.setOnAction(event -> setOperator("*"));
                        col--;
                        break;
                    case "/":
                        gridpane.add(button, 4, 3);
                        button.setOnAction(event -> setOperator("/"));
                        col--;
                        break;
                    default:
                        gridpane.add(button, col, row);
                        String finalText = text;
                        button.setOnAction(event -> addValue(finalText));
                        break;
                }
                button.setMinSize(70,70);
                index++;
            }
        }

        gridpane.setMinSize(305, 300);
        gridpane.setVgap(2); // Вертикальные отступы между кнопками
        gridpane.setHgap(2);

        Button clear = new Button("Clear");
        clear.setOnAction(event -> clear());
        clear.setMinSize(305,20);

        VBox box = new VBox(textField,clear ,gridpane);

        Scene primaryScene = new Scene(box,300,500);


        primaryStage.setScene(primaryScene);

        primaryStage.show();
    }

    private List<String> initialization() {
        List<String> list = new ArrayList<>();
        list.add(".");
        list.add("=");
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");
        list.add("0");
        for (int i = 9; i > 0; i--) {
            list.add(String.valueOf(i));
        }
        //System.out.println(list);
        return list;
    }

    void clear(){
        textField.clear();
        input1 = "";
        input2 = "";
        operator = "";
    }

    void addValue(String value) {
        if (operator.isEmpty()) {
            if(value.equals(".") && (!point || input1.isEmpty())) {
                return;
            } else if(value.equals(".") && point && !input1.isEmpty()){
                input1+=value;
                point = false;
                textField.setText(input1);
                return;
            }
            if (input1.equals("0") && value.equals("0")) {
                return;
            } else if (!value.equals("0") && input1.equals("0")) {
                input1 = value;
            } else {
                input1 += value;
            }
            textField.setText(input1);
        } else {

            if(value.equals(".") && (!point || input2.isEmpty())) {
                return;
            } else if(value.equals(".") && point && !input1.isEmpty()){
                input2+=value;
                point = false;
                textField.setText(input2);
                return;
            }
            if (input2.equals("0") && value.equals("0")) {
                return;
            } else if (!value.equals("0") && input2.equals("0")) {
                input2 = value;
            } else {
                input2 += value;
            }
            textField.setText(input2);
        }
    }

    void setOperator(String op){
        if (!input1.isEmpty()) {
            operator = op;
            textField.setText(input1 + " " + operator);
            point = true;
        }
    }

    void calculate(){
        if(!input1.isEmpty() && !operator.isEmpty()){
            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textField.setText("Error: Division by zero");
                        input2 = "";
                        operator = "";
                        return;
                    }
                    break;
            }

            textField.setText(String.valueOf(result));
            input1 = String.valueOf(result); // Позволяет продолжить вычисления с результатом
            input2 = "";
            operator = "";
        }
    }
}