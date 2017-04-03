package tateti;

import org.junit.Assert;
import org.junit.Test;

public class TestTablero {

	@Test
	public void ponerCruzTest() {
		Tablero tablero = new Tablero();
		Ficha fichaCruz = new Ficha("x");
		tablero.ponerFicha(1,1, fichaCruz);
		Ficha FichaActual = tablero.get(1,1);
		String esperado = FichaActual.getId();
		Assert.assertEquals("x", esperado);
	}
	
	@Test
	public void ponerCirculoTest() {
		Tablero tablero = new Tablero();
		Ficha fichaCirculo = new Ficha("o");
		tablero.ponerFicha(2,2, fichaCirculo);
		Ficha FichaActual = tablero.get(2,2);
		String esperado = FichaActual.getId();
		Assert.assertEquals("o", esperado);
	}
	
	@Test
	public void ganoEnHorizontalEnPosicion0deXCirculo() {
		Tablero tablero = new Tablero();
		Ficha fichaCirculo = new Ficha("o");
		tablero.ponerFicha(0, 0,fichaCirculo);
		tablero.ponerFicha(0, 1,fichaCirculo);
		tablero.ponerFicha(0, 2,fichaCirculo);
		boolean esperado = tablero.gano(fichaCirculo);
		Assert.assertTrue(esperado);
	}
	
	@Test
	public void ganoEnVerticalEnPosicion0deYCruz() {
		Tablero tablero = new Tablero();
		Ficha fichaCruz = new Ficha("x");
		tablero.ponerFicha(0, 0,fichaCruz);
		tablero.ponerFicha(1, 0,fichaCruz);
		tablero.ponerFicha(2, 0,fichaCruz);
		boolean esperado = tablero.gano(fichaCruz);
		Assert.assertTrue(esperado);
	}
	
	@Test
	public void ganoEnVerticalEnPosicion1deYCruz() {
		Tablero tablero = new Tablero();
		Ficha fichaCruz = new Ficha("x");
		tablero.ponerFicha(0, 1,fichaCruz);
		tablero.ponerFicha(1, 1,fichaCruz);
		tablero.ponerFicha(2, 1,fichaCruz);
		boolean esperado = tablero.gano(fichaCruz);
		Assert.assertTrue(esperado);
	}
	
	@Test
	public void ganoEnVerticalEnPosicion2deYCirculo() {
		Tablero tablero = new Tablero();
		Ficha fichaCirculo = new Ficha("o");
		tablero.ponerFicha(0, 2,fichaCirculo);
		tablero.ponerFicha(1, 2,fichaCirculo);
		tablero.ponerFicha(2, 2,fichaCirculo);
		boolean esperado = tablero.gano(fichaCirculo);
		Assert.assertTrue(esperado);
	}
	
	@Test
	public void ganoEnPerpendicularDescendenteCirculo() {
		Tablero tablero = new Tablero();
		Ficha fichaCirculo = new Ficha("o");
		tablero.ponerFicha(0, 0,fichaCirculo);
		tablero.ponerFicha(1, 1,fichaCirculo);
		tablero.ponerFicha(2, 2,fichaCirculo);
		boolean esperado = tablero.gano(fichaCirculo);
		Assert.assertTrue(esperado);
	}
	
	@Test
	public void ganoEnPerpendicularAscendenteCruz() {
		Tablero tablero = new Tablero();
		Ficha fichaCruz = new Ficha("x");
		tablero.ponerFicha(2, 0,fichaCruz);
		tablero.ponerFicha(1, 1,fichaCruz);
		tablero.ponerFicha(0, 2,fichaCruz);
		boolean esperado = true;
		Assert.assertEquals(esperado, tablero.gano(fichaCruz));
	}
	
	@Test
	public void noGanoEnHorizontalEnPosicion2deXCruz() {
		Tablero tablero = new Tablero();
		Ficha fichaCruz = new Ficha("x");
		tablero.ponerFicha(2, 0,fichaCruz);
		tablero.ponerFicha(2, 1,fichaCruz);
		tablero.ponerFicha(0, 2,fichaCruz);
		boolean esperado = false;
		Assert.assertEquals(esperado, tablero.gano(fichaCruz));
	}
	
	@Test
	public void empate() {
		Tablero tablero = new Tablero();
		Ficha fichaCruz = new Ficha("x");
		Ficha fichaCirculo = new Ficha("o");
		tablero.ponerFicha(0, 0,fichaCruz);
		tablero.ponerFicha(0, 1,fichaCirculo);
		tablero.ponerFicha(0, 2,fichaCirculo);
		tablero.ponerFicha(1, 0,fichaCirculo);
		tablero.ponerFicha(1, 1,fichaCruz);
		tablero.ponerFicha(2, 1,fichaCruz);
		tablero.ponerFicha(2, 2,fichaCirculo);
		boolean esperado = true;
		//Assert.assertEquals(esperado, tablero.empate());
	}
	
	/*
	@org.junit.Test(expected=FichaNoValidaException.class)
	public void fichaNoValidaExcTest() {
		Tablero tablero = new Tablero();
		Ficha fichaNoValida = new Ficha("r");
	}
*/
}