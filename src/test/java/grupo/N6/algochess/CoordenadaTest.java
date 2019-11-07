package grupo.N6.algochess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CoordenadaTest {
	
	@Test
	public void test01Coordenada2Xy3YRecienCreadaTiene2ComoX() {
		Coordenada coordenada= new Coordenada(2, 3);
		
		assertEquals(2, coordenada.getX());
	}
	
	@Test
	public void test02Coordenada2Xy3YRecienCreadaTiene3ComoY() {
		Coordenada coordenada= new Coordenada(2, 3);
		
		assertEquals(3, coordenada.getY());
	}

}
