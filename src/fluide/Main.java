import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		SimulationFluide simu = new SimulationFluide();
		frame.add(simu);
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
