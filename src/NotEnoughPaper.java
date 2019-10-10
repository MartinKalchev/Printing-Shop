// this is a custom exception handler which checks if the paper in the printing machines is enough to print the given items.
public class NotEnoughPaper extends Exception{

	private int maxNumberPaper;

	public NotEnoughPaper(int maxNumberPaper) {
		this.maxNumberPaper = maxNumberPaper;
	}

	public int getMaxNumberPaper() {
		return maxNumberPaper;
	}

	@Override
	public String toString() {
		return "NotEnoughPaper{The maximum number of paper in the machine can be " + maxNumberPaper + '}';
	}

	
	
}
