package igra;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Scena extends Canvas implements Runnable {

	private Igra igra;
	private Igrac igrac;
	private Thread nit;

	public enum Smer {LEVO, DESNO};

	private List<KruznaFigura> figure = new ArrayList<KruznaFigura>();

	public Scena(Igra igra) {
		this.igra = igra;
	}

	public void izbaci(KruznaFigura kruznaFigura) {
		figure.remove(kruznaFigura);
	}

	public void dodaj(KruznaFigura kFigura) {
		figure.add(kFigura);
	}
	
// PONASANJE TOKOM IGRE...............................................................

	public synchronized void kreni() {
		nit = new Thread(this);
		nit.start();
	}

	public void zaustavi() {
		if (nit != null)
			nit.interrupt();
	}

	@Override
	public synchronized void run() {
		try {
			while (!Thread.interrupted()) {
				Thread.sleep(60);
				if (igrac == null) {
					double x = getWidth() * 0.5;
					double y = getHeight() - 30;
					igrac = new Igrac(new Vektor(x, y), 30, this);
					figure.add(igrac);
				}
				generisiBalon();
				azuriraj();
			}
		} catch (InterruptedException e) {
		}

	}

	private void generisiBalon() {
		double rand = Math.random();
		if (rand < 0.1) {
			double randX = Math.random() * getWidth();
			figure.add(new Balon(new Vektor(randX, 0), Color.RED, 20, new Vektor(0, 0.1), this));
		}

	}

	private synchronized void azuriraj() {
		
		for(int i = 0; i < figure.size(); i++)
			figure.get(i).pomeri(60);
		
		repaint();

		synchronized (figure) {
			for (int i = 0; i < figure.size() - 1; i++)
				for (int j = i + 1; j < figure.size(); j++) {
					if (Krug.preklapanje(figure.get(i), figure.get(j))) {
						figure.get(i).sudarilaSe(figure.get(j));
						figure.get(j).sudarilaSe(figure.get(i));
					}
				}
		}
	}

	public void pomeriIgraca(Smer smer) {
		switch (smer) {
		case LEVO:
			igrac.pomeriIgraca(-30);
			break;

		case DESNO:
			igrac.pomeriIgraca(30);
			break;
		}
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		for (int i = 0; i < figure.size() - 1; i++) {
			if (figure.get(i) != null)
				figure.get(i).iscrtaj();
		}
		for (KruznaFigura kruznaFigura : figure) {
			kruznaFigura.iscrtaj();
		}
	}

}
