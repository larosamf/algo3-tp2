package grupo.N6.algochess;

import static org.junit.Assert.assertEquals;

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
	
	@Test
	public void test04SoldadoDeInfanteriaRecienCreadoTieneCoordenada0X(){
		SoldadoDeInfanteria soldado = new SoldadoDeInfanteria();

		assertEquals(0, soldado.getCoordenadaX());
	}

}