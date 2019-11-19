package grupo.N6.algochess.main;

import grupo.N6.algochess.Inicializador;

import grupo.N6.algochess.Partida;

public class main {
    public static void main(String[] args){

        Inicializador inicializador = new Inicializador();

        inicializador.inicializarJugadores();

        Partida partida = inicializador.crearPartida();

        inicializador.iniciarEtapaDePosicionamiento(partida);

    }
}
