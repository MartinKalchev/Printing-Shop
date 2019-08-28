import java.util.List;
import java.util.ArrayList;

public class PrintingMachine{

	private int maxNumberPaper;
	private String serialNum;
	private int currentNumPaper;
	private boolean colored_paper;
	private boolean normal_paper;
	List<Publishing> publishings;
	
	
	public PrintingMachine(int maxNumberPaper,String serialNum) {
		this.maxNumberPaper = maxNumberPaper;
		this.serialNum = serialNum;
		this.currentNumPaper = 0;
		colored_paper = false;
		normal_paper = false;
		publishings = new ArrayList();
	}

	public int getMaxNumberPaper() {
		return maxNumberPaper;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public void setMaxNumberPaper(int maxNumberPaper) {
		this.maxNumberPaper = maxNumberPaper;
	}

	public boolean isColored_paper() {
		return colored_paper;
	}

	public void setColored_paper(boolean colored_paper) {
		this.colored_paper = colored_paper;
	}

	public boolean isNormal_paper() {
		return normal_paper;
	}

	public void setNormal_paper(boolean normal_paper) {
		this.normal_paper = normal_paper;
	}
	
	public int getCurrentNumPaper() {
		return currentNumPaper;
	}
	
	public void addPublishings(Publishing p) {
		publishings.add(p);
	}

	public void setCurrentNumPaper(int currentNumPaper) throws NotEnoughPaper{
		if(this.currentNumPaper > this.getMaxNumberPaper()) {
			throw new NotEnoughPaper(this.getMaxNumberPaper());
		}else {
			this.currentNumPaper = currentNumPaper;
		}
	}
		
	
	public synchronized void print()throws NotEnoughPaper{
		for(Publishing p : publishings) {
			if(this.getCurrentNumPaper() > p.getN_pages()) {
				System.out.println(this.getSerialNum() + " is printing " + p.getTitle());
				this.currentNumPaper = this.currentNumPaper -  p.getN_pages();
			 }else if(this.getCurrentNumPaper() < p.getN_pages()){
				throw new NotEnoughPaper(this.maxNumberPaper);
			 }
		}
	}
	
	 public void printPublishings(){
		 for(Publishing p : publishings){
			 try {
				 this.print();
			 }catch(NotEnoughPaper ex) {
				 System.out.println(ex);
			 }		 
		 }
	  }
	

}
