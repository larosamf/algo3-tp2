package grupo.N6.algochess;

import grupo.N6.algochess.exepciones.NoSePuedeColocarUnaUnidadEnElSectorEnemigoException;

import java.util.Arrays;

public class Sector {

	Integer[] grupoDeColumnas;
	
	public Sector(Integer[] columnas) {
		
		grupoDeColumnas = columnas;
		
	}
	
	public void ubicarUnidadEnCasillero(Unidad unidad, int columna, Casillero casillero){
		if (Arrays.asList(grupoDeColumnas).contains(columna)) {
			casillero.ocuparPor(unidad);
		} else {
			throw new NoSePuedeColocarUnaUnidadEnElSectorEnemigoException();
		}
    }
	
}