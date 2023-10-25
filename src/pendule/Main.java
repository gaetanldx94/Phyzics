import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	public static void main(String[] args) {
		PendulumGUI gui = new PendulumGUI();

		JFrame frame = new JFrame("Pendule Double");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(gui);
		frame.setSize(500, 500);
		frame.setVisible(true);

		javax.swing.Timer timer = new javax.swing.Timer(8, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.step();
			}
		});
		timer.start();
	}
}
