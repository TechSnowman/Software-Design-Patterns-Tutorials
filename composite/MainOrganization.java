package composite;

import java.util.ArrayList;
import java.util.List;

interface OrganizationComponent {
	void showDetails();
}

class Employee implements OrganizationComponent{
	private String name;
	private String position;
	
	public Employee(String name, String position) {
		this.name = name;
		this.position = position;
	}

	@Override
	public void showDetails() {
		System.out.println("Employee: " + name + " - " + position);
	}
}

class Department implements OrganizationComponent {
	private String department;
	private List<OrganizationComponent> members = new ArrayList<>();
	
	public Department( String department) {
		this.department = department;
	}
	public void addMember(OrganizationComponent member) {
		members.add(member);
	}
	public void removeMember(OrganizationComponent member) {
		members.remove(member);
	}
	
	
	@Override
	public void showDetails() {
		System.out.println("Department: " + department);
		for (OrganizationComponent organizationComponent : members) {
			if (organizationComponent instanceof Employee) {
				System.out.print("\t");
			}
			System.out.print("\t");
			organizationComponent.showDetails();
		}
	}


}





public class MainOrganization {

	public static void main(String[] args) {
		Department softwareDept = new Department("Software Department");
		Department hardwareDept = new Department("Hardware Department");

		Employee alice = new Employee("Alice", "Software Engineer");
		Employee bob = new Employee("Bob", "Hardware Engineer");

		softwareDept.addMember(alice);
		hardwareDept.addMember(bob);

		Department engineeringDept = new Department("Engineering Department");
		engineeringDept.addMember(softwareDept);
		engineeringDept.addMember(hardwareDept);

		engineeringDept.showDetails();

	}

}
