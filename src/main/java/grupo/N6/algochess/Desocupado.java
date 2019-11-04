package grupo.N6.algochess;

public class Desocupado extends EstadoCasillero {

    public EstadoCasillero ocuparPor(Unidad unidad){
        EstadoCasillero estadoOcupado = new Ocupado(unidad);
        return(estadoOcupado);
    }

    public EstadoCasillero desocupar(){
        throw new EsteCasilleroYaEstaDesocupadoException();
    }

    public Unidad getUnidadQueOcupaElCasillero(){
        throw new EsteCasilleroNoTieneUnaUnidadEnElException();
    }
}
