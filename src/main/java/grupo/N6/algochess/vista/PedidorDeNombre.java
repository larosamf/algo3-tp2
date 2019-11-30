package grupo.N6.algochess.vista;


import grupo.N6.algochess.Jugador;
import grupo.N6.algochess.vista.eventos.BotonGuardarEventHandler;
import grupo.N6.algochess.vista.eventos.TextoEventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PedidorDeNombre {
Button guardarNombre1;
Label lbljugador1;
TextField nombreJugador1;
BotonGuardarEventHandler botonGuardarEventHandler1;
TextoEventHandler textoEventHandler1;
Stage escenario;
Scene escena;

	public PedidorDeNombre(int numeroDelJugador, Scene escenaPedirNombre, Stage escenario, Scene siguienteEscena, Jugador jugador) {

		this.escenario = escenario;
		this.escena = escenaPedirNombre;
		guardarNombre1 = new Button("Guardar Nombre");
		lbljugador1 = new Label("Nombre del jugador "+numeroDelJugador+": ");
		nombreJugador1 = new TextField("");
		botonGuardarEventHandler1 = new BotonGuardarEventHandler(nombreJugador1, lbljugador1, jugador, escenario, siguienteEscena);
		textoEventHandler1 = new TextoEventHandler(guardarNombre1);
	}

	public void pedir(VBox contenedorNombre1) {
		contenedorNombre1.getChildren().addAll(lbljugador1, nombreJugador1, guardarNombre1);
		guardarNombre1.setOnAction(botonGuardarEventHandler1);
		nombreJugador1.setOnKeyPressed(textoEventHandler1);
	}

}
