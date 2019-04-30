package telran.employee.entity;

import telran.employee.StateConstants.StateConstants;

public class WageEmployee extends Employee {
	private double wage;

	public WageEmployee(int id, String firstName, String lastName,
			double hours, double wage) {
		super(id, firstName, lastName, hours);
		this.wage = wage;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public String toString() {
		return "WageEmployee [wage=" + wage + ", toString()="
				+ super.toString() + "]";
	}

	public double calculateSalary() {
		double salary=super.getHours()*wage;
		if(salary<=super.getHours()*StateConstants.MIN_WAGE){
			salary=super.getHours()*StateConstants.MIN_WAGE;
			
		}
		return salary;
	}
	
	

}
