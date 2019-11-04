package grupo.N6.algochess;


public class Casillero {

    EstadoCasillero estadoCasillero;

    public Casillero(){
        estadoCasillero = new Desocupado();
    }

    public void ocuparPor(Unidad unidad){
        estadoCasillero = estadoCasillero.ocuparPor(unidad);
    };

    public void desocupar(){
        estadoCasillero = estadoCasillero.desocupar();
    };

    public Unidad getUnidadEnElCasillero(){
        return(estadoCasillero.getUnidadQueOcupaElCasillero());
    }

}


