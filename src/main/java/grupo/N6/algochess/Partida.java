package grupo.N6.algochess;

import grupo.N6.algochess.unidades.Tablero;

public class Partida {

    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private boolean jugando;

    public Partida(Jugador jugador1, Jugador jugador2) {
        (this.jugador1 = jugador1).inicializarTurno();
        this.jugador2 = jugador2;
        this.tablero = new Tablero(20, 20);

        tablero.inicializarJuego(this.jugador1.obtenerUnidades(), this.jugador2.obtenerUnidades());

        this.jugando = true;
    }

    public void jugar(Accion accion) {
        if (!jugando) {
            throw new JuegoNoEstaActivoException();
        }
        accion.ejecutarSobre(this, this.tablero);
        terminarTurno();
    }

    private void terminarTurno() {
        this.hayGanador();
        this.obtenerJugadorActivo().terminarTurno();
        this.jugador1.cambiarTurno();
        this.jugador2.cambiarTurno();
    }

    private void hayGanador() {
        this.jugador1.sigueParticipando();
        this.jugador2.sigueParticipando();
    }
}