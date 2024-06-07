package maven.jdbc.dao;

import java.util.List;

import maven.jdbc.entity.Employee;

public interface EmployeeDao {
	public void saveEmployee(Employee e);
	public void saveEmployeeByPS(Employee e);
	public void updateEmployee(Employee e);
	public void deleteEmployee(Employee e);
	public void listEmployee();
	List<Employee> getEmps();
	Employee getEmployeeById(int id);
	void getEmployeeByName(String name);
}
