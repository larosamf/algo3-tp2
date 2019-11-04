package grupo.N6.algochess;

public abstract class EstadoCasillero {

    public abstract EstadoCasillero ocuparPor(Unidad unidad);

    public abstract EstadoCasillero desocupar();

    public abstract Unidad getUnidadQueOcupaElCasillero();

}
