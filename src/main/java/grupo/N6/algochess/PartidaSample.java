package grupo.N6.algochess;

public class PartidaSample extends Partida implements PartidaInterface{

        public PartidaSample(Jugador jugador1, Jugador jugador2) {

            super(jugador1, jugador2);
            this.inicializarPartida();
        }

        @Override
        public void inicializarPartida() {
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearCatapulta(),new Coordenada(10,1));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearSoldado(),new Coordenada(9,3));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearSoldado(),new Coordenada(11,3));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearSoldado(),new Coordenada(13,3));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearCurandero(),new Coordenada(10,3));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearJinete(),new Coordenada(5,4));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearJinete(),new Coordenada(10,4));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearJinete(),new Coordenada(15,4));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearSoldado(),new Coordenada(9,5));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearSoldado(),new Coordenada(11,5));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearSoldado(),new Coordenada(13,5));
            jugador1.cambiarTurno();
            jugador2.cambiarTurno();
            tablero.cambiarTurno();
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearCatapulta(),new Coordenada(10,20));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearSoldado(),new Coordenada(9,17));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearSoldado(),new Coordenada(11,17));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearSoldado(),new Coordenada(13,17));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearCurandero(),new Coordenada(10,17));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearJinete(),new Coordenada(5,16));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearJinete(),new Coordenada(10,16));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearJinete(),new Coordenada(15,16));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearSoldado(),new Coordenada(9,15));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearSoldado(),new Coordenada(11,15));
            tablero.ponerUnidad(this.obtenerJugadorActivo().crearSoldado(),new Coordenada(13,15));
            jugador1.cambiarTurno();
            jugador2.cambiarTurno();
            tablero.cambiarTurno();
            actualizarEstadoDeUnidades();

        }
}
