package grupo.N6.algochess;
import grupo.N6.algochess.exepciones.FinalException;
import grupo.N6.algochess.exepciones.PuntosInsuficientesParaAgregarUnidadException;
import grupo.N6.algochess.posicionables.unidades.Unidad;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	
	private int puntos;
	protected String nombre;
	private int cantidadDeUnidades;
    private boolean estaJugando;
    protected List<Unidad> equipo;

    public Jugador() {
		puntos = 20;
		cantidadDeUnidades = 0;
        this.nombre = nombre;
        this.equipo = new ArrayList<Unidad>();
	}

	public void setNombre(String nombre){
    	this.nombre = nombre;
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

	public void cambiarTurno() {
		this.estaJugando = !this.estaJugando;
	}

    public boolean lePertenece(Unidad unidad) {
        return unidad.perteneceA(this.nombre);
    }

	public void inicializarTurno() {
		this.estaJugando = true;
	}

	public List<Unidad> obtenerUnidades() {
		return this.equipo;
	}

	public boolean estaActivo() {
		return this.estaJugando;
	}

	public boolean tienePuntos(){
    	return(puntos>=1);
	}

	public void terminarTurno() {
		for (Unidad unidad : equipo) {
			unidad.terminarTurno();
		}
	}
    public void sigueParticipando() {
        boolean sigueJugando = false;
        for (Unidad unidad : equipo) {
            if (unidad.estaVivo())
                sigueJugando = true;
        }
        if (!sigueJugando){
            throw new FinalException();
        }
    }
}