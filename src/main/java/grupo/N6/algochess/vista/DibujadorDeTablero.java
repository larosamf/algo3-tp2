/*package grupo.N6.algochess.vista;

import grupo.N6.algochess.Partida;
import grupo.N6.algochess.Tablero;
import grupo.N6.algochess.vista.eventos.CasilleroEventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;



public class DibujadorDeTablero {

    private final GridPane tablero;
    private final Partida partida;

    public DibujadorDeTablero(Partida partida, GridPane tablero) {
        this.tablero = tablero;
        this.partida = partida;
    }

    public void dibujarMapaConCasilleroHandler(VBox contenedor) {
        int base = 20; //pedirlo a Partida
        int altura = 20; //pedirlo a Partida

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                Button botonCasillero = new Button("");
                if ((i%2==0 && j%2==0) || (i%2==1 && j%2==1)) {
                	//color de fondo del boton negro
                }else {
                	//color de fondo del boton blanc
                }
                this.tablero.add(botonCasillero, j, i, 1, 1);
            }
        }
    }
}*/