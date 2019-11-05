package grupo.N6.algochess;

public class Tablero {

    private Casillero [][] casillerosDelTablero;
    private Sector sectorDeJugador1;
    private Sector sectorDeJugador2;
    private Sector sectorAliado; /*cambia turno a turno*/
    

    public Tablero() {
        casillerosDelTablero = new Casillero[20][20];

        for(int i = 0; i<20; i++){
            for(int j = 0; j<20; j++){
                Casillero casillero = new Casillero();
                casillerosDelTablero[i][j] = casillero;
            }
        }
        
        Integer[] columnasSector1 = {1,2,3,4,5,6,7,8,9,10};
        Integer[] columnasSector2 = {11,12,13,14,15,16,17,18,19,20};
        sectorDeJugador1 = new Sector(columnasSector1);
        sectorDeJugador2 = new Sector(columnasSector2);
        sectorAliado = sectorDeJugador1;

    }
    
    public void ubicarUnidadEnCasillero(Unidad unidad, int fila, int columna){
    	
        Casillero casillero = casillerosDelTablero[fila][columna];
        sectorAliado.ubicarUnidadEnCasillero(unidad, columna, casillero);
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

}
