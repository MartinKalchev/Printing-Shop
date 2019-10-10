import java.util.List;
import java.util.ArrayList;

public class Publisher {

	List<Employee> employees;
	List<Publishing> publishings;
	private int num_publishings;
	List<PrintingMachine> machines;
	
	public Publisher(){
		employees = new ArrayList();
		publishings = new ArrayList();
		machines = new ArrayList();
	}

	
	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
	public int getNum_publishings() {
		return num_publishings;
	}


	public void setNum_publishings(int num_publishings) {
		this.num_publishings = num_publishings;
	}


	public List<PrintingMachine> getMachines() {
		return machines;
	}


	public void setMachines(List<PrintingMachine> machines) {
		this.machines = machines;
	}


	public List<Publishing> getPublishings() {
		return publishings;
	}


	public void setPublishings(List<Publishing> publishings) {
		this.publishings = publishings;
	}


	public void addEmployee(Employee e) {
		employees.add(e);
	}
	
	public void addPublishing(Publishing p) {
		publishings.add(p);
		num_publishings++;
	}
	
	public void addMachines(PrintingMachine machine) {
		machines.add(machine);
	}
	
	// function that adds a bonus to the base salaries of the employees if the revenue of the shop satisfies a given target
	public void bonus_sal(double bonus) {
		double extended_sal = 0;
		double revenue_for_bonus = 200;
		// checks if the target revenue is reached
		if(this.revenue() > revenue_for_bonus) {
			Employee.MANAGER.base_sal = Employee.MANAGER.getBase_sal() * (1+bonus);
		}else {
			Employee.MANAGER.base_sal  += Employee.MANAGER.getBase_sal();
		}
		
	}
	
	// function that calculates the total salary expediture for the shop
	public double totalSalCost() {
		double total = 0;
		for(Employee e: employees) {
			total += e.getBase_sal();
		}
		
		return total;
	}
	
	// function that calculates the total price (expenditure) for all the printed items for the shop
	public double TotalPaperPrice() {
		double total = 0;
		for(Publishing p : publishings) {
			total += p.PaperPrice();
		}
			return total;	
	}
	
	// function to calculate the selling price of the item which is printed
	public double TotalPaperSellPrice() {
		double total = 0;
		double per = .60;
		for(Publishing p : publishings) {
			total += p.PaperPrice() * (1 + per);
		}
			return total;	
	}
	
	
	// function that computes the total costs of the printing shop
	public double totalCosts() {
		double total = 0;
		total += (this.totalSalCost() + this.TotalPaperPrice());
		return total;
	}
	
	
	// function the computes the total revenue of the shop
	public double revenue() {
		double total = 0;
				if(num_publishings > 4){
				total += this.TotalPaperSellPrice() / (1 + .20);
			}else{
				total += this.TotalPaperSellPrice();
		}
	
			return total;
	
	}
	
    	// the main thread function which makes the two printing machines print the items simultaneously
	 public void publish() {
			for(PrintingMachine m : machines) {
				Runnable runnable = new Runnable() {
					public void run() {
						m.printPublishings();
					}
				};
				
				Thread thread = new Thread(runnable);
				System.out.println("Starting Thread..." + m.getSerialNum());
				thread.start();
			}
	  }
	

}
