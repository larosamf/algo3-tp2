package grupo.N6.algochess.posicionables.unidades;

import java.util.ArrayList;

import grupo.N6.algochess.Casillero;
import grupo.N6.algochess.accionesDeJuego.AtaqueExpansivo;
import grupo.N6.algochess.accionesDeJuego.AtaqueNormal;
import grupo.N6.algochess.posicionables.Atacable;
import grupo.N6.algochess.posicionables.Posicionable;


public abstract class Unidad implements Posicionable, Atacable {

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

    public abstract void atacar(Atacable atacable, int distancia, Atacable casillero) ;
    
    public void recibirCuracion(int cura) {
        if (vida+cura > _VIDAMAXIMA_)
            vida = _VIDAMAXIMA_;
        else
            vida = vida + cura;
    }
    @Override
    public void recibirAtaque(AtaqueNormal unAtaque) { unAtaque.efectuarSobre(this); }
    @Override
    public void recibirAtaque(AtaqueExpansivo unAtaque) { }

    public boolean perteneceA(String nombre){
        return nombre == owner;
    }

    public boolean estaVivo() {
        return vida>0;
    }

    public abstract void curar(Unidad curado, int distanciaHasta);

    public abstract void mover(Casillero casilleroInicio, Casillero casilleroFin);
        
    public abstract void actualizarEstado(ArrayList<Unidad> aliadosACortaDistancia, ArrayList<Unidad> enemigosACortaDistancia, ArrayList<Unidad> batallon); 
    
    public boolean esSoldado() {
    	return false;
    }

    public boolean esCatapulta() {
    	return false;
    }

    public boolean esCurandero() {
    	return false;
    }

    public boolean esJinete() {
    	return false;
    }

    @Override
    public void recibirDano(int dmg){
        if (vida-dmg < 0)
            vida = 0;
        else
            vida = vida - dmg;
    }

	public Batallon obtenerBatallon() {
		return null;
	}

	public int getDaño() {
		return dano;
	}

	public void recibirMasAtaque(double puntosARestar) {
		this.vida = this.vida - (int)puntosARestar;
	}


    public void asignarOwnner(String nombre) {
        owner = nombre;
    }

    public int getDistancia() {
        return distanciaAccion;
    }
}