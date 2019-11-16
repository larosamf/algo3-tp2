package grupo.N6.algochess;

public abstract class Unidad implements Posicionable {
	
	protected int vida;
	protected int costo;
	protected int daño;
	
	public Unidad() {
	}
	
	
    public int getVida() {
        return vida;
    }
    
    public int getCosto() {
        return costo;
    }
    
    public void recibirDaño(int daño) {
    	vida = vida - daño;
    }
    
    public void recibirCuracion() {
    	vida = vida + 15;
    }
    
    public void mover(int distancia) {
    	throw new EstaUnidadNoSePuedeMoverException();
    }
    
}