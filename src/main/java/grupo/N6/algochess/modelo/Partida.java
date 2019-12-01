package grupo.N6.algochess.modelo;

import grupo.N6.algochess.modelo.accionesDePartida.Accion;
import grupo.N6.algochess.modelo.exepciones.JuegoNoEstaActivoException;
import grupo.N6.algochess.modelo.posicionables.unidades.Unidad;

public class Partida implements PartidaInterface {

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


    public void actualizarEstadoDeUnidades() {
    	tablero.actualizarEstadoDeUnidades();
    }

    public boolean puedeJugar(Unidad unidad) {
        return (this.obtenerJugadorActivo().lePertenece(unidad));
    }

    public String obtenerNombreDeUnidad(Coordenada coord) {
        return tablero.unidadEnCasillero(coord).decirNombre();
    }

    public int obtenerVidaDeUnidad(Coordenada coord) {
        return tablero.unidadEnCasillero(coord).getVida();
    }

    public int obtenerAtaqueDeUnidad(Coordenada coord) {
        return tablero.unidadEnCasillero(coord).getAtaque();
    }

    public int obtenerDistanciaDeAtaque(Coordenada coord) {
        return tablero.unidadEnCasillero(coord).getDistancia();

    }

    @Override
    public void inicializarPartida(Tablero tablero,Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tablero = tablero;

    }
}