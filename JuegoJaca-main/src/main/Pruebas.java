package main;

import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;
import logicaJuego.Juego;
import logicaJuego.JuegoException;
import logicaJuego.JuegoGUI;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayerType [] jugador=new PlayerType[4];
		jugador[0]=PlayerType.OGRO;
		jugador[1]=PlayerType.MAGO;
		jugador[2]=PlayerType.GUERRERO;
		jugador[3]=PlayerType.ELFO;
		Jugador j = new Jugador(PlayerType.OGRO);
		try {
			j.setPociones(4);
		} catch (JugadorException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			JuegoGUI j1=new JuegoGUI(jugador);
		} catch (JuegoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
