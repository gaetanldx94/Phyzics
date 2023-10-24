import javax.swing.*;
import java.awt.*;

public class PendulumGUI extends JPanel {
	private double angle1 = Math.PI / 2 + Math.random() * 0.1; // Angle initial pour le pendule 1 (commence en haut)
	private double angle2 = Math.PI / 2 + Math.random() * 0.1; // Angle initial pour le pendule 2 (commence en haut)
	private double velocity1 = 1 + Math.random() * 6;          // Vitesse initiale pour le pendule 1 (entre 1 et 16)
	private double velocity2 = 1 + Math.random() * 15;         // Vitesse initiale pour le pendule 2 (entre 1 et 16)
	private double length1 = 100;                              // Longueur du premier pendule
	private double length2 = 100;                              // Longueur du deuxième pendule
	private double gravity = 9.81;                             // Gravité
	private double damping = 0.005;                            // Facteur d'amortissement

	public void step() {
		double dt = 0.016;

		double accel1 = -gravity
				* (2 * Math.sin(angle1) + Math.sin(2 * angle1 - 2 * angle2) + 2 * Math.sin(angle1 - angle2))
				/ (3 - Math.cos(2 * angle1 - 2 * angle2));
		double accel2 = gravity * (4 * Math.sin(angle1 - angle2) + Math.sin(2 * angle1 - 2 * angle2))
				/ (3 - Math.cos(2 * angle1 - 2 * angle2));

		velocity1 += accel1 * dt;
		velocity2 += accel2 * dt;

		angle1 += velocity1 * dt;
		angle2 += velocity2 * dt;

		velocity1 *= (1 - damping);
		velocity2 *= (1 - damping);

		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int centerX = getWidth() / 2;
		int centerY = getHeight() / 2;

		int x1 = (int) (centerX + length1 * Math.sin(angle1));
		int y1 = (int) (centerY + length1 * Math.cos(angle1));

		int x2 = (int) (x1 + length2 * Math.sin(angle2));
		int y2 = (int) (y1 + length2 * Math.cos(angle2));

		g.setColor(Color.BLACK);
		g.drawLine(centerX, centerY, x1, y1);
		g.fillOval(x1 - 5, y1 - 5, 10, 10);

		g.setColor(Color.RED);
		g.drawLine(x1, y1, x2, y2);
		g.fillOval(x2 - 5, y2 - 5, 10, 10);
	}
}
