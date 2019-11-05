package grupo.N6.algochess;

import static org.junit.Assert.assertEquals;

import grupo.N6.algochess.unidades.SoldadoDeInfanteria;
import org.junit.Test;

public class CreacionDeUnidadesTest {
	
	@Test
	public void test01SoldadoDeInfanteriaRecienCreadoTiene100DeVida() {
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();
		
		assertEquals(100, soldado.getVida());
	}

	@Test
	public void test02SoldadoDeInfanteriaRecienCreadoTieneCosto1(){
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();

		assertEquals(1, soldado.getCosto());
	}

}