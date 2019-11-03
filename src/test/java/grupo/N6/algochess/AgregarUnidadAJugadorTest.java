package grupo.N6.algochess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AgregarUnidadAJugadorTest {
	
	@Test
	public void test01JugadorRecienCreadoTiene19PuntosDespuesAgregarUnSoldadoDeInfanteria() {
		Jugador jugador = new Jugador();
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
		
		jugador.agregarUnidad(soldado);
		
		assertEquals(19, jugador.getPuntos());
		
	}

}