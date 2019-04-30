package telran.employee.entity;

import telran.employee.StateConstants.StateConstants;

public class SalesManager extends Employee {
	private double salesValue;
	private double percent;
	public SalesManager(int id, String firstName, String lastName,
			double hours, double salesValue, double percent) {
		super(id, firstName, lastName, hours);
		this.salesValue = salesValue;
		this.percent = percent;
	}
	public double getSalesValue() {
		return salesValue;
	}
	public void setSalesValue(double salesValue) {
		this.salesValue = salesValue;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	public String toString() {
		return "SalesManager [salesValue=" + salesValue + ", percent="
				+ percent + ", toString()=" + super.toString() + "]";
	}
	public double calculateSalary() {
		double salary=salesValue*percent;
		if(salary<=super.getHours()*StateConstants.MIN_WAGE){
			salary=super.getHours()*StateConstants.MIN_WAGE;
		}
		return salary;
	}
	
	

}
