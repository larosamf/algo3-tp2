package grupo.N6.algochess;

public abstract class Unidad implements Posicionable {
	
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
    
    public int getCoordenadaX() {
    	return coordenada.getX();
    }
    
    public void recibirDaño(int daño) {
    	vida = vida - daño;
    }
    
    public void recibirCuracion() {
    	vida = vida + 15;
    }
    
    public void mover(int fila, int columna) {
    	throw new EstaUnidadNoSePuedeMoverException();
    }
    
}