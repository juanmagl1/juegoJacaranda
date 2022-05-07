package elementos;

import java.util.Random;

public class Jugador extends Element {
	private int dinero;
	private int pociones;
	private int gemas;
	private PlayerType jugadores;

	public Jugador(PlayerType jugadores) {
		super(ElementType.valueOf(jugadores.name()));
		this.jugadores = jugadores;
		this.dinero = 0;
		this.gemas = 0;
		this.pociones = 0;
	}
	Random r=new Random();
	
	public String getNombre() {
		return jugadores.name();
	}

	private int getFuerza() {
		return jugadores.getFuerza();
	}

	public int getFuerzaParaLuchar() {
		return  r.nextInt(getFuerza());
	}
	private int getMagia() {
		return jugadores.getMagia();
	}
	public int getMagiaParaLuchar() {
		return r.nextInt(getMagia());
	}
	private int getVelocidad() {
		return jugadores.getVelocidad();
	}
	public int getVelocidadParaLuchar() {
		return r.nextInt(getVelocidad());
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) throws JugadorException {
		if (dinero<0) {
			throw new JugadorException("Error, el dinero no puede ser menor de 0");
		}else {
			this.dinero = dinero;
		}	
	}
	public int getPociones() {
		return pociones;
	}

	public void setPociones(int pociones) throws JugadorException {
		if (pociones<0) {
			throw new JugadorException("Las pociones no pueden ser negativas");
		}else {
			this.pociones = pociones;
		}
	}

	public int getGemas() {
		return gemas;
	}

	public void setGemas(int gemas) throws JugadorException {
		if (gemas<0) {
			throw new JugadorException("Las gemas no puedeb ser negativas");
		}else {
			this.gemas = gemas;
		}
		
	}
	
}
