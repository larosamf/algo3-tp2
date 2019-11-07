package grupo.N6.algochess;


public class UnidadMovil extends Unidad {
	
	public void mover(Coordenada coordenadaNueva) {
		if ((this.coordenada.equals(coordenadaNueva)) || !(this.coordenada.esConsecutiva(coordenadaNueva))) {
			throw new MovimientoInvalidoException();
		}
		this.coordenada = coordenadaNueva;
	}

}