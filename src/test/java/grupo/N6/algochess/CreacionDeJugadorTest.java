package grupo.N6.algochess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CreacionDeJugadorTest {
	
	@Test
	public void test01JugadorRecienCreadoTiene20Puntos() {
		Jugador jugador = new Jugador();
		
		assertEquals(20, jugador.getPuntos());
	}

}