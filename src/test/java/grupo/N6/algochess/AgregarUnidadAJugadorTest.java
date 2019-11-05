package grupo.N6.algochess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import grupo.N6.algochess.exepciones.PuntosInsuficientesParaAgregarUnidadException;
import grupo.N6.algochess.unidades.Catapulta;
import grupo.N6.algochess.unidades.SoldadoDeInfanteria;
import org.junit.Test;

public class AgregarUnidadAJugadorTest {
	
	@Test
	public void test01JugadorRecienCreadoTieneUnPuntoMenosDespuesAgregarUnSoldadoDeInfanteria() {
		Jugador jugador = new Jugador();
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
		
		jugador.agregarUnidad(soldado);
		
		assertEquals(19, jugador.getPuntos());
		
	}
	
	@Test
	public void test02JugadorQueGastoTodosSusPuntosEnUnidadesNoPuedeAgregarNingunaMas() {
		Jugador jugador = new Jugador();
		
		jugador.agregarUnidad(new Catapulta());
		jugador.agregarUnidad(new Catapulta());
		jugador.agregarUnidad(new Catapulta());
		jugador.agregarUnidad(new Catapulta());
		
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
		
		assertThrows(PuntosInsuficientesParaAgregarUnidadException.class,
    			()->{
    				jugador.agregarUnidad(soldado);;
    			});
		
	}

}