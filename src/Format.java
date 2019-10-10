// this is a enum class for the paper format of the items printed in the shop listing the different prices for each format
public enum Format {

	A1(0.05),A2(0.10),A3(0.15),A4(0.25),A5(0.30);
	private double price;
	
	Format(double price){
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
