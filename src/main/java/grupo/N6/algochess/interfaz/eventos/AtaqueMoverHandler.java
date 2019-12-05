package grupo.N6.algochess.interfaz.eventos;

import grupo.N6.algochess.Algochess;
import grupo.N6.algochess.Jugador;
import grupo.N6.algochess.exepciones.FinalException;
import grupo.N6.algochess.exepciones.MovimientoInvalidoException;
import grupo.N6.algochess.interfaz.CasilleroVista;
import grupo.N6.algochess.interfaz.UnidadVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

import static grupo.N6.algochess.interfaz.Vista.posTablero;


public class AtaqueMoverHandler implements EventHandler<MouseEvent> {

    UnidadVista unidadVista;
    Algochess partida;
    CasilleroVista[][] tablero;
    int x;
    int y;

    public AtaqueMoverHandler(UnidadVista unidadVista, Algochess partida, CasilleroVista[][] tablero, int x, int y) {

        this.unidadVista = unidadVista;
        this.partida = partida;
        this.tablero = tablero;
        this.x = x;
        this.y = y;
    }

    @Override
    public void handle(MouseEvent event) {
        int newX = posTablero(unidadVista.getLayoutX());
        int newY = posTablero(unidadVista.getLayoutY());
        if (event.getButton() == MouseButton.PRIMARY) {
            try {
                partida.mover(x + 1, y + 1, newX + 1, newY + 1);
                unidadVista.mover(newX, newY);
                CasilleroVista casillero = tablero[unidadVista.posX][unidadVista.posY];
                casillero.borrarUnidad();
                casillero = tablero[newX][newY];
                casillero.agregarUnidad(unidadVista);
            } catch (Exception c) {
                unidadVista.mover(unidadVista.posX, unidadVista.posY);
            }
        } else if (event.getButton() == MouseButton.SECONDARY) {
            try {
                partida.atacar(newX + 1, newY + 1, unidadVista.posX + 1, unidadVista.posY + 1);
                unidadVista.mover(unidadVista.posX, unidadVista.posY);
            }catch (Exception s) {
                unidadVista.mover(unidadVista.posX, unidadVista.posY);
            }

        }

    }
}

