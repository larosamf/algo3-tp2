package grupo.N6.algochess.accionesDePartida;

import grupo.N6.algochess.Casillero;
import grupo.N6.algochess.exepciones.CasilleroVacioException;
import grupo.N6.algochess.posicionables.unidades.Batallon;
import grupo.N6.algochess.posicionables.unidades.Unidad;

public class MoverBatallon {

    Unidad soldadoDelMedio;
    Casillero casilleroDelSoldadoDelMedio;
    Casillero casilleroInicio;
    Casillero casilleroFin;
    String tipoDeBatalllon;

    public MoverBatallon(Batallon batallon, Casillero casilleroInicio, Casillero casilleroFin){
        soldadoDelMedio = batallon.getSoldadoDelMedio();
        this.casilleroInicio = casilleroInicio;
        this.casilleroFin = casilleroFin;
        this.casilleroDelSoldadoDelMedio = obtenerCasilleroDelSoldadoDelMedio(casilleroInicio);
        this.tipoDeBatalllon = batallon.getTipo();
    }

    public void mover(){
        if(casilleroFin == casilleroInicio.obtenerAdyacenteDerecha()) {
            moverBatallonALaDerecha();
        }else if(casilleroFin == casilleroInicio.obtenerAdyacenteIzquierda()){
            moverBatallonALaIzquierda();
        }else if(casilleroFin == casilleroInicio.obtenerAdyacenteArriba()){
           moverBatallonArriba();
        }else if(casilleroFin == casilleroInicio.obtenerAdyacenteAbajo()){
            moverBatallonAbajo();
        }
    }

    private void moverBatallonALaDerecha(){
        Casillero casilleroDestinoDelSoldadoDelMedio = casilleroDelSoldadoDelMedio.obtenerAdyacenteDerecha();

        if(tipoDeBatalllon == "HORIZONTAL") {
            casilleroDelSoldadoDelMedio.obtenerAdyacenteDerecha().moverUnidadA(casilleroDestinoDelSoldadoDelMedio.obtenerAdyacenteDerecha());
            casilleroDelSoldadoDelMedio.moverUnidadA(casilleroDestinoDelSoldadoDelMedio);
            casilleroDelSoldadoDelMedio.obtenerAdyacenteIzquierda().moverUnidadA(casilleroDestinoDelSoldadoDelMedio.obtenerAdyacenteIzquierda());
        }

        if(tipoDeBatalllon == "VERTICAL"){
            casilleroDelSoldadoDelMedio.moverUnidadA(casilleroDestinoDelSoldadoDelMedio);
            casilleroDelSoldadoDelMedio.obtenerAdyacenteArriba().moverUnidadA(casilleroDestinoDelSoldadoDelMedio.obtenerAdyacenteArriba());
            casilleroDelSoldadoDelMedio.obtenerAdyacenteAbajo().moverUnidadA(casilleroDestinoDelSoldadoDelMedio.obtenerAdyacenteAbajo());
        }

    }

    private void moverBatallonALaIzquierda(){
        Casillero casilleroDestinoDelSoldadoDelMedio = casilleroDelSoldadoDelMedio.obtenerAdyacenteIzquierda();

        if(tipoDeBatalllon == "HORIZONTAL") {
            casilleroDelSoldadoDelMedio.obtenerAdyacenteIzquierda().moverUnidadA(casilleroDestinoDelSoldadoDelMedio.obtenerAdyacenteIzquierda());
            casilleroDelSoldadoDelMedio.moverUnidadA(casilleroDestinoDelSoldadoDelMedio);
            casilleroDelSoldadoDelMedio.obtenerAdyacenteDerecha().moverUnidadA(casilleroDestinoDelSoldadoDelMedio.obtenerAdyacenteDerecha());
        }
        if(tipoDeBatalllon == "VERTICAL"){
            casilleroDelSoldadoDelMedio.moverUnidadA(casilleroDestinoDelSoldadoDelMedio);
            casilleroDelSoldadoDelMedio.obtenerAdyacenteArriba().moverUnidadA(casilleroDestinoDelSoldadoDelMedio.obtenerAdyacenteArriba());
            casilleroDelSoldadoDelMedio.obtenerAdyacenteAbajo().moverUnidadA(casilleroDestinoDelSoldadoDelMedio.obtenerAdyacenteAbajo());
        }

    }

    private void moverBatallonArriba(){
        Casillero casilleroDestinoDelSoldadoDelMedio = casilleroDelSoldadoDelMedio.obtenerAdyacenteArriba();

        if(tipoDeBatalllon == "HORIZONTAL") {
            casilleroDelSoldadoDelMedio.obtenerAdyacenteIzquierda().moverUnidadA(casilleroDestinoDelSoldadoDelMedio.obtenerAdyacenteIzquierda());
            casilleroDelSoldadoDelMedio.moverUnidadA(casilleroDestinoDelSoldadoDelMedio);
            casilleroDelSoldadoDelMedio.obtenerAdyacenteDerecha().moverUnidadA(casilleroDestinoDelSoldadoDelMedio.obtenerAdyacenteDerecha());
        }

        if(tipoDeBatalllon == "VERTICAL"){
            casilleroDelSoldadoDelMedio.obtenerAdyacenteArriba().moverUnidadA(casilleroDestinoDelSoldadoDelMedio.obtenerAdyacenteArriba());
            casilleroDelSoldadoDelMedio.moverUnidadA(casilleroDestinoDelSoldadoDelMedio);
            casilleroDelSoldadoDelMedio.obtenerAdyacenteAbajo().moverUnidadA(casilleroDestinoDelSoldadoDelMedio.obtenerAdyacenteAbajo());
        }

    }

    private void moverBatallonAbajo(){
        Casillero casilleroDestinoDelSoldadoDelMedio = casilleroDelSoldadoDelMedio.obtenerAdyacenteAbajo();

        if(tipoDeBatalllon == "HORIZONTAL") {
            casilleroDelSoldadoDelMedio.obtenerAdyacenteIzquierda().moverUnidadA(casilleroDestinoDelSoldadoDelMedio.obtenerAdyacenteIzquierda());
            casilleroDelSoldadoDelMedio.moverUnidadA(casilleroDestinoDelSoldadoDelMedio);
            casilleroDelSoldadoDelMedio.obtenerAdyacenteDerecha().moverUnidadA(casilleroDestinoDelSoldadoDelMedio.obtenerAdyacenteDerecha());
        }

        if(tipoDeBatalllon == "VERTICAL"){
            casilleroDelSoldadoDelMedio.obtenerAdyacenteAbajo().moverUnidadA(casilleroDestinoDelSoldadoDelMedio.obtenerAdyacenteAbajo());
            casilleroDelSoldadoDelMedio.moverUnidadA(casilleroDestinoDelSoldadoDelMedio);
            casilleroDelSoldadoDelMedio.obtenerAdyacenteArriba().moverUnidadA(casilleroDestinoDelSoldadoDelMedio.obtenerAdyacenteArriba());

        }


    }

    private Casillero obtenerCasilleroDelSoldadoDelMedio(Casillero casilleroInicio){

        Casillero casilleroBuscado = null;

        if(casilleroInicio.obtenerUnidad() == soldadoDelMedio){
            casilleroBuscado = casilleroInicio;
        }

        try{
           if (casilleroInicio.obtenerAdyacenteDerecha().obtenerUnidad() == soldadoDelMedio) {
                 casilleroBuscado = casilleroInicio.obtenerAdyacenteDerecha();
           }
        }catch(CasilleroVacioException e){;}

        try{
            if (casilleroInicio.obtenerAdyacenteIzquierda().obtenerUnidad() == soldadoDelMedio) {
                casilleroBuscado = casilleroInicio.obtenerAdyacenteIzquierda();
            }
        }catch(CasilleroVacioException e){;}

        try{
            if (casilleroInicio.obtenerAdyacenteArriba().obtenerUnidad() == soldadoDelMedio) {
                casilleroBuscado = casilleroInicio.obtenerAdyacenteArriba();
            }
        }catch(CasilleroVacioException e){;}

        try{
            if (casilleroInicio.obtenerAdyacenteAbajo().obtenerUnidad() == soldadoDelMedio) {
                casilleroBuscado = casilleroInicio.obtenerAdyacenteAbajo();
            }
        }catch(CasilleroVacioException e){;}

        return(casilleroBuscado);
    }

}
