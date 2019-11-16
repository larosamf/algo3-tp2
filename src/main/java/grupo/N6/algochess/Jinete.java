package grupo.N6.algochess;

public class Jinete extends Unidad implements Atacante, Movible {
	
	public Jinete() {
		vida = 100;
		costo = 3;
		daño = 5;
	}

	public void atacar(Unidad otraUnidad) {
    	otraUnidad.recibirDaño(daño);
    }
	
	public void mover(int distancia) {		
		if (distancia > 1) {
			throw new MovimientoInvalidoException();
		}
	}
	
}
