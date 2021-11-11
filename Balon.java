package igra;

import java.awt.Color;

public class Balon extends KruznaFigura {

	public Balon(Vektor centar, Color boja, int precnik, Vektor brzina, Scena scena) {
		super(centar, boja, precnik, brzina, scena);
	}

	@Override
	public void sudarilaSe(KruznaFigura kFigura) {
	}

}
