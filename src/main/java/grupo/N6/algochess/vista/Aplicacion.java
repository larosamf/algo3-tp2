package grupo.N6.algochess.vista;

import grupo.N6.algochess.Jugador;
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
        Scene escena1, escena2, escena3;
        Button guardarNombre1, guardarNombre2;
        Label lbljugador1,lbljugador2;
        TextField nombreJugador1, nombreJugador2;
        VBox contenedorNombre1, contenedorNombre2;
        BotonGuardarEventHandler botonEnviarEventHandler1, botonEnviarEventHandler2;
        TextoEventHandler textoEventHandler1, textoEventHandler2;
        
        //Creamos tablero
        GridPane tablero = new GridPane();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Partida partida = new Partida(jugador1, jugador2);
        DibujadorDeTablero(tablero);
        
        guardarNombre1 = new Button("Guardar Nombre Jugador 1");
        guardarNombre2 = new Button("Guardar Nombre Jugador 2");
        
        lbljugador1 = new Label("Nombre Jugador 1:");
        nombreJugador1 = new TextField("");
        contenedorNombre1 = new VBox();
        lbljugador2 = new Label("Nombre Jugador 2:");
        nombreJugador2 = new TextField("");
        contenedorNombre2 = new VBox();
        
        escena1 = new Scene(contenedorNombre1, 350, 300);
        escena2 = new Scene(contenedorNombre2, 350, 300);
        escena3 = new Scene(tablero, 370, 522);
        
        botonEnviarEventHandler1 = new BotonGuardarEventHandler(nombreJugador1, lbljugador1, jugador1, escenario, escena2);
        textoEventHandler1 = new TextoEventHandler(guardarNombre1);
        botonEnviarEventHandler2 = new BotonGuardarEventHandler(nombreJugador2, lbljugador2, jugador2, escenario, escena3);
        textoEventHandler2 = new TextoEventHandler(guardarNombre2);
        
        //Pedimos nombre del Jugador 1
        
        contenedorNombre1.getChildren().addAll(lbljugador1, nombreJugador1, guardarNombre1);
        guardarNombre1.setOnAction(botonEnviarEventHandler1);
        nombreJugador1.setOnKeyPressed(textoEventHandler1);
        
        
        //Pedimos nombre jugador 2
        
        contenedorNombre2.getChildren().addAll(lbljugador2, nombreJugador2, guardarNombre2);
        guardarNombre2.setOnAction(botonEnviarEventHandler2);
        nombreJugador2.setOnKeyPressed(textoEventHandler2);
        
        
        escenario.setTitle("AlgoChess");
        escenario.setMinHeight(250);
        escenario.setMinWidth(250);
        escenario.setScene(escena1);
        escenario.show();
    }

    public void DibujadorDeTablero(GridPane tablero) {

    	int base = 20; //pedirlo a Partida
        int altura = 20; //pedirlo a Partida

        for (int i = 0; i < altura; i++) {
        	for (int j = 0; j < base; j++) {
        		Button botonCasillero = new Button("");
                if ((i%2==0 && j%2==0) || (i%2==1 && j%2==1)) {
                	//color de fondo del boton negro
                	botonCasillero.setStyle("-fx-background-color: #a9a9a9");
                }else {
                	//color de fondo del boton blanco
                }
                tablero.add(botonCasillero, j, i, 1, 1);
            }
        }
    }
}