package grupo.N6.algochess;
import grupo.N6.algochess.exepciones.PuntosInsuficientesParaAgregarUnidadException;
import grupo.N6.algochess.posicionables.unidades.Unidad;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	
	private int puntos;
	protected String nombre;
    private boolean estaJugando;
    protected List<Unidad> equipo;

    public Jugador() {
		puntos = 20;
        this.nombre = null;
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
		equipo.add(unidad);
		puntos -= unidad.getCosto();
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
		this.estaJugando = false;
	}
	
    public boolean sigueParticipando() {
        for (Unidad unidad : equipo) {
            if (unidad.estaVivo())
                return true;
        }
        return false;
    }
}