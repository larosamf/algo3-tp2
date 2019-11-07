package grupo.N6.algochess;

/**
 * 
 *
 */
public abstract class Unidad {
	
	protected int vida;
	protected int costo;
	protected int daño;
	protected Coordenada coordenada;
	
	public Unidad() {
		coordenada = new Coordenada(0, 0);
	}
	
    public int getVida() {
        return vida;
    }
    
    public int getCosto() {
        return costo;
    }
    
    public int getDaño() {
    	return daño;
    }
    
    public int getCoordenadaX() {
    	return coordenada.getX();
    }
    
    public void recibirDaño(int daño) {
    	vida = vida - daño;
    }
    
    public void atacar(Unidad otraUnidad, int daño) {
    	if (daño == 0) {
    		throw new EstaUnidadNoAtacaException();
    	}
    	
    	otraUnidad.recibirDaño(daño);
    }
    
    public void recibirCuracion() {
    	vida = vida + 15;
    }
    
}