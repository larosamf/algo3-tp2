package grupo.N6.algochess;

public class Tablero {

    private Casillero [][] casillerosDelTablero;

    public Tablero() {
        casillerosDelTablero = new Casillero[20][20];
    }
    public void ubicarUnidadEnCasillero(Unidad unidad, int fila, int columna){
        casillerosDelTablero[fila][columna].ocuparPor(unidad);
    };

    public Casillero getCasilleroEn(int fila, int columna){
        return(casillerosDelTablero[fila][columna]);
    };

}
