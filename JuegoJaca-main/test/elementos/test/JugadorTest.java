package elementos.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;
import logicaJuego.Constantes;

public class JugadorTest {
	Jugador j1 = new Jugador(PlayerType.ELFO);

	Jugador j2 = new Jugador(PlayerType.GUERRERO);
	Jugador j3 = new Jugador(PlayerType.OGRO);
	Jugador j4 = new Jugador(PlayerType.MAGO);

	@Test
	public void testFuerzaParaLucharElfo() {
		// Aunque me lo cree arriba, me lo creo en el bucle para estos metodos para que
		// sea
		// distinto valor
		for (int i = 0; i <= 10; i++) {
			Jugador j1 = new Jugador(PlayerType.ELFO);
			assertTrue(j1.getFuerzaParaLuchar() >= 0 && j1.getFuerzaParaLuchar() <= Constantes.ELFO_FUERZA);
		}

	}

	@Test
	public void testFuerzaParaLucharOgro() {
		for (int i = 0; i < 100; i++) {
			Jugador j1 = new Jugador(PlayerType.OGRO);
			assertTrue(j1.getFuerzaParaLuchar() >= 0 && j1.getFuerzaParaLuchar() <= Constantes.OGRO_FUERZA);
		}

	}

	@Test
	public void testFuerzaParaLucharGuerrero() {
		for (int i = 0; i < 100; i++) {
			Jugador j1 = new Jugador(PlayerType.GUERRERO);
			assertTrue(j1.getFuerzaParaLuchar() >= 0 && j1.getFuerzaParaLuchar() <= Constantes.GUERRERO_FUERZA);
		}

	}

	@Test
	public void testFuerzaParaLucharMago() {
		for (int i = 0; i < 100; i++) {
			Jugador j1 = new Jugador(PlayerType.MAGO);
			assertTrue(j1.getFuerzaParaLuchar() >= 0 && j1.getFuerzaParaLuchar() <= Constantes.MAGO_FUERZA);
		}

	}

	@Test
	public void testVelocidadParaLucharElfo() {

		for (int i = 0; i <= 10; i++) {
			Jugador j1 = new Jugador(PlayerType.ELFO);
			assertTrue(j1.getMagiaParaLuchar() >= 0 && j1.getMagiaParaLuchar() <= Constantes.ELFO_VELOCIDAD);
		}

	}

	@Test
	public void testVelocidadParaLucharOgro() {

		for (int i = 0; i <= 10; i++) {
			Jugador j1 = new Jugador(PlayerType.OGRO);
			assertTrue(j1.getMagiaParaLuchar() >= 0 && j1.getMagiaParaLuchar() <= Constantes.OGRO_VELOCIDAD);
		}

	}

	@Test
	public void testVelocidadParaLucharGuerrero() {
		for (int i = 0; i < 100; i++) {
			Jugador j1 = new Jugador(PlayerType.GUERRERO);
			assertTrue(j1.getFuerzaParaLuchar() >= 0 && j1.getFuerzaParaLuchar() <= Constantes.GUERRERO_VELOCIDAD);
		}

	}

	@Test
	public void testVelocidadParaLucharMago() {
		for (int i = 0; i < 100; i++) {
			Jugador j1 = new Jugador(PlayerType.MAGO);
			assertTrue(j1.getFuerzaParaLuchar() >= 0 && j1.getFuerzaParaLuchar() <= Constantes.MAGO_VELOCIDAD);
		}

	}

	@Test
	public void testMagiaParaLucharElfo() {

		for (int i = 0; i <= 10; i++) {
			Jugador j1 = new Jugador(PlayerType.ELFO);
			assertTrue(j1.getMagiaParaLuchar() >= 0 && j1.getMagiaParaLuchar() <= Constantes.ELFO_MAGIA);
		}

	}

	@Test
	public void testMagiaParaLucharOgro() {

		for (int i = 0; i <= 10; i++) {
			Jugador j1 = new Jugador(PlayerType.OGRO);
			assertTrue(j1.getMagiaParaLuchar() >= 0 && j1.getMagiaParaLuchar() <= Constantes.OGRO_MAGIA);
		}

	}

	@Test
	public void testMagiaParaLucharGuerrero() {
		for (int i = 0; i < 100; i++) {
			Jugador j1 = new Jugador(PlayerType.GUERRERO);
			assertTrue(j1.getFuerzaParaLuchar() >= 0 && j1.getFuerzaParaLuchar() <= Constantes.GUERRERO_MAGIA);
		}

	}

	@Test
	public void testMagiaParaLucharMago() {
		for (int i = 0; i < 100; i++) {
			Jugador j1 = new Jugador(PlayerType.MAGO);
			assertTrue(j1.getFuerzaParaLuchar() >= 0 && j1.getFuerzaParaLuchar() <= Constantes.MAGO_MAGIA);
		}

	}

	@Test
	public void setDineroLimiteAlto() {
		try {
			j1.setDinero(3);
			fail("Tiene que saltar la excepcion porque el dinero no puede ser mas de 2");
		} catch (JugadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void setDineroLimiteBajo() {
		try {
			j1.setDinero(-1);
			fail("Tiene que saltar la excepcion porque el dinero no puede ser negativo");
		} catch (JugadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void setDineroLimite2() {
		try {
			j1.setDinero(2);
		} catch (JugadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void setDineroLimite0() {
		try {
			j1.setDinero(0);
		} catch (JugadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void setPocionesLimiteAlto() {
		try {
			j1.setPociones(4);
			fail("Tiene que saltar la excepcion porque las pociones no puede ser ,as de 3");
		} catch (JugadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void setPocionesLimiteBajo() {
		try {
			j1.setPociones(-1);
			fail("Tiene que saltar la excepcion porque las pociones no puede ser negativo");
		} catch (JugadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void setPocionesLimite3() {
		try {
			j1.setPociones(3);
		} catch (JugadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void setPocionesLimite0() {
		try {
			j1.setPociones(0);
		} catch (JugadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void setGemasLimiteAlto() {
		try {
			j1.setGemas(6);
			fail("Tiene que saltar la excepcion porque las gemas no puede ser mas de 5");
		} catch (JugadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void setGemasLimiteBajo() {
		try {
			j1.setGemas(-1);
			fail("Tiene que saltar la excepcion porque las gemas no puede ser negativo");
		} catch (JugadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void setGemasLimite5() {
		try {
			j1.setGemas(5);
		} catch (JugadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void setGemasLimite0() {
		try {
			j1.setGemas(0);
		} catch (JugadorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void resumen() {
		assertEquals("Nombre: OGRO Gemas: 0 Dinero: 0Pociones: 0", j3.resumen());
	}

	@Test
	public void encuentraGema() {
		j1.encuentraGema();
		assertEquals(1, j1.getGemas());
	}

	@Test
	public void encuentraDinero() {
		j1.encuentraDinero();
		assertEquals(1, j1.getDinero());
	}

	@Test
	public void rompeRocaConGema() {
		// Me creo el jugador para que siempre no tega la misma magia
		for (int i = 0; i < 10; i++) {
			Jugador j = new Jugador(PlayerType.MAGO);
			j.encuentraGema();
			assertEquals(Constantes.ROMPE_ROCA_CON_GEMA, j.encuentraRoca());
		}
	}

	@Test
	public void ganaRocaOPierdeConRoca() {
			int encuentro = j1.encuentraRoca();
			//Lo he puesto asi, porque si encuentro es igual a uno u a otro, pues 
			//la condición es igual de valida
			assertTrue(encuentro == Constantes.GANA_A_LA_ROCA || encuentro == Constantes.PIERDE_A_LA_ROCA);
		}
}
