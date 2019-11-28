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
    
    public Jugador obtenerGanador() {
    	if (this.hayGanador()) {
    		if (jugador1.sigueParticipando())
    			return jugador1;
    		return jugador2;
    	}
    	return null;
    }
    
    public void terminarTurno() {
        if (this.hayGanador()) {
        	this.terminarJuego();
        }
        this.actualizarEstadoDeUnidades();
        this.jugador1.cambiarTurno();
        this.jugador2.cambiarTurno();
    }

    private void terminarJuego() {
		this.jugando = false;
	}
    

	private boolean hayGanador() {
        return (!this.jugador1.sigueParticipando() || !this.jugador2.sigueParticipando());
    }

    public Tablero getTablero(){
        return(this.tablero);
    }

    public void actualizarEstadoDeUnidades() {
    	tablero.actualizarEstadoDeUnidades();
    }



}