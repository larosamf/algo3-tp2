package grupo.N6.algochess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import grupo.N6.algochess.posicionables.unidades.Catapulta;
import grupo.N6.algochess.posicionables.unidades.SoldadoDeInfanteria;
import grupo.N6.algochess.posicionables.unidades.Unidad;

public class PartidaTest {
	
	@Test
	public void test01ObtenerGanadorDevuelveElQueCuentaConUnidadesVidas() {
		
		//Arrange:
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Partida partida = new Partida(jugador1, jugador2);
		Unidad catapulta = new Catapulta();
		jugador1.agregarUnidad(catapulta);

		//Act y Assert
		assertEquals(partida.obtenerGanador(), jugador1);
	}

	@Test
	public void test02PartidaSampleSeInicializaCorrectamente() {

		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		PartidaSample partida = new PartidaSample(jugador1, jugador2);

		assertTrue(partida.obtenerUnidadDePosicion(new Coordenada(10,1)).esCatapulta());
		assertTrue(partida.obtenerUnidadDePosicion(new Coordenada(9,3)).esSoldado());
		assertTrue(partida.obtenerUnidadDePosicion(new Coordenada(13,5)).esSoldado());
		assertTrue(partida.obtenerUnidadDePosicion(new Coordenada(10,17)).esCurandero());

	}

}