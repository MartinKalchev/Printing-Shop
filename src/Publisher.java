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
	
	
	public void bonus_sal(double bonus) {
		double extended_sal = 0;
		double revenue_for_bonus = 200;
		if(this.revenue() > revenue_for_bonus) {
			Employee.MANAGER.base_sal = Employee.MANAGER.getBase_sal() * (1+bonus);
		}else {
			Employee.MANAGER.base_sal  += Employee.MANAGER.getBase_sal();
		}
		
	}
	
	public double totalSalCost() {
		double total = 0;
		for(Employee e: employees) {
			total += e.getBase_sal();
		}
		
		return total;
	}
	
	public double TotalPaperPrice() {
		double total = 0;
		for(Publishing p : publishings) {
			total += p.PaperPrice();
		}
			return total;	
	}
	
	public double TotalPaperSellPrice() {
		double total = 0;
		double per = .60;
		for(Publishing p : publishings) {
			total += p.PaperPrice() * (1 + per);
		}
			return total;	
	}
	
	
	
	public double totalCosts() {
		double total = 0;
		total += (this.totalSalCost() + this.TotalPaperPrice());
		return total;
	}
	
	
	
	public double revenue() {
		double total = 0;
				if(num_publishings > 4){
				total += this.TotalPaperSellPrice() / (1 + .20);
			}else{
				total += this.TotalPaperSellPrice();
		}
	
			return total;
	
	}
	
    	
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
