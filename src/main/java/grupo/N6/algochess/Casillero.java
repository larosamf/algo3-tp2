package grupo.N6.algochess;

public class Casillero {

    Unidad unidadQueOcupaElCasillero;
    private boolean ocupado;

    public Casillero(){
        unidadQueOcupaElCasillero = null;
        ocupado = false;
    }

    public boolean estaOcupado(){
        return(ocupado);
    }

    public void ocuparPor(Unidad unidadNuevaOcupante){
        unidadQueOcupaElCasillero = unidadNuevaOcupante;
        ocupado = true;
    };

    public Unidad desocupar(){
          Unidad unidadQueDejaElCasillero = unidadQueOcupaElCasillero;
          unidadQueOcupaElCasillero = null;
          ocupado = false;
          return (unidadQueDejaElCasillero);
    }

}
