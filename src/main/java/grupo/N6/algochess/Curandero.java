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