
public class Publishing {

	private String title;
	private int n_pages;
	private Format f;
	private Type t;
	
	public Publishing(String title, int n_pages, Format f, Type t) {
		this.title = title;
		this.n_pages = n_pages;
		this.f = f;
		this.t = t;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getN_pages() {
		return n_pages;
	}

	public void setN_pages(int n_pages) {
		this.n_pages = n_pages;
	}

	public Format getF() {
		return f;
	}

	public void setF(Format f) {
		this.f = f;
	}

	public Type getT() {
		return t;
	}

	public void setT(Type t) {
		this.t = t;
	}
	
	public double PaperPrice() {
		double price = 0;
		for(int i = 0;i<n_pages;i++) {
			price += f.getPrice() + t.getP();
		}
		return price;	
	}
	
	
}