package grupo.N6.algochess;

public class Catapulta extends Unidad implements Atacante {
	
	public Catapulta() {
		vida = 50;
		costo = 5;
		daño = 20;
	}
	
	public void atacar(Unidad otraUnidad, int distanciaAlAtacado) {
    	otraUnidad.recibirDaño(daño);
    }

	public void recibirCuracion() {
		throw new NoSePuedeCurarUnaCatapultaException();
	}
	
}