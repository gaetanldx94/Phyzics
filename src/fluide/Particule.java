import java.util.Random;

public class Particule {
	double x, y;
	double vx, vy;
	int width, height, hitbox;

	public Particule(double x, double y, int width, int height, int hitbox) {
		this.width = width;
		this.height = height;
		this.hitbox = hitbox;
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

	public void appliquerPression(double force) {
		vx += force * (Math.random() - 0.5); // Appliquer une petite force aléatoire
		vy += force * (Math.random() - 0.5); // sur la vitesse pour favoriser la dispersion.
	}

	public void mettreAJour() {
		x += vx;
		y += vy;
	}
}