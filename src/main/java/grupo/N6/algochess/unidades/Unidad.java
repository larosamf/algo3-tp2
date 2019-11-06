package grupo.N6.algochess.unidades;

import grupo.N6.algochess.Casillero;
import grupo.N6.algochess.Coordenada;
import grupo.N6.algochess.Jugador;
import grupo.N6.algochess.Tablero;

import java.util.ArrayList;

/**
 * 
 *
 */
public abstract class Unidad {
    protected ArrayList<Coordenada> adyacencias;
	protected int distanciaAccion;
	protected int vida;
	protected String owner;
	protected int costo;
	protected int daño;
	
    public int getVida() {
        return vida;
    }
    
    public int getCosto() {
        return costo;
    }
    
    public int getDaño() {
    	return daño;
    }


    
    public abstract void atacar(Unidad unidad, int distancia) ;
    
    public void recibirCuracion(int cura) {	vida = vida + cura; }

    public void recibirDaño(int daño) {vida = vida - daño; }

    public boolean perteneceA(String nombre){
        return nombre == owner;
    };

    public abstract void terminarTurno();

    public boolean estaVivo() {
        return vida>0;
    }

    public abstract void curar(Unidad curado, int distanciaHasta);

    public abstract void mover(Casillero casillero, Coordenada inicio, Coordenada fin);
}