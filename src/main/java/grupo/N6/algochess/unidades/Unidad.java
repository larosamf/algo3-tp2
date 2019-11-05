package grupo.N6.algochess.unidades;

/**
 * 
 *
 */
public abstract class Unidad {
	
	protected int vida;
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