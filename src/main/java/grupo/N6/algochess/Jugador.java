package grupo.N6.algochess;
import grupo.N6.algochess.exepciones.PuntosInsuficientesParaAgregarUnidadException;
import grupo.N6.algochess.posicionables.unidades.*;

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

	public String nombre() {
		return nombre;
	}

    public SoldadoDeInfanteria crearSoldado(){
        SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
        soldado.asignarOwnner(nombre);
        agregarUnidad(soldado);
        return soldado;
    }

    public Curandero crearCurandero(){
        Curandero curandero = new Curandero();
        curandero.asignarOwnner(nombre);
        agregarUnidad(curandero);
        return curandero;
    }

    public Catapulta crearCatapulta(){
        Catapulta catapulta = new Catapulta();
        catapulta.asignarOwnner(nombre);
        agregarUnidad(catapulta);
        return catapulta;
    }

    public Jinete crearJinete(){
        Jinete jinete = new Jinete();
        jinete.asignarOwnner(nombre);
        agregarUnidad(jinete);
        return jinete;
    }
}