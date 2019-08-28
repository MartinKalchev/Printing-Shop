
public enum Type {

	NORMAL(0.05),GLANCED(0.25),NEWSPAPER(0.15);
	private double p;

	private Type(double p) {
		this.p = p;
	}

	public double getP() {
		return p;
	}

	public void setP(double p) {
		this.p = p;
	}
	
	
}
