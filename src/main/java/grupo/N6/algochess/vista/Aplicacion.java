package grupo.N6.algochess.vista;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage escenario) {

        VBox contenedorEntrada = new VBox();
        Scene escenaInicial = new Scene(contenedorEntrada);

        escenario.setTitle("AlgoChess");
        escenario.setScene(escenaInicial);
        escenario.show();
    }
}