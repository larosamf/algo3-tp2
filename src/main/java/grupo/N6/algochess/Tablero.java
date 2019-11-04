package grupo.N6.algochess;

public class Tablero {

    private Casillero [][] casillerosDelTablero;

    public Tablero() {
        casillerosDelTablero = new Casillero[20][20];

        for(int i = 0; i<20; i++){
            for(int j = 0; j<20; j++){
                Casillero casillero = new Casillero();
                casillerosDelTablero[i][j] = casillero;
            }
        }

    }
    public void ubicarUnidadEnCasillero(Unidad unidad, int fila, int columna){
        casillerosDelTablero[fila][columna].ocuparPor(unidad);
    };

    public void desocuparCasillero(int fila, int columna){
        getCasilleroEn(fila,columna).desocupar();
    }

    public Unidad getUnidadEnCasillero(int fila, int columna){
        return(getCasilleroEn(fila, columna).getUnidadEnElCasillero());
    }

    public Casillero getCasilleroEn(int fila, int columna){
        return(casillerosDelTablero[fila][columna]);
    };

}
