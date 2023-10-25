import java.util.Random;

public class Particule {
	double x, y;
	double vx, vy;

	public Particule(double x, double y) {
		this.x = x;
		this.y = y;
		Random random = new Random();
		this.vx = random.nextDouble() * 2 - 1;
		this.vy = random.nextDouble() * 2 + 1;
	}

	public void appliquerForce(double fx, double fy) {
		vx += fx;
		vy += fy;
	}

	public void mettreAJour() {
		x += vx;
		y += vy;
	}
}