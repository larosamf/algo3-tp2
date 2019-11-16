package grupo.N6.algochess;

public class Tablero {

    private static Tablero instanciaDeTablero = new Tablero();

    private Casillero [][] casillerosDelTablero;
    private String bandoAliado; /*cambia turno a turno*/

    public static Tablero getInstanciaDeTablero(){
        return(instanciaDeTablero);
    }

   private Tablero() {
        casillerosDelTablero = new Casillero[20][20];

        for(int i = 0; i<20; i++){
        	String bando = "Bando1";
        	if (i > 9) {	
        		bando = "Bando2";
        	}
            for(int j = 0; j<20; j++){
                Casillero casillero = new Casillero(i,j, bando);
                casillerosDelTablero[i][j] = casillero;
            }
        }
        
        bandoAliado = "Bando1";

    }
    
    public void ubicarUnidadEnCasillero(Unidad unidad, int fila, int columna){
    	
        Casillero casillero = casillerosDelTablero[fila][columna];
        casillero.ocuparPor(unidad, bandoAliado);
    }

    public void desocuparCasillero(int fila, int columna){
        getCasilleroEn(fila,columna).desocupar();
    }

    public Unidad getUnidadEnCasillero(int fila, int columna){
        return(getCasilleroEn(fila, columna).getUnidadEnElCasillero());
    }

    private Casillero getCasilleroEn(int fila, int columna){
        return(casillerosDelTablero[fila][columna]);
    }
    
    public void moverUnidadDePosicionADestino(int posicionFila, int posicionColumna, int filaDestino, int columnaDestino) {
    	Unidad unidad = getUnidadEnCasillero(posicionFila, posicionColumna);
    	int distanciaAMoverse = getCasilleroEn(posicionFila, posicionColumna).distanciaACasillero(filaDestino, columnaDestino);
    	unidad.mover(distanciaAMoverse);
    	desocuparCasillero(posicionFila, posicionColumna);
    	ubicarUnidadEnCasillero(unidad, filaDestino, columnaDestino);
    }

}
