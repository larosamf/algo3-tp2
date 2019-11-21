package grupo.N6.algochess;

import org.junit.Assert;
import org.junit.Test;

public class CoordenadaTest {
    @Test
    public void test01DosCoordenadasConLosMismosValoresSonIguales() {
        Assert.assertEquals(new Coordenada(1, 1), new Coordenada(1, 1));
    }

    @Test
    public void test02DosCoordenadasConDistintosValoresSonDistintas() {
        Assert.assertFalse(new Coordenada(1, 1).equals(new Coordenada(1, 2)));
    }

    @Test
    public void test03DosCoordenadasUnaAbajoDeOtraSonAdyacentes() {
        Assert.assertTrue(new Coordenada(1, 1).esConsecutiva(new Coordenada(1, 2)));
    }

    @Test
    public void test04DosCoordenadasUnaAlLadoDeOtraSonAdyacentes() {
        Assert.assertTrue(new Coordenada(1, 1).esConsecutiva(new Coordenada(2, 1)));
    }

    @Test
    public void test05DosCoordenadasEnDiagonalSonAdyacentes() {
        Assert.assertTrue(new Coordenada(1, 1).esConsecutiva(new Coordenada(2, 2)));
        Assert.assertTrue(new Coordenada(2, 2).esConsecutiva(new Coordenada(1, 1)));
        Assert.assertTrue(new Coordenada(4, 5).esConsecutiva(new Coordenada(5, 6)));
        Assert.assertTrue(new Coordenada(4, 5).esConsecutiva(new Coordenada(5, 4)));
        Assert.assertTrue(new Coordenada(4, 5).esConsecutiva(new Coordenada(3, 6)));
        Assert.assertTrue(new Coordenada(4, 5).esConsecutiva(new Coordenada(3, 4)));
    }

    @Test
    public void test06DosCoordenadasSeparadasNoSonAdyacentes() {
        Assert.assertFalse(new Coordenada(1, 1).esConsecutiva(new Coordenada(3, 3)));
    }

    @Test
    public void testDistancias() {
        Assert.assertEquals(
                new Coordenada(6, 8).distanciaHasta(new Coordenada(3, 1)),
                new Coordenada(3, 1).distanciaHasta(new Coordenada(6, 8)));
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(1, 1)), 2);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(1, 2)), 2);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(1, 3)), 2);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(1, 4)), 2);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(1, 5)), 2);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(2, 5)), 2);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(3, 5)), 2);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(4, 5)), 2);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(5, 5)), 2);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(5, 4)), 2);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(5, 3)), 2);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(5, 2)), 2);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(5, 1)), 2);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(4, 1)), 2);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(3, 1)), 2);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(2, 1)), 2);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(2, 2)), 1);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(2, 3)), 1);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(2, 4)), 1);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(3, 4)), 1);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(4, 4)), 1);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(4, 3)), 1);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(4, 2)), 1);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(3, 2)), 1);
        Assert.assertEquals(new Coordenada(3, 3).distanciaHasta(new Coordenada(3, 3)), 0);
    }
}

