package grupo.N6.algochess.interfaz;

import grupo.N6.algochess.Algochess;
import grupo.N6.algochess.exepciones.FinalException;
import grupo.N6.algochess.exepciones.MovimientoInvalidoException;
import grupo.N6.algochess.interfaz.eventos.AtaqueMoverHandler;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Vista extends Application {

    public static final int TAM_CASILLERO = 50;
    public static final int ANCHO = 20;
    public static final int ALTO = 20;

    private CasilleroVista[][] tablero = new CasilleroVista[ANCHO][ALTO];

    private Group casilleros  = new Group();
    private Group unidades = new Group();
     public static Stage secondStage;

    public static Algochess partida;

    private long diff;
    private long time1;
    private long time2;


    @Override
    public void start(Stage primaryStage) {

        partida = new Algochess();
        Scene scene = new Scene(crearContenido());
        primaryStage.setTitle("AlgoChess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static int posTablero(double pixel) {
        return (int)(pixel + TAM_CASILLERO / 2) / TAM_CASILLERO;
    }

    private Parent crearContenidoVentana(int unX, int unY, UnidadVista unidad) {
        Pane root = new Pane();
        root.setPrefSize(100, 100);
        root.setBorder(null);
        String nombre = partida.tipoUnidadEnCasillero(unX +1,unY+1);;
        int vida = partida.vidaDeUnidadEnCasillero(unX +1,unY+1);
        String strVida = "" + vida;
        int ataque = partida.dañoDeUnidadEnCasillero(unX +1,unY+1);
        String strAtaque = "" + ataque;
        int distancia = partida.obtenerDistanciaDeAtaque(unX +1,unY+1);
        String strDistancia = "" + distancia;


        Label etiqueta = new Label(nombre);

        Label ptosVida = new Label("Vida: ".concat(strVida));
        Label ptosAtaque   = new Label("Ataque: ".concat(strAtaque));
        Label ptosDistancia = new Label("Distancia: ".concat(strDistancia));

        VBox contenedorPrincipal = new VBox(etiqueta, ptosVida, ptosAtaque, ptosDistancia);

        root.getChildren().addAll(contenedorPrincipal);

        return root;
    }

    private Parent crearContenido() {
        int x;
        int y;
        String nombreUnidad;
        Image img = new Image("file:TableroTexture.jpg", ANCHO*TAM_CASILLERO, ALTO*TAM_CASILLERO, false, true);
        BackgroundImage myBI= new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Pane root = new Pane();
        root.setBackground(new Background(myBI));
        root.setPrefSize(ANCHO * TAM_CASILLERO, ALTO * TAM_CASILLERO);
        root.getChildren().addAll(casilleros, unidades);

        for (y = 0; y < ALTO; y++) {
            for (x = 0; x < ANCHO; x++) {
                CasilleroVista casillero = new CasilleroVista(x, y);
                tablero[x][y] = casillero;
                casilleros.getChildren().add(casillero);
                UnidadVista unidad = null;

               //Agregar Unidad
                try {
                    nombreUnidad = partida.tipoUnidadEnCasillero(x+1,y+1);
                    unidad = crearUnidad(x, y, nombreUnidad);
                    casillero.agregarUnidad(unidad);
                }
                catch (Exception s){

                }

                if (unidad != null) {
                    unidades.getChildren().add(unidad);
                }
            }
        }

        return root;
    }


    private UnidadVista crearUnidad(int x, int y, String nombre) {

        UnidadVista unidadVista = new UnidadVista (x, y, nombre);

        unidadVista.setOnMouseEntered(e ->{
            int newX = posTablero(unidadVista.getLayoutX());
            int newY = posTablero(unidadVista.getLayoutY());
            Scene scene = new Scene(crearContenidoVentana(newX, newY, unidadVista));
            secondStage = new Stage();
            secondStage.setTitle("Unidad");
            secondStage.setScene(scene);
            secondStage.setX(e.getScreenX()+10);
            secondStage.setY(e.getScreenY()+10);
            secondStage.show();
        });

        unidadVista.setOnMouseExited(e ->{
            secondStage.close();
        });


        unidadVista.setOnMouseReleased(new AtaqueMoverHandler(unidadVista,partida,tablero,x,y));
        return unidadVista;
    }



    public static void main(String[] args) {
        launch(args);
    }

}