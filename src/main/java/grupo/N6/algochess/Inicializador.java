package grupo.N6.algochess;

import grupo.N6.algochess.accionesDePartida.Posicionar;
import grupo.N6.algochess.posicionables.unidades.*;

import java.util.Scanner;

public class Inicializador {

    public void inicializarJugadores(Jugador jugador1, Jugador jugador2){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del Jugador 1");
        String nombreJugador1 = scanner.nextLine();
        System.out.println("El nombre del Jugador 1 es " +nombreJugador1);

        System.out.println("Ingrese el nombre del Jugador 2");
        String nombreJugador2 = scanner.nextLine();
        System.out.println("El nombre del Jugador 2 es " +nombreJugador2);

        jugador1.setNombre(nombreJugador1);
        jugador2.setNombre(nombreJugador2);

    };

        public Unidad comprarUnidad(Jugador jugador){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Que unidad desea comprar?");
        System.out.println("A) Soldado de Infanteria");
        System.out.println("B) Jinete");
        System.out.println("C) Catapulta");
        System.out.println("D) Curandero");

        Character leer = scanner.next().charAt(0);
        System.out.println("Ha seleccionado la opcion " +leer);

        if(leer == 'A'){
            System.out.println("Ha comprado un Soldado de Infanteria");
            SoldadoDeInfanteria soldadoDeInfanteria = new SoldadoDeInfanteria();
            return(soldadoDeInfanteria);
        }

        if(leer == 'B'){
            System.out.println("Ha comprado un Jinete");
            Jinete jinete = new Jinete();
            return(jinete);
        }

        if(leer == 'C'){
            System.out.println("Ha comprado una Catapulta");
            Catapulta catapulta = new Catapulta();
            return(catapulta);
        }


            System.out.println("Ha comprado un Curandero");
            Curandero curandero = new Curandero();
            return(curandero);


    }

    public void iniciarEtapaDePosicionamiento(Partida partida){

        Unidad unidadComprada = comprarUnidad(partida.obtenerJugadorActivo());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la posicion x de su ficha");
        Integer x = scanner.nextInt();

        System.out.println("Ingrese la posicion y de su ficha");
        Integer y = scanner.nextInt();

        System.out.println("Su unidad sera ubicada en " +x + " "+y);

        Coordenada posicion = new Coordenada(x, y);
        Posicionar posicionar = new Posicionar(unidadComprada,posicion);
        posicionar.ejecutarSobre(partida);

    }


}
