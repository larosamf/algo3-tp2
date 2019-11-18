package grupo.N6.algochess;

import grupo.N6.algochess.accionesDePartida.Accion;
import grupo.N6.algochess.exepciones.JuegoNoEstaActivoException;

public class Partida {

    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private boolean jugando;

    public Partida(Jugador jugador1, Jugador jugador2) {
        (this.jugador1 = jugador1).inicializarTurno();
        this.jugador2 = jugador2;
        this.tablero = new Tablero(20, 20);


        this.jugando = true;
    }

    public void jugar(Accion accion) {
        if (!jugando) {
            throw new JuegoNoEstaActivoException();
        }
        accion.ejecutarSobre(this, this.tablero);
        terminarTurno();
    }

    public Jugador obtenerJugadorActivo() {
        if (this.jugador1.estaActivo())
            return this.jugador1;
        return this.jugador2;
    }

    public void terminarTurno() {
        this.hayGanador();
        this.jugador1.terminarTurno();
        this.jugador2.terminarTurno();
        this.jugador1.cambiarTurno();
        this.jugador2.cambiarTurno();
    }

    private void hayGanador() {
        this.jugador1.sigueParticipando();
        this.jugador2.sigueParticipando();
    }

    public Tablero getTablero(){
        return(this.tablero);
    }

    private void inicializarPartida(Tablero tablero,Jugador jugador1, Jugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tablero = tablero;

    }

    public void actualizarEstadoDeUnidades() {
    	tablero.actualizarEstadoDeUnidades();
    }



}