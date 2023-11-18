import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class SimulationFluide extends JPanel {
	List<Particule> particules;
	double gravite = 0.1;
	double rebondissement = 0.3;
	int nombreDeParticules = 2000;
	double viscosite = 0.02; // Ajustez selon votre besoin
	double cohesion = 0.05; // Ajustez selon votre besoin
	double pression = 0.05; // Ajustez selon votre besoin

	public SimulationFluide() {
		particules = new ArrayList<>();
		for (int i = 0; i < nombreDeParticules; i++) {
			particules.add(new Particule(Math.random() * 300, Math.random() * 200, 10, 10, 8));
		}

		Timer timer = new Timer(8, e -> {
			update();
			collision();
			cohesion();
			repaint();
		});
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Particule particule : particules) {
			g.setColor(new Color(0, 0, 255, 100));
			g.fillOval((int) particule.x, (int) particule.y, particule.width, particule.height);
		}
	}

	public void update() {
		for (Particule particule : particules) {
			particule.appliquerForce(0, gravite);
			particule.appliquerForce(viscosite * -particule.vx, viscosite * -particule.vy);
			particule.appliquerPression(pression); // Ajout de la force de pression
			particule.mettreAJour();

			if (particule.x < 0 || particule.x > 300) {
				particule.vx = -particule.vx * rebondissement;
			}
			if (particule.y > 200) {
				particule.y = 200;
				particule.vy = -particule.vy * rebondissement;
			}
		}
	}

	public void collision() {
		for (int i = 0; i < particules.size(); i++) {
			for (int j = i + 1; j < particules.size(); j++) {
				Particule particuleA = particules.get(i);
				Particule particuleB = particules.get(j);

				double dx = particuleB.x - particuleA.x;
				double dy = particuleB.y - particuleA.y;
				double distance = Math.sqrt(dx * dx + dy * dy);

				double overlap = (particuleA.hitbox + particuleB.hitbox) - distance;

				if (overlap > 0) {
					double angle = Math.atan2(dy, dx);

					double moveX = Math.cos(angle) * overlap / 2;
					double moveY = Math.sin(angle) * overlap / 2;

					particuleA.x -= moveX;
					particuleA.y -= moveY;
					particuleB.x += moveX;
					particuleB.y += moveY;

					double force = 0.01;

					particuleA.vx += force * (dx / distance);
					particuleA.vy += force * (dy / distance);

					particuleB.vx -= force * (dx / distance);
					particuleB.vy -= force * (dy / distance);
				}
			}
		}
	}

	public void cohesion() {
		for (int i = 0; i < particules.size(); i++) {
			for (int j = i + 1; j < particules.size(); j++) {
				Particule particuleA = particules.get(i);
				Particule particuleB = particules.get(j);

				double dx = particuleB.x - particuleA.x;
				double dy = particuleB.y - particuleA.y;
				double distance = Math.sqrt(dx * dx + dy * dy);

				double force = cohesion / distance;

				particuleA.vx += force * (dx / distance);
				particuleA.vy += force * (dy / distance);

				particuleB.vx -= force * (dx / distance);
				particuleB.vy -= force * (dy / distance);
			}
		}
	}
}