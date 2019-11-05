package grupo.N6.algochess.unidades;

import grupo.N6.algochess.unidades.Unidad;

public class Curandero extends Unidad {
	
	public Curandero() {
		vida = 75;
		costo = 2;
		daño = 0;
	}
	
	public void curar(Unidad otraUnidad) {
		otraUnidad.recibirCuracion();
	}
	
}