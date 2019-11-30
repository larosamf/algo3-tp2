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
        Scene escena1, escena2, escenaTablero;
        VBox contenedorNombre1, contenedorNombre2;
        contenedorNombre1 = new VBox();
        contenedorNombre2 = new VBox();
        escena1 = new Scene(contenedorNombre1, 350, 300);
        escena2 = new Scene(contenedorNombre2, 350, 300);
        
        //Creamos tablero
        GridPane tablero = new GridPane();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Partida partida = new Partida(jugador1, jugador2);
        DibujadorDeTablero dibujadorTablero = new DibujadorDeTablero(partida, tablero);
        dibujadorTablero.dibujarConCasilleroHandler();

        escenaTablero = new Scene(tablero, 370, 522);
        
        //Pedimos nombre del Jugador 1
        PedidorDeNombre pedidorNombre1 = new PedidorDeNombre(1, escena1, escenario, escena2, jugador1);
        pedidorNombre1.pedir(contenedorNombre1);
        
        //Pedimos nombre jugador 2
        PedidorDeNombre pedidorNombre2 = new PedidorDeNombre(2, escena2, escenario, escenaTablero, jugador2);
        pedidorNombre2.pedir(contenedorNombre2);        
        
        escenario.setTitle("AlgoChess");
        escenario.setMinHeight(250);
        escenario.setMinWidth(250);
        escenario.setScene(escena1);
        escenario.show();
    }
}