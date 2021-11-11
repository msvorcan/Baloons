package igra;

import java.awt.Color;

public abstract class KruznaFigura extends Krug {

	private Vektor brzina;
	protected Scena scena;

	public KruznaFigura(Vektor centar, Color boja, int precnik, Vektor brzina, Scena scena) {
		super(centar, boja, precnik);
		this.brzina = brzina;
		this.scena = scena;
	}

	public void pomeri(double dt) {
		Vektor pomeraj = new Vektor(brzina.getX() * dt, brzina.getY() * dt);
		centar = Vektor.zbirVektora(centar, pomeraj);

		if (centar.getX() < 0 || centar.getY() < 0 || centar.getX() > scena.getWidth()
				|| centar.getY() > scena.getHeight())
			scena.izbaci(this);
	}
	
	public void iscrtaj() {
		super.iscrtaj(scena);
	}

	public abstract void sudarilaSe(KruznaFigura kFigura);

}
