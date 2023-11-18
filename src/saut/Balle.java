import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Balle extends JPanel implements ActionListener, KeyListener {

	private Timer timer;
	private int xPos, yPos, xVel, yVel;
	private boolean isJumping;

	public Balle() {
		xPos = 50;
		yPos = 200;
		xVel = 0;
		yVel = 0;
		isJumping = false;

		timer = new Timer(15, this);
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		if (isJumping) {
			yVel += 1;
		}

		xPos += xVel;
		yPos += yVel;

		if (yPos > 200) {
			yPos = 200;
			isJumping = false;
		}

		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillOval(xPos, yPos, 20, 20);
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_SPACE && !isJumping) {
			yVel = -15;
			isJumping = true;
		} else if (key == KeyEvent.VK_LEFT) {
			xVel = -5;
		} else if (key == KeyEvent.VK_RIGHT) {
			xVel = 5;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
			xVel = 0;
		}
	}

	public void keyTyped(KeyEvent e) {
	}
}