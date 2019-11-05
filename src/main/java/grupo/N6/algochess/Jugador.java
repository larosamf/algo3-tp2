package grupo.N6.algochess;
import grupo.N6.algochess.exepciones.PuntosInsuficientesParaAgregarUnidadException;
import grupo.N6.algochess.unidades.Unidad;

import java.util.List;

abstract class Jugador {
	
	private int puntos;
	private int cantidadDeUnidades;
    private boolean estaJugando;
    protected List<Unidad> equipo;

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

	public boolean perdio() {
		return (cantidadDeUnidades == 0); 
	}


	public void cambiarTurno() {
		this.estaJugando = !this.estaJugando;
	}

	abstract public boolean lePertenece(Unidad unidad);

	public void inicializarTurno() {
		this.estaJugando = true;
	}

	public List<Unidad> obtenerUnidades() {
		return this.equipo;
	}

	public boolean estaActivo() {
		return this.estaJugando;
	}

	public void terminarTurno() {
		for (Unidad unidad : equipo) {
			unidad.terminarTurno();
		}
	}
}