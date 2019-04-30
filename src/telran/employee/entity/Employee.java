package telran.employee.entity;

public abstract class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private double hours;
	public Employee(int id, String firstName, String lastName, double hours) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hours = hours;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		this.hours = hours;
	}
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", hours=" + hours + "]";
	}
	
	abstract public double calculateSalary();
	
	public double calculateTax(){
		double salary=this.calculateSalary();
		double tax=0;
		int [] levels= {0, 6220, 8920, 14320, 19900, 41410, 53333};
		double [] rates= {0.1, 0.14, 0.2, 0.31, 0.35, 0.47, 0.5};
		for (int i = 0; i < rates.length; i++){
			if(salary>levels[i]&&salary<=levels[i+1]){
				return tax+((salary-levels[i])*rates[i]);
			}
			else {
				tax=tax+((salary-levels[i+1])*rates[i]);
			}
		}
		return tax+((salary-levels[levels.length])*rates[rates.length]);
	}
	
	public void showtax(){
		System.out.println(this.getFirstName());
		System.out.println(this.getLastName());
		System.out.println(this.getId());
		System.out.println("Salary before tax: "+this.calculateSalary());
		System.out.println("Salary after tax: "+(this.calculateSalary()-this.calculateTax()));
		System.out.println("********************");
		
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(hours);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (Double.doubleToLongBits(hours) != Double
				.doubleToLongBits(other.hours))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	
}
