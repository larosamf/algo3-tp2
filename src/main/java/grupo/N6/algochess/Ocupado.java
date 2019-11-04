package grupo.N6.algochess;

public class Ocupado extends EstadoCasillero {

    Unidad unidadQueOcupaElCasillero;

    public Ocupado(Unidad unidad){
        unidadQueOcupaElCasillero = unidad;
    }

    public EstadoCasillero ocuparPor(Unidad unidad){
        throw new EsteCasilleroEstaOcupadoYNoSePuedePonerOtraUnidadException();
    }

    public EstadoCasillero desocupar(){
        EstadoCasillero estadoDesocupado = new Desocupado();
        return(estadoDesocupado);
    }

    public Unidad getUnidadQueOcupaElCasillero(){
        return(unidadQueOcupaElCasillero);
    }
}
