import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class Balle extends JPanel implements ActionListener {
	private double x = 100;
	private double y = 150;
	private double xVel = 0; // Initialise la vitesse à zéro
	private double yVel = 0; // Initialise la vitesse à zéro
	private double gravity = 0.2;
	private double bounceLoss = 0.8;
	private double mass = 0.1;
	private double friction = 0.98;
	private double stopThreshold = 0.1;

	Timer timer = new Timer(8, this);

	public Balle() {
		timer.start();
		lancerBalle();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillOval((int) x, (int) y, 30, 30);
	}

	public void actionPerformed(ActionEvent e) {
		yVel += gravity;

		x += xVel;
		y += yVel;

		if (x >= 560 || x <= 0) {
			xVel = -xVel * bounceLoss;
		}

		if (y >= 360) {
			y = 360;
			yVel = -yVel * bounceLoss;
			xVel *= friction;
		}

		// Vérifier si la balle doit s'arrêter
		if (Math.abs(xVel) < stopThreshold && Math.abs(yVel) < stopThreshold) {
			xVel = 0;
			yVel = 0;
			timer.stop();
		}

		repaint();
	}

	public void lancerBalle() {
		Random rand = new Random();
		double angle = Math.toRadians(rand.nextDouble() * 360); // Direction aléatoire
		double force = rand.nextDouble() * 10; // Force aléatoire
		xVel = force * Math.cos(angle);
		yVel = force * Math.sin(angle);
	}
}