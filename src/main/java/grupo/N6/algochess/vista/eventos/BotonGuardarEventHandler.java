/*package grupo.N6.algochess.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class BotonGuardarEventHandler implements EventHandler<ActionEvent> {

    private TextField textField;
    private Label label;

    public BotonGuardarEventHandler(TextField textField, Label label) {
        this.textField = textField;
        this.label = label;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (this.textField.getText().trim().equals("")) {

            this.label.setText("Su nombre debe contener un caracter como mínimo");
            this.label.setTextFill(Color.web("#FF0000"));

        } else {

            this.label.setText(this.textField.getText());
            this.label.setTextFill(Color.web("#336600"));
            //mostrar tablero para colocar unidades
            
        }
    }
}*/