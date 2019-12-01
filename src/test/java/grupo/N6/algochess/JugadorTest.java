package grupo.N6.algochess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import grupo.N6.algochess.modelo.exepciones.FinalException;
import grupo.N6.algochess.modelo.exepciones.PuntosInsuficientesParaAgregarUnidadException;
import grupo.N6.algochess.modelo.Jugador;
import grupo.N6.algochess.modelo.posicionables.unidades.Catapulta;
import grupo.N6.algochess.modelo.posicionables.unidades.SoldadoDeInfanteria;
import org.junit.Test;

public class JugadorTest {
	
	@Test
	public void test01JugadorRecienCreadoTieneUnPuntoMenosDespuesAgregarUnSoldadoDeInfanteria() {
		
		//Arrange:
		Jugador jugador = new Jugador();
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
		
		//Act:
		jugador.agregarUnidad(soldado);
		
		//Assert:
		assertEquals(19, jugador.getPuntos());
		
	}
	
	@Test
	public void test02JugadorQueGastoTodosSusPuntosEnUnidadesNoPuedeAgregarNingunaMas() {
		
		//Arrange:
		Jugador jugador = new Jugador();
		
		jugador.agregarUnidad(new Catapulta());
		jugador.agregarUnidad(new Catapulta());
		jugador.agregarUnidad(new Catapulta());
		jugador.agregarUnidad(new Catapulta());
		
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
		
		//Act y Assert:
		assertThrows(PuntosInsuficientesParaAgregarUnidadException.class,
    			()->{
    				jugador.agregarUnidad(soldado);;
    			});
		
	}
	
	@Test
	public void test03JugadorSinUnidadesEsElPerdedor() {
		
		//Arrange:
		Jugador jugador = new Jugador();
		
		//Act y Assert:
		assertThrows(FinalException.class,
    			()->{
    				jugador.sigueParticipando();;
    			});
	}

}
