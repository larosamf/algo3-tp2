package grupo.N6.algochess;

public class Catapulta extends Unidad implements Atacante {
	
	public Catapulta() {
		vida = 50;
		costo = 5;
		daño = 20;
	}
	
	public void atacar(Unidad otraUnidad) {
    	otraUnidad.recibirDaño(daño);
    }
	
	public void ubicarEn(int fila, int columna) {
		coordenada = new Coordenada(fila, columna);
	}

}