package prototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class Employee implements Cloneable{
	protected String name, position; 
	protected double salary; 
	protected List<String> skills;
	
	public void employeeInfo() {
		System.out.println("~~~Employee Information~~~");
		System.out.println("Name: " + name);
		System.out.println("Position: " + position);
		System.out.println("Salary: " + salary);
		StringBuilder temp = new StringBuilder("Skills : [");
		for (String skill : skills) {
			temp.append(skill);
			temp.append(", ");
		}
		temp.delete(temp.length()-2, temp.length());
		temp.append("]");
		System.out.println(temp.toString());
	}
	
	
	@Override
	public Object clone() {
		try {
			Employee obj = (Employee)super.clone();
			obj.skills = new ArrayList<String>(this.skills);
			return (Object)obj;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("Object Not Cloneable!", e);
		}
	}
	
}

class CEO extends Employee{
	public CEO() {
		name = "Scrooge McDuck";
		position = "CEO";
		salary = 1000000000;
		skills = new ArrayList<String>(Arrays.asList("Fighting","Speaking Bear", "Swimming in Gold", "Time Travel"));
	}
}

class SeasonalEmployees extends Employee{
	public SeasonalEmployees() {
		name = "Donald Duck";
		position = "Seaonal Employee";
		salary = 80000;
		skills = new ArrayList<String>(Arrays.asList("Fighting","Sailor", "Indestructible", "Rage"));
	}
}

class TemporaryEmployees extends Employee{
	public TemporaryEmployees() {
		name = "Dewey Duck";
		position = "Temporary Employee";
		salary = 30000;
		skills = new ArrayList<String>(Arrays.asList("Fighting","TroubleMaker", "Resourceful"));
	}
}

class EmployeeRegistry {
	private static Map<String, Employee> employeeRegistry = new HashMap<>();

	static {
		employeeRegistry.put("CEO", new CEO());
		employeeRegistry.put("Seasonal Employee", new SeasonalEmployees());
		employeeRegistry.put("Temporary Employee", new TemporaryEmployees());
	}
	
	public static Employee getEmployee(String position) {
		Employee emp = employeeRegistry.get(position);
		if (emp == null) {
			throw new IllegalArgumentException("No Such Employee Type!");
		}
		return (Employee) emp.clone();
	}
}

public class MainEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee ceoClone = EmployeeRegistry.getEmployee("CEO");
		ceoClone.employeeInfo();
		System.out.println();
		Employee seaClone = EmployeeRegistry.getEmployee("Seasonal Employee");
		seaClone.employeeInfo();
		System.out.println();
		Employee tempClone = EmployeeRegistry.getEmployee("Temporary Employee");
		tempClone.employeeInfo();
		System.out.println();
	}

}
