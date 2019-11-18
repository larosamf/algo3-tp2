package grupo.N6.algochess.main;

import grupo.N6.algochess.Inicializador;
import grupo.N6.algochess.Jugador;
import grupo.N6.algochess.Partida;

public class main {
    public static void main(String[] args){

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        Inicializador inicializador = new Inicializador();

        inicializador.inicializarJugadores(jugador1, jugador2);

        Partida partida = new Partida(jugador1, jugador2);

        inicializador.iniciarEtapaDePosicionamiento(partida);

    }
}
