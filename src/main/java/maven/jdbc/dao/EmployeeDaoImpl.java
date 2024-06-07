package maven.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import maven.jdbc.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	static Connection con = null;
//	String insertQuery = "";
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject1","root","Yadav@96");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	@Override
	public void saveEmployee(Employee e) {
		 try{
			  Statement st = con.createStatement();
			  st.executeUpdate("insert into emp1 values("+e.getId()+",'"+e.getName()+"',"+e.getSalary()+",'"+e.getAddress()+"')");
			  System.out.println("data inserted successfully");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}	
	}

	@Override
	public void updateEmployee(Employee e) {
		try {
			Statement st = con.createStatement();
			st.executeUpdate("update emp1 set salary ="+e.getSalary()+" where id = "+e.getId()+" ");
			System.out.println("data updated successfully");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
	}

	@Override
	public void deleteEmployee(Employee e) {
		 
		try {
			Statement st = con.createStatement();
			st.executeUpdate("delete from emp1 where id ="+e.getId()+" ");
			System.out.println("record delete successfully ");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Override
	public void listEmployee() {
		
		try {
			Statement	st = con.createStatement();
			if(st.execute("select * from emp1")) {
				ResultSet rs=st.getResultSet();
			
			while(rs.next()) {
				System.out.println(" id : "+rs.getInt(1)+" name : "+rs.getString(2)+" salary : "+rs.getInt(3)+" address : "+rs.getString(4)+" ");
			}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

//	@Override
//	public void listEmployee() {
//		
//		try {
//			Statement	st = con.createStatement();
//			ResultSet rs = st.executeQuery("select * from emp1");
//			while(rs.next()) {
//				System.out.println(""+rs.getInt(1)+", "+rs.getString(2)+", "+rs.getInt(3)+", "+rs.getString(4)+" ");
//			}
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}

	@Override
	public Employee getEmployeeById(int id) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from emp1 where id= "+id);
			while(rs.next()) {
				System.out.println("id : "+rs.getInt(1)+" name : "+rs.getString(2)+ " salary : "+rs.getInt(3)+" address : "+ rs.getString(4) );
				}
//			System.out.println("search data by id .......");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> getEmps() {
		List<Employee> employees = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from emp1");
			while(rs.next()) {
				Employee e = new Employee(0,null,0,null);
				e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setSalary(rs.getInt("salary"));
                e.setAddress(rs.getString("address"));
				System.out.println(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public void getEmployeeByName(String name) {
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from emp1 where name= '' "+name);
			while(rs.next()) {
				System.out.println(" id : "+rs.getInt(1)+" name : "+rs.getString(2)+ " salary : "+rs.getInt(3)+" address : "+ rs.getString(4) );
				}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void saveEmployeeByPS(Employee e) {
		try {
			PreparedStatement ps =con.prepareStatement("insert into emp1(id,name,salary,address) values(?,?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setInt(3, e.getSalary());
			ps.setString(4, e.getAddress());
			
			con.setAutoCommit(false);
			
			ps.executeUpdate();
			con.commit();
			System.out.println("data save successfully ......................");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}


}
