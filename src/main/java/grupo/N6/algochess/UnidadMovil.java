package grupo.N6.algochess;


public class UnidadMovil extends Unidad {
	
	public void mover(int fila, int columna) {
		Coordenada coordenadaNueva = new Coordenada(fila, columna);
		
		if (!(this.coordenada.esConsecutiva(coordenadaNueva))) {
			throw new MovimientoInvalidoException();
		}
		
		this.coordenada = coordenadaNueva;
	}

}