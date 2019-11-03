package grupo.N6.algochess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class JugadorPerdioTest {
	
	@Test
	public void test01JugadorSinUnidadesEsElPerdedor() {
		Jugador jugador = new Jugador();
		
		assertEquals(true, jugador.perdio());
		
	}
	
}