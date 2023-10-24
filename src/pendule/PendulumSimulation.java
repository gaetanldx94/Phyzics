public class PendulumSimulation {
	private double angle1;
	private double angle2;
	private double velocity1;
	private double velocity2;
	private double length1;
	private double length2;
	private double gravity;

	public PendulumSimulation(double angle1, double angle2, double velocity1, double velocity2, double length1,
			double length2, double gravity) {
		this.angle1 = angle1;
		this.angle2 = angle2;
		this.velocity1 = velocity1;
		this.velocity2 = velocity2;
		this.length1 = length1;
		this.length2 = length2;
		this.gravity = gravity;
	}

	public void step(double timeStep) {
		double gOverL1 = gravity / length1;
		double gOverL2 = gravity / length2;

		double numer1 = -gOverL1 * Math.sin(angle1);
		double numer2 = -gOverL2 * Math.sin(angle2);
		double denom1 = -2.0 * length1 + length2 * Math.cos(2.0 * angle1 - 2.0 * angle2);
		double denom2 = -2.0 * length2 + length2 * Math.cos(2.0 * angle1 - 2.0 * angle2);

		double accel1 = (numer1 - numer2 * Math.cos(2.0 * angle1 - 2.0 * angle2)) / denom1;
		double accel2 = (2.0 * numer2 - numer1 * Math.cos(2.0 * angle1 - 2.0 * angle2)) / denom2;

		velocity1 += accel1 * timeStep;
		velocity2 += accel2 * timeStep;

		angle1 += velocity1 * timeStep;
		angle2 += velocity2 * timeStep;
	}

	public double getAngle1() {
		return angle1;
	}

	public double getAngle2() {
		return angle2;
	}

	public void setAngle1(double angle1) {
		this.angle1 = angle1;
	}

	public void setAngle2(double angle2) {
		this.angle2 = angle2;
	}
}
