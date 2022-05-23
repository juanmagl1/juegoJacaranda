package logicaJuego.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;
import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;
import logicaJuego.Constantes;
import logicaJuego.Juego;
import logicaJuego.JuegoException;

public class JuegoTest {
	@Test 
	public void imprimeValoresJugadores() {
		//Me creo el array de jugadores, para despues con un for ir metiendolos en el array
		//Me creo un nuevo juego con el array de jugadores
		PlayerType[] jugadores = new PlayerType[Constantes.NUM_JUGADORES];
		jugadores[0]=PlayerType.GUERRERO;
		jugadores[1]=PlayerType.ELFO;
		jugadores[2]=PlayerType.OGRO;
		jugadores[3]=PlayerType.MAGO;
		Juego j1 = new Juego(jugadores);
		assertEquals("El jugador 1 es un GUERRERO\n"
				+ "El jugador 2 es un ELFO\n"
				+ "El jugador 3 es un OGRO\n"
				+ "El jugador 4 es un MAGO", j1.imprimeNombreJugadores());
	}
	@Test
	public void setDado() {
		PlayerType[]jugadores = new PlayerType[Constantes.NUM_JUGADORES]; 
		for(int i=0;i<Constantes.NUM_JUGADORES;i++) {
			jugadores[i]=PlayerType.ELFO;
		}
		Juego j1 = new Juego(jugadores);
		j1.setDado();
	
		for(int i=0;i<20;i++) {
			assertTrue(j1.getValorDado()>0 && j1.getValorDado()<= Constantes.ELFO_VELOCIDAD);
			
		}
		
	}
	@Test
	public void proximoJugador() {
		PlayerType[]jugadores = new PlayerType[Constantes.NUM_JUGADORES]; 
		jugadores[0]=PlayerType.ELFO;
		jugadores[1]=PlayerType.MAGO;
		jugadores[2]=PlayerType.OGRO;
		jugadores[3]=PlayerType.GUERRERO;
		
		Juego juego = new Juego(jugadores);
		juego.proximoJugador();
		assertEquals("MAGO", juego.getNombreJugadorQueJuega());
		
	}
	@Test 
	public void proximoJugadorInicia() {
		PlayerType[]jugadores = new PlayerType[Constantes.NUM_JUGADORES]; 
		jugadores[0]=PlayerType.ELFO;
		jugadores[1]=PlayerType.MAGO;
		jugadores[2]=PlayerType.OGRO;
		jugadores[3]=PlayerType.GUERRERO;
		Juego juego = new Juego(jugadores);
			juego.proximoJugador();
			juego.proximoJugador();
			juego.proximoJugador();
			juego.proximoJugador();
		assertEquals("ELFO", juego.getNombreJugadorQueJuega());
		
	}
	@Test 
	public void isGanadorUno() {
		PlayerType[]jugadores = new PlayerType[1]; 
		jugadores[0]=PlayerType.OGRO;
		Juego juego = new Juego(jugadores);
		assertTrue(juego.isTerminado());
		
	}
	@Test 
	public void isNotTerminado() {
		PlayerType[]jugadores = new PlayerType[Constantes.NUM_JUGADORES]; 
		jugadores[0]=PlayerType.ELFO;
		jugadores[1]=PlayerType.MAGO;
		jugadores[2]=PlayerType.OGRO;
		jugadores[3]=PlayerType.GUERRERO;
		Juego juego = new Juego(jugadores);
		assertFalse(juego.isTerminado());
	}
	@Test 
	public void ganaConDinero() throws JugadorException {
		PlayerType[]jugadores = new PlayerType[2]; 
		jugadores[0]=PlayerType.ELFO;
		jugadores[1]=PlayerType.MAGO;
		Juego juego = new Juego(jugadores);
		//Obtenfo la coordenada del jugador
		Coordenada c=juego.obtenerCoordenadaJugadorJuega();
		//Saco el elemento del tablero
		Jugador j=(Jugador) juego.obtenerElementoTablero(c);
		j.setDinero(Constantes.NUM_DINERO);
		
		assertTrue(juego.isTerminado());
	}
	@Test
	public void moverNorte() throws JugadorException, JuegoException {
		PlayerType[]jugadores = new PlayerType[Constantes.NUM_JUGADORES]; 
		jugadores[0]=PlayerType.ELFO;
		jugadores[1]=PlayerType.MAGO;
		jugadores[2]=PlayerType.OGRO;
		jugadores[3]=PlayerType.GUERRERO;
		for(int i=0;i<10;i++) {
			Juego j = new Juego(jugadores);
			
			Coordenada c =j.obtenerCoordenadaJugadorJuega();
			if(c.getY()!=0) {
				try {
					j.movePlayer('N');
				} catch (JuegoException | JugadorException | CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c.goUp();
				assertEquals(c, j.obtenerCoordenadaJugadorJuega());
			}
		}
		
		
	}
	
	
	@Test
	public void moverSur() throws JugadorException, JuegoException {
		PlayerType[]jugadores = new PlayerType[Constantes.NUM_JUGADORES]; 
		jugadores[0]=PlayerType.ELFO;
		jugadores[1]=PlayerType.MAGO;
		jugadores[2]=PlayerType.OGRO;
		jugadores[3]=PlayerType.GUERRERO;
		for(int i=0;i<10;i++) {
			Juego j = new Juego(jugadores);
			
			Coordenada c =j.obtenerCoordenadaJugadorJuega();
			if(c.getY()!=9) {
				try {
					j.movePlayer('S');
				} catch (JuegoException | JugadorException | CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c.goDown();
				assertEquals(c, j.obtenerCoordenadaJugadorJuega());
			}
		}
		
	}
	
	
		@Test
		public void moverEste() throws JugadorException, JuegoException {
			PlayerType[]jugadores = new PlayerType[Constantes.NUM_JUGADORES]; 
			jugadores[0]=PlayerType.ELFO;
			jugadores[1]=PlayerType.MAGO;
			jugadores[2]=PlayerType.OGRO;
			jugadores[3]=PlayerType.GUERRERO;
			for(int i=0;i<10;i++) {
				Juego j = new Juego(jugadores);
				
				Coordenada c =j.obtenerCoordenadaJugadorJuega();
				if(c.getX()!=9) {
					try {
						j.movePlayer('E');
					} catch (JuegoException | JugadorException | CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					c.goRight();
					assertEquals(c, j.obtenerCoordenadaJugadorJuega());
				}
			}
			
		}
				
		@Test
		public void moverOeste() throws JugadorException, JuegoException {
			PlayerType[]jugadores = new PlayerType[Constantes.NUM_JUGADORES]; 
			jugadores[0]=PlayerType.ELFO;
			jugadores[1]=PlayerType.MAGO;
			jugadores[2]=PlayerType.OGRO;
			jugadores[3]=PlayerType.GUERRERO;
			for(int i=0;i<10;i++) {
				Juego j = new Juego(jugadores);
				
				Coordenada c =j.obtenerCoordenadaJugadorJuega();
				if(c.getX()!=0) {
					try {
						j.movePlayer('O');
					} catch (JuegoException | JugadorException | CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					c.goLeft();
					assertEquals(c, j.obtenerCoordenadaJugadorJuega());
				}
			}
			
		}
		
		
				@Test
				public void moverError() throws JugadorException {
					PlayerType[]jugadores = new PlayerType[Constantes.NUM_JUGADORES]; 
					jugadores[0]=PlayerType.ELFO;
					jugadores[1]=PlayerType.MAGO;
					jugadores[2]=PlayerType.OGRO;
					jugadores[3]=PlayerType.GUERRERO;
					Juego j = new Juego(jugadores);
					Coordenada c =j.obtenerCoordenadaJugadorJuega();
						
					try {
						try {
							j.movePlayer('J');
							fail("Tendria que saltar una exception");
						} catch (JugadorException | CloneNotSupportedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					} catch (JuegoException e) {
						
						e.printStackTrace();
					
					
					
				}
				}
				@Test
				public void decrementarDado() {
					PlayerType[]jugadores = new PlayerType[Constantes.NUM_JUGADORES]; 
					jugadores[0]=PlayerType.ELFO;
					jugadores[1]=PlayerType.MAGO;
					jugadores[2]=PlayerType.OGRO;
					jugadores[3]=PlayerType.GUERRERO;
					Juego j = new Juego(jugadores);
					j.setDado();
					int valorDado = j.getValorDado();
					j.decrementaDado();
					assertEquals(valorDado-1, j.getValorDado());
}
}
