package igra;

import java.awt.Color;
import java.awt.Graphics;

public class Krug {

	protected Vektor centar;
	protected Color boja;
	protected int precnik;

	public Krug(Vektor centar, Color boja, int precnik) {
		super();
		this.centar = centar;
		this.boja = boja;
		this.precnik = precnik;
	}

	public static boolean preklapanje(Krug k1, Krug k2) {
		if (Vektor.rastojanje(k1.centar, k2.centar) >= (k1.precnik/2 + k2.precnik/2))
			return false;
		else
			return true;
	}

	public void iscrtaj(Scena scena) {
		Graphics g = scena.getGraphics();
		g.setColor(boja);
		g.fillOval((int)(centar.getX()) - precnik/2, (int)(centar.getY()) - precnik/2, precnik, precnik);
	}

}
