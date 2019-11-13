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
public abstract class Unidad implements Colocable{

    protected int distanciaAccion;
	protected int vida;
    protected int _VIDAMAXIMA_;
	protected String owner;
	protected int costo;
	protected int dano;
	
    public int getVida() {
        return vida;
    }
    
    public int getCosto() {
        return costo;
    }
    
    public int getDano() {
    	return dano;
    }


    public abstract void atacar(Unidad unidad, int distancia) ;
    
    public void recibirCuracion(int cura) {
        if (vida+cura > _VIDAMAXIMA_)
            vida = _VIDAMAXIMA_;
        else
            vida = vida + cura;
    }

    public void recibirAtaque(int dano) { vida = vida - dano; }

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