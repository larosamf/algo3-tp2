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
	
	public void mover(int fila, int columna) {
		Coordenada coordenadaNueva = new Coordenada(fila, columna);
		
		if (!(this.coordenada.esConsecutiva(coordenadaNueva))) {
			throw new MovimientoInvalidoException();
		}
		
		this.coordenada = coordenadaNueva;
	}
	
	public void ubicarEn(int fila, int columna) {
		coordenada = new Coordenada(fila, columna);
	}
	
	
}
