package grupo.N6.algochess;


public class Jugador {
	
	private int puntos;
	private int cantidadDeUnidades;
	
	public Jugador() {
		puntos = 20;
		cantidadDeUnidades = 0;
	}

	public int getPuntos() {
		return puntos;
	}
	
	public void agregarUnidad(Unidad unidad) {
		
		if (puntos < unidad.getCosto()) {
			throw new PuntosInsuficientesParaAgregarUnidadException();
		}
		
		puntos -= unidad.getCosto();
		cantidadDeUnidades += 1;
	}

}