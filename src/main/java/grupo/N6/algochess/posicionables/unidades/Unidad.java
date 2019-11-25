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

    public abstract void atacar(Atacable atacable, int distancia) ;
    
    public void recibirCuracion(int cura) {
        if (vida+cura > _VIDAMAXIMA_)
            vida = _VIDAMAXIMA_;
        else
            vida = vida + cura;
    }
    @Override
    public void recibirAtaque(AtaqueNormal unAtaque) { unAtaque.efectuarSobre(this); }
    @Override
    public void recibirAtaque(AtaqueExpansivo unAtaque) { unAtaque.efectuarSobre(this); }

    public boolean perteneceA(String nombre){
        return nombre == owner;
    };

    public abstract void terminarTurno();

    public boolean estaVivo() {
        return vida>0;
    }

    public abstract void curar(Unidad curado, int distanciaHasta);

    public abstract void mover(Casillero casilleroInicio, Casillero casilleroFin);
        
    public abstract void actualizarEstado(ArrayList<Unidad> aliadosACortaDistancia, ArrayList<Unidad> enemigosACortaDistancia, ArrayList<Unidad> batallon);
    
    public boolean esSoldado() {
    	return false;
    }

    @Override
    public void recibirDano(int dmg){
        if (vida-dmg < 0)
            vida = 0;
        else
            vida = vida - dmg;
    }


}