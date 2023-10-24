public class SimulationFluide {
	private double densite;     // Densité du fluide en kg/m^3
	private double viscosite;   // Viscosité du fluide en Pa*s

	public SimulationFluide(double densite, double viscosite) {
		this.densite = densite;
		this.viscosite = viscosite;
	}

	public double vitesseTerminale(double rayon, double masse) {
		double g = 9.81;
		return Math.sqrt((2 * (masse * g)) / (this.densite * Math.PI * Math.pow(rayon, 2)));
	}

	public double nombreReynolds(double vitesse, double longueurCaracteristique) {
		return (this.densite * vitesse * longueurCaracteristique) / this.viscosite;
	}

	public double pressionDynamique(double vitesse) {
		return 0.5 * this.densite * Math.pow(vitesse, 2);
	}

	public double forceFrottement(double vitesse, double aire, double coefficientFrottement) {
		return 0.5 * this.densite * Math.pow(vitesse, 2) * aire * coefficientFrottement;
	}

	public double vitesseEcoulement(double debit, double rayon) {
		return debit / (Math.PI * Math.pow(rayon, 2));
	}
}