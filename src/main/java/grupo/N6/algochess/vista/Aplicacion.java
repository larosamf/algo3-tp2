/*package grupo.N6.algochess.vista;

import grupo.N6.algochess.Partida;
import grupo.N6.algochess.vista.eventos.BotonGuardarEventHandler;
import grupo.N6.algochess.vista.eventos.TextoEventHandler;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Aplicacion extends Application {
	
	
	
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage escenario) {
        
        Button guardar = new Button("Guardar");
        
        //Creamos tablero
        GridPane tablero = new GridPane();
        Partida partida = new Partida(null, null);
        DibujadorDeTablero vistaTablero = new DibujadorDeTablero(partida,tablero);

        //Pedimos nombre del Jugador 1
        Label lbljugador1 = new Label("Nombre Jugador 1:");
        TextField nombreJugador1 = new TextField("Ingrese su nombre");
        
        VBox contenedorNombre1 = new VBox();
        contenedorNombre1.getChildren().addAll(lbljugador1, nombreJugador1, guardar);
        
        BotonGuardarEventHandler botonEnviarEventHandler = new BotonGuardarEventHandler(nombreJugador1, lbljugador1);
        guardar.setOnAction(botonEnviarEventHandler);

        TextoEventHandler textoEventHandler = new TextoEventHandler(guardar);
        nombreJugador1.setOnKeyPressed(textoEventHandler);
        
        Scene escena1 = new Scene(contenedorNombre1, 300, 250);
        

        //Pedimos nombre jugador 2
        //Label lbljugador2 = new Label("Nombre Jugador 2:");
        //TextField nombreJugador2 = new TextField("Ingrese su nombre");
        
        //VBox contenedorNombre2 = new VBox();
        //contenedorNombre2.getChildren().addAll(lbljugador2, nombreJugador2);
        
        //Scene escena2 = new Scene(contenedorNombre2);
        
        
        escenario.setTitle("AlgoChess");
        escenario.setMinHeight(250);
        escenario.setMinWidth(250);
        escenario.setScene(escena1);
        //escenario.setScene(escena2);
        
        escenario.show();
    }
}*/