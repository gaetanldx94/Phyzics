import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Balle Rebondissante");
		Balle balle = new Balle();
		frame.add(balle);
		frame.setSize(600, 430);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}