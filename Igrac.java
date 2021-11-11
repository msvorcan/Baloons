package igra;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends KruznaFigura {

	public Igrac(Vektor centar, int precnik, Scena scena) {
		super(centar, Color.GREEN, precnik, new Vektor(0, 0), scena);
	}

	@Override
	public void pomeri(double dt) {
	}

	public void pomeriIgraca(double pomeraj) {
		double x = centar.getX() + pomeraj;
		if (x < 0)
			x = 0;
		if (x > scena.getWidth() - precnik)
			x = scena.getWidth() - precnik;
		centar = new Vektor(x, centar.getY());
	}

	public void iscrtaj() {
		Graphics g = scena.getGraphics();
		g.setColor(boja);
		g.fillOval((int)(centar.getX()) - precnik/2, (int)(centar.getY()) - precnik/2, precnik, precnik);
		g.setColor(Color.BLUE);
		g.fillOval((int) centar.getX() - precnik / 4, (int) centar.getY() - precnik / 4, precnik / 2, precnik / 2);
	}

	@Override
	public void sudarilaSe(KruznaFigura kFigura) {
		if(kFigura instanceof Balon)
		scena.zaustavi();
	}

}
