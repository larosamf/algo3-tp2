package grupo.N6.algochess.interfaz;

import grupo.N6.algochess.Coordenada;
import grupo.N6.algochess.Jugador;
import grupo.N6.algochess.PartidaSample;
import grupo.N6.algochess.accionesDePartida.Atacar;
import grupo.N6.algochess.accionesDePartida.Mover;
import grupo.N6.algochess.exepciones.FinalException;
import grupo.N6.algochess.exepciones.MovimientoInvalidoException;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Vista extends Application {

    public static final int TAM_CASILLERO = 100;
    public static final int ANCHO = 10;
    public static final int ALTO = 10;

    private CasilleroVista[][] tablero = new CasilleroVista[ANCHO][ALTO];

    private Group casilleros  = new Group();
    private Group unidades = new Group();
     public static Stage secondStage;

    public static PartidaSample partida;

    private long diff;
    private long time1;
    private long time2;


    @Override
    public void start(Stage primaryStage) {

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        partida = new PartidaSample(jugador1, jugador2);
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
        root.setPrefSize(205, 100);
        root.setBorder(null);
        Coordenada coord = new Coordenada (unX+1, unY+1);
        String nombre = partida.obtenerNombreDeUnidad(coord);


        int vida = partida.obtenerVidaDeUnidad(coord);
        String strVida = "" + vida;
        int ataque = partida.obtenerAtaqueDeUnidad(coord);
        String strAtaque = "" + ataque;
        int distancia = partida.obtenerDistanciaDeAtaque(coord);
        String strDistancia = "" + distancia;


        Label etiqueta = new Label(nombre);

        Label ptosVida = new Label("Puntos de Vida: ".concat(strVida));
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
        Image img = new Image("file:TableroTexture.jpg", ANCHO*TAM_CASILLERO, ALTO*TAM_CASILLERO, true, true);
        BackgroundImage myBI= new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Pane root = new Pane();
        root.setBackground(new Background(myBI));
        root.setPrefSize(ANCHO * TAM_CASILLERO, ALTO * TAM_CASILLERO);
        root.getChildren().addAll(casilleros, unidades);

        for (y = 0; y < ALTO; y++) {
            for (x = 0; x < ANCHO; x++) {
                Coordenada coordenada = new Coordenada(x+1,y+1);

                CasilleroVista casillero = new CasilleroVista(x, y);
                tablero[x][y] = casillero;
                casilleros.getChildren().add(casillero);

                UnidadVista unidad = null;

                //Agregar Unidad
                try {
                    nombreUnidad = partida.obtenerNombreDeUnidad(coordenada);
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


        unidadVista.setOnMouseReleased(e -> {
            int newX = posTablero(unidadVista.getLayoutX());
            int newY = posTablero(unidadVista.getLayoutY());
            if (e.getButton()== MouseButton.PRIMARY){
                Mover move = new Mover( new Coordenada(x+1,y+1), new Coordenada(newX+1, newY+1));
                try {
                    partida.jugar(move);
                    unidadVista.mover(newX, newY);
                    CasilleroVista casillero = tablero[unidadVista.posX][unidadVista.posY];
                    casillero.borrarUnidad();
                    casillero = tablero[newX][newY];
                    casillero.agregarUnidad(unidadVista);
                } 	catch (MovimientoInvalidoException cve) {
                    unidadVista.mover(unidadVista.posX, unidadVista.posY);

                }
                catch (FinalException a){
                    //termina el Juego

                }
                catch (Exception c){
                    unidadVista.mover(unidadVista.posX, unidadVista.posY);
                }
            }
            else
                if (e.getButton()==MouseButton.SECONDARY){
                    Coordenada coordAtaque = new Coordenada (unidadVista.posX+1, unidadVista.posY+1);
                    Coordenada coordDefensor = new Coordenada (newX+1, newY+1);
                    Atacar atacar = new Atacar(coordAtaque, coordDefensor);
                    try {
                        int vida = partida.obtenerVidaDeUnidad(coordDefensor);
                        int ataque = partida.obtenerAtaqueDeUnidad(coordAtaque);
                        partida.jugar(atacar);
                        unidadVista.mover(unidadVista.posX, unidadVista.posY);
                        if (vida<= ataque){
                            CasilleroVista casillero = tablero[newX][newY];
                            unidades.getChildren().remove(casillero.obtenerUnidad());
                            casillero.borrarUnidad();
                        }
                        }	catch (FinalException a){
                            //termina el Juego
                            }
                            catch (Exception s){
                                unidadVista.mover(unidadVista.posX, unidadVista.posY);
                            }

                }

        });

        return unidadVista;
    }



    public static void main(String[] args) {
        launch(args);
    }

}