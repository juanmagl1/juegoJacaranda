package elementos;

import java.util.Objects;
import java.util.Random;

import logicaJuego.Constantes;

public class Coordenada {
private int x;
private int y;
public Coordenada() {
	super();
	Random r =new Random();
	this.x=(r.nextInt(Constantes.TAMANNO));
	this.y=(r.nextInt(Constantes.TAMANNO));
}
public Coordenada(int x, int y) {
	super();
	if (x>=0 && x<=Constantes.TAMANNO-1 && y>=0 && y<=Constantes.TAMANNO-1 ) {
		this.x = x;
		this.y = y;
		}else {
		this.x=0;
		this.y=0;
	}

}
public int getX() {
	return x;
}
public int getY() {
	return y;
}
@Override
public int hashCode() {
	return Objects.hash(x, y);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Coordenada other = (Coordenada) obj;
	return x == other.x && y == other.y;
}
@Override
public String toString() {
	return "Coordenada [x=" + x + ", y=" + y + "]";
}
public boolean goRight () {
	boolean movido=true;
	if (x==Constantes.TAMANNO-1) {
		movido=false;
	}else {
		x++;
	}
	return movido;
}
public boolean goLeft() {
	boolean movido=true;
	if (x==0) {
		movido=false;
	}else {
		x--;
	}
	return movido;
}
public boolean goUp() {
	boolean movido=true;
	if (y==0) {
		movido=false;
	}else {
		y--;
	}
	return movido;
}
public boolean goDown() {
	boolean movido=true;
	if (y==Constantes.TAMANNO-1) {
		movido=false;
	}else {
		y++;
	}
	return movido;
}
@Override
public Coordenada clone() throws CloneNotSupportedException {
	return new Coordenada(this.x, this.y);
}

}
