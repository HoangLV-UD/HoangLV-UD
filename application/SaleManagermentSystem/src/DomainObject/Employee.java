package DomainObject;

public class Employee {

	public Employee(int employeeId, String employeeName, float salary, String supervisorId) {
		super();
		EmployeeId = employeeId;
		EmployeeName = employeeName;
		Salary = salary;
		SupervisorId = supervisorId;
	}
	
	public Employee() {
		
	}

	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public float getSalary() {
		return Salary;
	}
	public void setSalary(float salary) {
		Salary = salary;
	}
	public String getSupervisorId() {
		return SupervisorId;
	}
	public void setSupervisorId(String supervisorId) {
		SupervisorId = supervisorId;
	}
	private int EmployeeId ;
	private String EmployeeName;
	private float Salary;
	private String SupervisorId;  
}
