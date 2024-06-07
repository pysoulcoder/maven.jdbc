package maven.jdbc;

import maven.jdbc.dao.EmployeeDao;
import maven.jdbc.dao.EmployeeDaoImpl;
import maven.jdbc.entity.Employee;

public class app {
	public static void main(String [] args) {
		Employee pradeep = new Employee(9,"Dhiraj",45000,"meerut");
		EmployeeDao edao = new EmployeeDaoImpl();
		
//		edao.saveEmployee(pradeep);
		edao.saveEmployeeByPS(pradeep);
//		pradeep.setSalary(50000);
//		pradeep.setName("Vinay");
//		edao.updateEmployee(pradeep);
//		edao.deleteEmployee(pradeep);
//		edao.listEmployee();
//		edao.getEmployeeById(3);
//		edao.getEmps();
//		edao.getEmployeeByName("'anu Sir' or 1=1");
		System.out.println("Data save successful............");
	}
	
}
