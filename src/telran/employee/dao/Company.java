package telran.employee.dao;

import telran.employee.entity.Employee;

public class Company {

	private Employee[] employees;
	private int companySize;
	
	public Company(int capacity){
		employees=new Employee[capacity];
		companySize=0;
	}
	
	public boolean addEmployee(Employee employee){		// нанятие нового сотрудника
		if(companySize<employees.length){
			employees[companySize]=employee;
			companySize++;
			return true;
		}
		return false;
	}
	public boolean removeEmployee(Employee employee){		//удаление сотрудника
		for (int i = 0; i < companySize; i++) {
			if(employees[i].equals(employee)){
				employees[i]=employees[companySize-1];
				companySize--;
				return true;
			}
			
		}
		return false;
	}
	public double minSalary(){			//метод помогает найти самого бедного чувака
		double min = employees[0].calculateSalary();
		for (int i = 0; i < companySize; i++) {
			if(employees[i].calculateSalary()<min){
				min=employees[i].calculateSalary();
			}
			
		}
		return min;
	}
	
	public double maxSalary(){		//самого богатого сотрудника
		double max = employees[0].calculateSalary();
		for (int i = 0; i < companySize; i++) {
			if(employees[i].calculateSalary()>max){
				max=employees[i].calculateSalary();
			}
			
		}
		return max;
		
	}
	
	public double sumSalary(){		//фонд всех вместе зарплат
		double sum=0;
		for (int i = 0; i < companySize; i++) {
			sum=sum+employees[i].calculateSalary();
			
		}
		return sum;
	}
	
	public Employee employeeMinSalary(){  //возвращаем не цифру а человека с минимальной зарплатой
		Employee min = employees[0]; 
		for (int i = 0; i < companySize; i++) {
			if(employees[i].calculateSalary()<min.calculateSalary()){
				min=employees[i];	
			}
		}
		return min;
	}
	
	public Employee[] poorMens(int num){   //вычесление нескольких самых бедных человек
		double minSalary=this.minSalary();
		Employee[] min = new Employee[num];
		int size=0;
		for (int i = 0; i < companySize; i++){
			if(employees[i].calculateSalary()==minSalary && size<num){
				min[size]=employees[i];   //в массив сайс кладём текущего человека
				size++;
			}
		}
		return min;	
	}
	
	public void display(){
		for (int i = 0; i < companySize; i++) {
			employees[i].showtax();		
		}
	}
	public void display(Employee[] employees){
		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i]);	
		}
		
	}
	
}
