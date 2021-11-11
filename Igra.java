package igra;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import igra.Scena.Smer;

@SuppressWarnings("serial")
public class Igra extends Frame {

	private Scena scena;

	public Igra() {
		super("Igra");
		setSize(500, 500);
		this.scena = new Scena(this);
		add(scena, BorderLayout.CENTER);
		scena.kreni();
		setVisible(true);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent arg0) {
				scena.zaustavi();
				dispose();
			}

		});
		
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT: scena.pomeriIgraca(Smer.LEVO); break;
				case KeyEvent.VK_RIGHT: scena.pomeriIgraca(Smer.DESNO); break;
				}
			}	
		});
	}
	
	public static void main(String[] args) {
		new Igra();
	}

}
