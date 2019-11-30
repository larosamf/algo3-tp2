package grupo.N6.algochess.vista.eventos;

import grupo.N6.algochess.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BotonGuardarEventHandler implements EventHandler<ActionEvent> {

    private TextField textField;
    private Label label;
    private Jugador jugador;
    private Stage escenario;
	private Scene escenaSiguiente;

    public BotonGuardarEventHandler(TextField textField, Label label, Jugador jugador, Stage escenario, Scene escenaSiguiente) {
        this.textField = textField;
        this.label = label;
        this.jugador = jugador;
        this.escenario = escenario;
		this.escenaSiguiente = escenaSiguiente;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if (this.textField.getText().trim().equals("")) {

            this.label.setText("Su nombre debe contener un caracter como mínimo");
            this.label.setTextFill(Color.web("#FF0000"));

        } else {
        	
            this.label.setText(this.textField.getText());
            this.label.setTextFill(Color.web("#336600"));
            this.jugador.setNombre(this.textField.getText());
            escenario.setScene(escenaSiguiente);
            
        }
    }
}