package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Sample2Controller {
    public TextField textField;
    public Label label;

    public void onAction(ActionEvent actionEvent) {
        Logger.getLogger(Sample2Controller.class.getName()).log(Level.INFO, textField.getText());
        label.setText(textField.getText());
    }

    public void textChanged(InputMethodEvent inputMethodEvent) {
        textField.setOnInputMethodTextChanged(new EventHandler<InputMethodEvent>() {
            @Override
            public void handle(InputMethodEvent inputMethodEvent) {

            }
        });
        Logger.getLogger(Sample2Controller.class.getName()).log(Level.INFO, inputMethodEvent.getCommitted());
    }
}
