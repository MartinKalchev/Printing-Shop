// this is a enum class for the two types of employees working in the printing shop and their base salaries.
public enum Employee {

	OPERATOR(1000),MANAGER(1000);
	double base_sal;

	private Employee(double base_sal) {
		this.base_sal = base_sal;
	}

	public double getBase_sal() {
		return base_sal;
	}

	public void setBase_sal(int base_sal) {
		this.base_sal = base_sal;
	}
	
}
