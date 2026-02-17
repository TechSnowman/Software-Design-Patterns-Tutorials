package composite;

import java.util.ArrayList;
import java.util.List;

// Step 1: Define a Common Interface(Component)
interface Employeee {
	void showDetails();
}

// Step 2: Create the Leaf Class (Individual Employees)
// Leaf class(Individual Employee)
class Worker implements Employeee {
	private String name;
	private String position;
	
	public Worker(String name, String position) {
		this.name = name;
		this.position = position;
	}

	@Override
	public void showDetails() {
		System.out.println(name + " - " +position);
	}
}


// Step 3: Create the Composite Class (Managers)
// Composite class (Managers who supervise workers)
class Manager implements Employeee {
	private String name;
	private String department;
	private List<Employeee> subordinates = new ArrayList<>();
	
	public Manager(String name, String department) {
		this.name = name;
		this.department = department;
	}
	
	public void addEmployee(Employeee employee) {
		subordinates.add(employee);
	}
	public void removeEmployee(Employeee employee) {
		subordinates.remove(employee);
	}
	
	@Override
	public void showDetails() {
		System.out.println(name + " - Manager of " + department);
		System.out.println(" Subordinates:");
		for (Employeee employee : subordinates) {
			System.out.println("     "); // Indentation for readability
			employee.showDetails();
		}
	}
}

//Step 4: Use the Composite Pattern in a Main Class
public class MainCompany {
	public static void main(String[] args) {
		// Creating individual workers
        Employeee worker1 = new Worker("Alice", "Developer");
        Employeee worker2 = new Worker("Bob", "Designer");
        Employeee worker3 = new Worker("Charlie", "Tester");
        
        // Creating a manager and adding employees
        Manager manager1 = new Manager("David", "Software Team");
        manager1.addEmployee(worker1);
        manager1.addEmployee(worker2);
        
        // Creating another manager
        Manager generalManager = new Manager("Eve", "Company");
        generalManager.addEmployee(manager1);
        generalManager.addEmployee(worker3);

        // Display hierarchy
        System.out.println("Company Hierarchy:");
        generalManager.showDetails();
	}

}
