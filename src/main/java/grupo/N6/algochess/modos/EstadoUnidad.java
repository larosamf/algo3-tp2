package grupo.N6.algochess.modos;

import grupo.N6.algochess.posicionables.Atacable;

public abstract class EstadoUnidad {

    public abstract int aplicar(int dmg,int vida);

    public abstract boolean estaAtacado();
}

