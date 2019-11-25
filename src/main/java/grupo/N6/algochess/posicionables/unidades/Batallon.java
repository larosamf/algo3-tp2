package grupo.N6.algochess.posicionables.unidades;

import java.util.ArrayList;

public class Batallon {
    ArrayList<Unidad> soldados; /*EL SOLDADO EN LA POSICION 1 ES EL DEL MEDIO*/
    String tipoDeBatallon; /*HORIZONTAL O VERTICAL*/

    public Batallon(ArrayList<Unidad> soldados, String tipoDeBatallon){
        this.soldados = soldados;
        this.tipoDeBatallon = tipoDeBatallon;
    }

    public Unidad getSoldadoDelMedio(){
        return(this.soldados.get(1));
    }

    public String getTipo(){
        return(this.tipoDeBatallon);
    }

}
