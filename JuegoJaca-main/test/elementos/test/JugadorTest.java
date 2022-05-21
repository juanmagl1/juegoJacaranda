package elementos.test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import elementos.Jugador;
import elementos.PlayerType;
import logicaJuego.Constantes;

public class JugadorTest {
	Jugador j1=new Jugador(PlayerType.ELFO);
	Jugador j2=new Jugador(PlayerType.GUERRERO);
	Jugador j3=new Jugador(PlayerType.OGRO);
	Jugador j4=new Jugador(PlayerType.MAGO);
	@Test 
	public void testFuerzaParaLucharElfo() {
		//Aunque me lo cree arriba, me lo creo en el bucle para estos metodos para que sea
		//distinto valor
		for (int i=0;i<=10;i++) {
			Jugador j1=new Jugador(PlayerType.ELFO);
			assertTrue(j1.getFuerzaParaLuchar()>=0 && j1.getFuerzaParaLuchar()<=Constantes.ELFO_FUERZA);
		}
		
	}
	@Test 
	public void testFuerzaParaLucharOgro() {
		for (int i=0;i<100;i++) {
			Jugador j1=new Jugador(PlayerType.OGRO);
			assertTrue(j1.getFuerzaParaLuchar()>=0 && j1.getFuerzaParaLuchar()<=Constantes.OGRO_FUERZA);
		}
		
	}
	@Test 
	public void testFuerzaParaLucharGuerrero() {
		for (int i=0;i<100;i++) {
			Jugador j1=new Jugador(PlayerType.GUERRERO);
			assertTrue(j1.getFuerzaParaLuchar()>=0 && j1.getFuerzaParaLuchar()<=Constantes.GUERRERO_FUERZA);
		}
		
	}
	@Test 
	public void testFuerzaParaLucharMago() {
		for (int i=0;i<100;i++) {
			Jugador j1=new Jugador(PlayerType.MAGO);
			assertTrue(j1.getFuerzaParaLuchar()>=0 && j1.getFuerzaParaLuchar()<=Constantes.MAGO_FUERZA);
		}
		
	}
	@Test 
	public void testVelocidadParaLucharElfo() {

		for (int i=0;i<=10;i++) {
			Jugador j1=new Jugador(PlayerType.ELFO);
			assertTrue(j1.getMagiaParaLuchar()>=0 && j1.getMagiaParaLuchar()<=Constantes.ELFO_VELOCIDAD);
		}
		
	}
	@Test 
	public void testVelocidadParaLucharOgro() {

		for (int i=0;i<=10;i++) {
			Jugador j1=new Jugador(PlayerType.OGRO);
			assertTrue(j1.getMagiaParaLuchar()>=0 && j1.getMagiaParaLuchar()<=Constantes.OGRO_VELOCIDAD);
		}
		
	}
	@Test 
	public void testVelocidadParaLucharGuerrero() {
		for (int i=0;i<100;i++) {
			Jugador j1=new Jugador(PlayerType.GUERRERO);
			assertTrue(j1.getFuerzaParaLuchar()>=0 && j1.getFuerzaParaLuchar()<=Constantes.GUERRERO_VELOCIDAD);
		}
		
	}
	@Test 
	public void testVelocidadParaLucharMago() {
		for (int i=0;i<100;i++) {
			Jugador j1=new Jugador(PlayerType.MAGO);
			assertTrue(j1.getFuerzaParaLuchar()>=0 && j1.getFuerzaParaLuchar()<=Constantes.MAGO_VELOCIDAD);
		}
		
	}
	@Test 
	public void testMagiaParaLucharElfo() {

		for (int i=0;i<=10;i++) {
			Jugador j1=new Jugador(PlayerType.ELFO);
			assertTrue(j1.getMagiaParaLuchar()>=0 && j1.getMagiaParaLuchar()<=Constantes.ELFO_MAGIA);
		}
		
	}
	@Test 
	public void testMagiaParaLucharOgro() {

		for (int i=0;i<=10;i++) {
			Jugador j1=new Jugador(PlayerType.OGRO);
			assertTrue(j1.getMagiaParaLuchar()>=0 && j1.getMagiaParaLuchar()<=Constantes.OGRO_MAGIA);
		}
		
	}
	@Test 
	public void testMagiaParaLucharGuerrero() {
		for (int i=0;i<100;i++) {
			Jugador j1=new Jugador(PlayerType.GUERRERO);
			assertTrue(j1.getFuerzaParaLuchar()>=0 && j1.getFuerzaParaLuchar()<=Constantes.GUERRERO_MAGIA);
		}
		
	}
	@Test 
	public void testMagiaParaLucharMago() {
		for (int i=0;i<100;i++) {
			Jugador j1=new Jugador(PlayerType.MAGO);
			assertTrue(j1.getFuerzaParaLuchar()>=0 && j1.getFuerzaParaLuchar()<=Constantes.MAGO_MAGIA);
		}
		
	}
	
}
