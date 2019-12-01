package grupo.N6.algochess.interfaz;


import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class CasilleroVista extends Rectangle {

    private UnidadVista unidadVista;

    public CasilleroVista(int x, int y) {

        Image img = new Image("file:GrassTexture.jpg", 50, 50, false, false);
        setFill(new ImagePattern(img));

        setStroke(Color.BLACK);

        setWidth(Vista.TAM_CASILLERO);
        setHeight(Vista.TAM_CASILLERO);

        relocate(x * Vista.TAM_CASILLERO, y * Vista.TAM_CASILLERO);

    }

    public UnidadVista obtenerUnidad(){
        return this.unidadVista;
    }

    public void agregarUnidad(UnidadVista unidad){
        this.unidadVista = unidad;
    }

    public void borrarUnidad(){
        this.unidadVista = null;
    }

}