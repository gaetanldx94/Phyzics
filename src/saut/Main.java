import javax.swing.*;

public class Main extends JFrame {

	public Main() {
		setTitle("Jeu de Balle");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Balle balle = new Balle();
		add(balle);

		addKeyListener(balle);
		setFocusable(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}
}
