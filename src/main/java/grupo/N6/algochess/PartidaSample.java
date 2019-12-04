package grupo.N6.algochess;

public class PartidaSample extends Partida implements PartidaInterface{

    public PartidaSample(Jugador jugador1, Jugador jugador2) {

        super(jugador1, jugador2);
        this.inicializarPartida(tablero,jugador1,jugador2);
    }

    @Override
    public void inicializarPartida(Tablero tablero, Jugador jugador1, Jugador jugador2) {
        this.tablero.ponerUnidad(jugador1.crearSoldado(),new Coordenada(2,3));
        this.tablero.ponerUnidad(jugador2.crearSoldado(),new Coordenada(7,8));
        this.tablero.ponerUnidad(jugador1.crearCatapulta(),new Coordenada(1,1));
        this.tablero.ponerUnidad(jugador2.crearJinete(),new Coordenada(9,8));
        this.tablero.ponerUnidad(jugador2.crearCurandero(),new Coordenada(8,8));
    }
}
