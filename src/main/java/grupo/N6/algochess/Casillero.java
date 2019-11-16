package grupo.N6.algochess;


public class Casillero {

    boolean casilleroOcupado;
    Coordenada coordenada;
    Unidad unidad;

    public Casillero(int x, int y){
        casilleroOcupado = false;
        coordenada = new Coordenada(x,y);
        unidad = null;
    }

    public void ocuparPor(Unidad unidadAUbicar){
    	if (casilleroOcupado) {
    		throw new EsteCasilleroEstaOcupadoYNoSePuedePonerOtraUnidadException();
    	}
        unidad = unidadAUbicar;
        casilleroOcupado = true;
    };

    public void desocupar(){
    	if (casilleroOcupado == false) {
    		throw new EsteCasilleroYaEstaDesocupadoException();
    	}
        casilleroOcupado = false;
        unidad = null;
    };
    
    public int distanciaACasillero(int x, int y) {
    	Coordenada nuevaCoordenada = new Coordenada(x,y);
    	return coordenada.distanciaHasta(nuevaCoordenada);
    	
    }

    public Unidad getUnidadEnElCasillero(){
        return(unidad);
    }

}


