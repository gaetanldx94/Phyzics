import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Balle extends JPanel implements ActionListener {
	private double x = 100; // Position initiale x
	private double y = 150; // Position initiale y
	private double xVel = 2; // Vitesse initiale x
	private double yVel = -2; // Vitesse initiale y (vers le haut)
	private double gravity = 0.1; // Gravité
	private double bounceLoss = 0.85; // Perte d'énergie lors des rebonds
	private double mass = 2.0; // Masse de la balle

	Timer timer = new Timer(5, this);

	public Balle() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillOval((int) x, (int) y, 30, 30);
	}

	public void actionPerformed(ActionEvent e) {
		double netForce = gravity * mass; // Calculer la force due à la gravité

		// Calculer l'accélération
		double acceleration = netForce / mass;

		// Appliquer l'accélération à la vitesse verticale
		yVel += acceleration;

		// Vérifier les rebonds contre les bords
		if (x >= 560 || x <= 0) {
			xVel = -xVel * bounceLoss; // Rebond avec perte d'énergie
		}
		if (y >= 360 || y <= 0) {
			yVel = -yVel * bounceLoss; // Rebond avec perte d'énergie
		}

		// Mettre à jour la position
		x += xVel;
		y += yVel;

		repaint();
	}
}