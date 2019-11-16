package grupo.N6.algochess;

public class SoldadoDeInfanteria extends Unidad implements Atacante, Movible {
	
	public SoldadoDeInfanteria() {
		vida = 100;
		costo = 1;
		daño = 10;
	}
	
	public void atacar(Unidad otraUnidad, int distanciaAlAtacado) {
    	otraUnidad.recibirDaño(daño);
    }
	
	public void mover(int distancia) {
		if (distancia > 1) {
			throw new MovimientoInvalidoException();
		}
	}
	
}