package main;

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
		
		try {
			JuegoGUI j1=new JuegoGUI(jugador);
		} catch (JuegoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
