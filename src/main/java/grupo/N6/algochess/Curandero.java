package grupo.N6.algochess;

public class Curandero extends Unidad implements Movible {
	
	public Curandero() {
		vida = 75;
		costo = 2;
		daño = 0;
	}
	
	public void curar(Unidad otraUnidad) {
		otraUnidad.recibirCuracion();
	}
	
	public void mover(int distancia) {

		if (distancia > 1) {
			throw new MovimientoInvalidoException();
		}

	}

	
}