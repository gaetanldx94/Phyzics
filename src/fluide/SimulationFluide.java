import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimulationFluide extends JPanel {
	List<Particule> particules;
	double gravite = 0.1;
	double rebondissement = 0.6;
	int nombreDeParticules = 3000;
	double ecoulement = 0.01;

	public SimulationFluide() {
		particules = new ArrayList<>();
		for (int i = 0; i < nombreDeParticules; i++) {
			particules.add(new Particule(Math.random() * 600, Math.random() * 400));
		}

		Timer timer = new Timer(16, e -> {
			update();
			repaint();
		});
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Particule particule : particules) {
			g.setColor(new Color(0, 0, 255, 100));
			g.fillOval((int) particule.x, (int) particule.y, 2, 2);
		}
	}

	public void update() {
		for (Particule particule : particules) {
			particule.appliquerForce(0, gravite);

			particule.appliquerForce(ecoulement, 0);

			particule.mettreAJour();

			if (particule.x < 0 || particule.x > 600) {
				particule.vx = -particule.vx * rebondissement;
			}
			if (particule.y > 400) {
				particule.y = 400;
				particule.vy = -particule.vy * rebondissement;
			}
		}

		for (int i = 0; i < particules.size(); i++) {
			Particule p1 = particules.get(i);
			for (int j = i + 1; j < particules.size(); j++) {
				Particule p2 = particules.get(j);
				double distance = Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
				if (distance < 2) {
					double tempVx = p1.vx;
					double tempVy = p1.vy;
					p1.vx = p2.vx;
					p1.vy = p2.vy;
					p2.vx = tempVx;
					p2.vy = tempVy;
				}
			}
		}
	}
}
