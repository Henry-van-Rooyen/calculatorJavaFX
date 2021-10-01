package com.example.calculatorjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private Label result;
    private long firstNumber = 0;
    private String operator = "";
    private boolean start = true;
    private final Model model = new Model();

    @FXML
    public  void processNumbers(ActionEvent event){
        if (start){
            result.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        result.setText(result.getText() + value);
    }

    @FXML
    public void processOperators(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        if (!value.equals("=")){
            if (!operator.isEmpty())
                return;

            operator = value;
            firstNumber = Long.parseLong(result.getText());
            result.setText("");
        }else {
            if (operator.isEmpty())
                return;
            long secondNumber = Long.parseLong(result.getText());
            float output = model.calculate(firstNumber, secondNumber, operator);
            result.setText(String.valueOf(output));
            operator = "";
            start = true;
        }

    }
}
