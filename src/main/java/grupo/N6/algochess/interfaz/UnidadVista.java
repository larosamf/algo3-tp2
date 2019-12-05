package grupo.N6.algochess.interfaz;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class UnidadVista extends StackPane {

    public double mouseX, mouseY;
    public int posX, posY;
    private int oldX, oldY;
    private String imagen;
    private Image icon;


    public UnidadVista(int x, int y, String nombre) {

        this.posX = x;
        this.posY = y;
        imagen = null;
        if (nombre != null) {
            imagen = "file:".concat(nombre.concat(".jpg"));
            icon = new Image(imagen, 100, 100, true, true);
            mover(x,y);
            setAlignment(Pos.CENTER_RIGHT);
            getChildren().add(new ImageView(icon));

        }

        setOnMouseDragged(e -> {

            relocate(e.getSceneX(), e.getSceneY());

        });

    }

    public void mover(int x, int y) {
        oldX = x * Vista.TAM_CASILLERO;
        oldY = y * Vista.TAM_CASILLERO;
        this.posX = x;
        this.posY = y;

        relocate(oldX, oldY);
    }

}
