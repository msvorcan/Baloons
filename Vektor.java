package igra;

public class Vektor implements Cloneable {

	private double x, y;

	public Vektor(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	@Override
	public Vektor clone() throws CloneNotSupportedException {
		Vektor copy = (Vektor) super.clone();
		copy.x = x;
		copy.y = y;
		return copy;
	}

	public Vektor proizvodSkalarom(double skalar) {
		return new Vektor(x * skalar, y * skalar);
	}

	public static Vektor zbirVektora(Vektor v1, Vektor v2) {
		return new Vektor(v1.x + v2.x, v1.y + v2.y);
	}

	public static double rastojanje(Vektor v1, Vektor v2) {
		return Math.sqrt(Math.pow((v1.x - v2.x), 2) + Math.pow((v1.y - v2.y), 2));
	}

}
