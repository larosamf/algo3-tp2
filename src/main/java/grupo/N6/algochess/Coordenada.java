package grupo.N6.algochess;

public class Coordenada {
    private int x;
    private int y;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean esConsecutiva(Coordenada otra) {
        return distanciaHasta(otra) <= 1;
    }
    
    public int distanciaHasta(Coordenada otra){
        return Math.max(Math.abs(this.x - otra.x), Math.abs(this.y - otra.y));
    }

    @Override
    public boolean equals(Object otroObjeto) {
        try {
            Coordenada otraCoordenada = (Coordenada) otroObjeto;
            return this.x == otraCoordenada.x && this.y == otraCoordenada.y;
        } catch (ClassCastException cce) {
            return false;
        }
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

}
