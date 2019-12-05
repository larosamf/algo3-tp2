package grupo.N6.algochess;

import grupo.N6.algochess.accionesDePartida.Accion;
import grupo.N6.algochess.exepciones.JuegoNoEstaActivoException;
import grupo.N6.algochess.posicionables.unidades.Batallon;
import grupo.N6.algochess.posicionables.unidades.Unidad;

public class Partida {

    protected Tablero tablero;
    protected Jugador jugador1;
    protected Jugador jugador2;
    protected boolean jugando;

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
        this.tablero.cambiarTurno();
    }

    private void terminarJuego() {
		this.jugando = false;
	}

	public boolean hayGanador() {
        return (!this.jugador1.sigueParticipando() || !this.jugador2.sigueParticipando());
    }

    public void actualizarEstadoDeUnidades() {
    	tablero.actualizarEstadoDeUnidades();
    }

	public Unidad obtenerUnidadDePosicion(Coordenada ubicacion) {
		return tablero.unidadEnCasillero(ubicacion);
	}

	public Casillero obtenerCasillero(int x, int y) {
		return tablero.localizarCasillero(new Coordenada(x,y));
	}

	public Batallon obtenerBatallon(int x, int y) {
		return tablero.unidadEnCasillero(new Coordenada(x,y)).obtenerBatallon();
	}


}