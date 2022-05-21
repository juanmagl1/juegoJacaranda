package logicaJuego;

import java.util.ArrayList;
import java.util.HashMap;


import elementos.*;

public class Juego {

	private HashMap<Coordenada, Element> tablero;
	private ArrayList<Coordenada> coordenadaJugadores;
	private int jugadorJuega;
	private int dado; // Dado para ver los movimientos del jugador que juega

	public Juego(PlayerType[] personaje) {
		super();
		tablero = new HashMap<>();
		coordenadaJugadores = new ArrayList<>();
		crearTablero();
		for (int i = 0; i < Constantes.NUM_JUGADORES; i++) {
			crearJugador(personaje[i]);
		}
	}

	private void crearTablero() {
		crearDinero();
		crearGemas();
		crearPociones();
		crearRocas();
	}

	private boolean crearJugador(PlayerType tipo) {
		boolean creado = false;
		Jugador j = new Jugador(tipo);
		Coordenada c = new Coordenada();
		// Compruebo si esta la coordenada ocupada, sino creo una coordenada nueva
		while (coordenadaJugadores.contains(c)) {
			c = new Coordenada();
		}
		coordenadaJugadores.add(c);
		tablero.put(c, j);
		creado = true;
		return creado;
	}

	private void crearRocas() {
		int i = 0;
		while (i < Constantes.NUM_ROCAS) {
			Coordenada c = new Coordenada();
			Element e = new Element(ElementType.ROCA);
			// Si el get de la coordenada es null lo que hago es a馻dirla, sino no aumento
			// el contador
			if (tablero.get(c) == null) {
				this.tablero.put(c, e);
				i++;
			}

		}
	}

	private void crearGemas() {
		int i = 0;
		while (i < Constantes.NUM_GEMAS) {
			Coordenada c = new Coordenada();
			Element e = new Element(ElementType.GEMA);
			// Si el get de la coordenada es null lo que hago es a馻dirla, sino no aumento
			// el contador
			if (tablero.get(c) == null) {
				this.tablero.put(c, e);
				i++;
			}

		}
	}

	private void crearPociones() {
		int i = 0;
		while (i < Constantes.NUM_POCIONES) {
			Coordenada c = new Coordenada();
			Element e = new Element(ElementType.POCION);
			// Si el get de la coordenada es null lo que hago es a馻dirla, sino no aumento
			// el contador
			if (tablero.get(c) == null) {
				this.tablero.put(c, e);
				i++;
			}

		}
	}

	public boolean isTerminado() {
		boolean terminado = false;
		boolean tieneDinero = false;
		for (Element e : this.tablero.values()) {
			if (e instanceof Jugador && ((Jugador) e).getDinero()==Constantes.DINERO) {
					tieneDinero = true;
				}
			}
		if (this.coordenadaJugadores.size() == 1 || tieneDinero) {
			terminado = true;
		}
		return terminado;
	}

	private void eliminarJugador(Coordenada coord) {
		this.coordenadaJugadores.remove(coord);
		this.tablero.remove(coord);
	}

	public String imprimeNombreJugadores() {
		StringBuilder resultado = new StringBuilder();
		int i = 1;
		for (Coordenada c : this.coordenadaJugadores) {
			Jugador j = (Jugador) tablero.get(c);
			resultado.append("El jugador " + i + " es un " + j.getNombre() + "\n");
			i++;
		}
		return resultado.toString();
	}

	public String imprimeValoresJugadores() {
		StringBuilder resultado = new StringBuilder();
		int i = 1;
		for (Coordenada c : this.coordenadaJugadores) {
			Jugador j = (Jugador) tablero.get(c);
			resultado.append("El personaje " + i + " tiene " + j.getDinero() + " dinero " + j.getGemas() + " gemas"+ j.getPociones() +" pociones"+ "\n");
			i++;
		}
		return resultado.toString();
	}

	private Coordenada getNextPosition(char direction) throws JuegoException, CloneNotSupportedException {
		Coordenada c = this.coordenadaJugadores.get(jugadorJuega).clone();
		if (direction != 'N' && direction != 'S' && direction != 'E' && direction != 'O') {
			throw new JuegoException("Error, no es una coordenada valida");
		} else {
			switch (direction) {
			case 'N': {
				c.goUp();
				break;
			}
			case 'S': {
				c.goDown();
				break;
			}
			case 'E': {
				c.goRight();
				break;
			}
			case 'O': {
				c.goLeft();
				break;
			}
			default:
				throw new IllegalArgumentException("Error");
			}
		}
		return c;
	}

	private void cambiaJugadorAPosicion(Coordenada coord) {
		Coordenada c = this.coordenadaJugadores.get(jugadorJuega);
		Jugador aux = (Jugador) this.tablero.get(c);
		this.tablero.remove(c);
		tablero.put(coord, aux);
		this.coordenadaJugadores.remove(jugadorJuega);
		this.coordenadaJugadores.add(jugadorJuega,coord);
	}

	public void proximoJugador() {
		if (this.jugadorJuega == Constantes.NUM_JUGADORES - 1) {
			this.jugadorJuega = 0;
		} else {
			jugadorJuega++;
		}
	}

	public String getGanador() {
		StringBuilder resultado = new StringBuilder();
		if (this.coordenadaJugadores.size() == 1) {
			Jugador aux = (Jugador) tablero.get(coordenadaJugadores.get(jugadorJuega));
			resultado.append(aux.toString());
		} else {
			for (Element siguiente : tablero.values()) {
				if (siguiente instanceof Jugador) {
					Jugador aux = ((Jugador) siguiente);
					if (aux.getDinero() == Constantes.NUM_DINERO) {
						resultado.append(aux);
					}
				}
			}
		}
		return resultado.toString();
	}

	public String getNombreJugadorQueJuega() {
		StringBuilder resultado = new StringBuilder();
		Coordenada aux = this.coordenadaJugadores.get(jugadorJuega);
		Jugador j = (Jugador) this.tablero.get(aux);
		resultado.append(j.getNombre());
		return resultado.toString();
	}

	public int getMovimientoJugador() {
		Coordenada aux = this.coordenadaJugadores.get(jugadorJuega);
		Jugador j = (Jugador) this.tablero.get(aux);
		return j.getFuerzaParaLuchar();
	}
	
	public int getValorDado() {
		return dado;
	}
	public int decrementaDado() {
		return this.dado--;
	}
	public void setDado() {
		Coordenada aux=this.coordenadaJugadores.get(jugadorJuega);
		Jugador auxiliar=(Jugador) this.tablero.get(aux);
		this.dado = auxiliar.getFuerzaParaLuchar();
	}
	public Element obtenerElementoTablero(Coordenada coord) {
		return this.tablero.get(coord);
	}
	public Coordenada obtenerCoordenadaJugadorJuega() {
		return this.coordenadaJugadores.get(jugadorJuega);
	}

	private void crearDinero() {
		int i = 0;
		while (i < Constantes.NUM_DINERO) {
			Coordenada c = new Coordenada();
			Element e = new Element(ElementType.DINERO);
			// Si el get de la coordenada es null lo que hago es a馻dirla, sino no aumento
			// el contador
			if (tablero.get(c) == null) {
				this.tablero.put(c, e);
				i++;
			}

		}

	}

	/**
	 * Escribe el tablero en formato no gr谩fico. Devuelve el string con la
	 * informaci贸n
	 */
	@Override
	public String toString() {
		StringBuilder resul = new StringBuilder();
		resul.append(barra());
		resul.append("     |");

		for (int fila = 0; fila < Constantes.TAMANNO; fila++) {
			for (int columna = 0; columna < Constantes.TAMANNO; columna++) {
				Coordenada coor = new Coordenada(columna, fila);

				if (this.tablero.get(coor) != null) {
					resul.append(" " + this.tablero.get(coor).getType().getSymbol() + " ");
				} else {
					resul.append("   ");
				}

				resul.append("|");
			}
			resul.append("\n");
			resul.append(barra());
			resul.append("     |");
		}
		resul.delete(resul.length() - 5, resul.length());
		return resul.toString();
	}

	/**
	 * Simplemente escribe una barra en pantalla
	 * 
	 * @return
	 */
	private String barra() {
		StringBuilder resul = new StringBuilder();
		resul.append("     ");
		for (int i = 0; i < Constantes.TAMANNO * 4; i++) {
			resul.append("-");
		}
		resul.append("\n");
		return resul.toString();
	}

	/**
	 * Mover el jugador
	 * 
	 * @param direction
	 * @return
	 * @throws JuegoException
	 * @throws JugadorException
	 * @throws CloneNotSupportedException 
	 */
	public String movePlayer(char direction) throws JuegoException, JugadorException, CloneNotSupportedException {
		// Si no es una direcci贸n v谩lida, mando un exception
		String resul = "";
		Jugador jugador = (Jugador) this.tablero.get(this.coordenadaJugadores.get(jugadorJuega));

		Coordenada coordDestino = getNextPosition(direction);

		// Tengo que ver que hay en la nueva casilla
		Element elemento = this.tablero.get(coordDestino);

		if (elemento != null) { // Hay algo en la casilla
			if (elemento instanceof Jugador) {

				Jugador enemigo = (Jugador) elemento;
				int resultadoLucha = jugador.lucha(enemigo);
				switch (resultadoLucha) {
				case Constantes.EMPATE:
					resul = "Empate entre los jugadore";
					break;
				case Constantes.GANA_USA_POCIMA:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita una p贸cima al enemigo";
					break;
				case Constantes.GANA_DINERO:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita el dinero al enemigo";
					break;
				case Constantes.GANA_MUERE:
					resul = "El jugador " + jugador.getNombre() + " gana. El enemigo muere";
					this.eliminarJugador(coordDestino);
					// Si se elimina el jugador que juega el dado se pone a 0 para que no siga
					// tirando
					break;
				case Constantes.PIERDE_USA_POCIMA:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita una p贸cima al jugador";
					break;
				case Constantes.PIERDE_DINERO:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita el dinero al jugador";
					break;
				case Constantes.PIERDE_MUERE:
					resul = "El enemigo " + enemigo.getNombre() + " gana. El jugador muere";
					this.eliminarJugador(this.coordenadaJugadores.get(jugadorJuega));
					dado = 0;
					// Decrementamos en uno el jugador, para que no se salte al siguiente
					// ya que al borrarlo el siguiente apunta al siguiente, y al incrementarlo
					// se le salta
					this.jugadorJuega--;
					break;
				}
				// Despu茅s de la lucha los jugadores no se mueven
			} else if (elemento.getType() == ElementType.ROCA) {
				int resultadoRoca = jugador.encuentraRoca();
				switch (resultadoRoca) {
				case Constantes.ROMPE_ROCA_CON_GEMA:
					resul = "El jugador " + jugador.getNombre() + " rompe la roca con una gema";
					this.cambiaJugadorAPosicion(coordDestino);
					break;

				case Constantes.GANA_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " gana a la roca";
					this.cambiaJugadorAPosicion(coordDestino);
					break;

				case Constantes.PIERDE_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " pierde. No se mueve";
					break;
				}
			} else if (elemento.getType() == ElementType.GEMA) {
				jugador.encuentraGema();
				this.cambiaJugadorAPosicion(coordDestino);

			} else if (elemento.getType() == ElementType.DINERO) {
				jugador.encuentraDinero();
				this.cambiaJugadorAPosicion(coordDestino);

			} else if (elemento.getType() == ElementType.POCION) {
				jugador.encuentraPocion();
				this.cambiaJugadorAPosicion(coordDestino);

			}

		} else {
			this.cambiaJugadorAPosicion(coordDestino);
		}

		return resul;
	}

}
