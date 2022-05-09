package elementos.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;

class CoordenadaTest {
	Coordenada c1=new Coordenada(1,1);
	Coordenada c2=new Coordenada(-1,1);
	Coordenada c3=new Coordenada(-1,-1);
	Coordenada c4=new Coordenada(0,-1);

	@Test
	public void coordenadaCorrecta() {
		Coordenada expected=new Coordenada(1,1);
		assertEquals(expected, c1);
		
	}
	@Test
	public void coordenadaXIncorrectaYCorrecta() {
		Coordenada expected=new Coordenada(0,0);
		assertEquals(expected, c2);
	}
	@Test
	public void coordenadaXCorrectaYIncorrecta() {
		Coordenada expected=new Coordenada(0,0);
		assertEquals(expected, c4);
	}
	@Test
	public void coordenadaXIncorrecta() {
		Coordenada expected=new Coordenada(0,0);
		assertEquals(expected, c3);
	}
	@Test 
	public void goDownMalo() {
		Coordenada c6=new Coordenada(1,9);
		assertFalse(c6.goDown());
	}
	@Test 
	public void goDownBueno() {
		assertTrue(c1.goRight());
	}
	@Test 
	public void goRightBueno() {
		assertTrue(c1.goRight());
	}
	@Test
	public void goRightMalo() {
		Coordenada c8=new Coordenada(9,0);
		assertFalse(c8.goRight());
	}
	@Test
	public void goLeftBueno() {
		assertTrue(c1.goLeft());
	}
	@Test
	public void goLeftMalo() {
		Coordenada c9=new Coordenada(0,0);
		assertFalse(c9.goLeft());
	}
	@Test
	public void goUpBueno() {
		assertTrue(c1.goUp());
	}
	@Test
	public void goUpMalo() {
		Coordenada c15=new Coordenada(1,0);
		assertFalse(c15.goUp());
	}
}
