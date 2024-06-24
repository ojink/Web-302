package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class HrDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//선택한 사원정보 조회
	public EmployeeDTO employeeInfo(int employee_id) {
		connect();
		
		EmployeeDTO dto = null;
		StringBuffer sql = new StringBuffer();
		sql	.append("select last_name||' '||first_name as name ")
			.append("       , job_title, department_name, e.* ")
			.append("from employees e left outer join departments d ")
			.append("on e.department_id=d.department_id ")
			.append("inner join jobs j on j.job_id=e.job_id ")
			.append("where employee_id = ? ")
			;
		
		try {
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, employee_id);
			rs = ps.executeQuery();
			if( rs.next() ) {
				dto = new EmployeeDTO();
				dto.setJob_title( rs.getString("job_title") );
				dto.setDepartment_name( rs.getString("department_name") );
				dto.setDepartment_id( rs.getInt("department_id") );
				dto.setEmployee_id( rs.getInt("employee_id") );
				dto.setName( rs.getString("name") );
				dto.setHire_date( rs.getDate("hire_date") );
				dto.setJob_id( rs.getString("job_id") );
				dto.setPhone_number( rs.getString("phone_number") );
				dto.setEmail( rs.getString("email") );
				dto.setSalary( rs.getInt("salary") );
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			disconnect();
		}
		return dto;
	}
	
	
	//사원목록조회
	public ArrayList<EmployeeDTO> employeeList() {
		connect();
		
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		String sql 
		= "select last_name||' '||first_name as name, e.* "
		+ "from employees e";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				EmployeeDTO dto = new EmployeeDTO();
				dto.setEmployee_id( rs.getInt("employee_id") );
				dto.setName( rs.getString("name") );
				dto.setDepartment_id( rs.getInt("department_id") );
				dto.setJob_id( rs.getString("job_id") );
				dto.setHire_date( rs.getDate("hire_date") );
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			disconnect();
		}
		return list;
	}
	
	
	public void connect() {
		try {
			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "0000");
//			DBCP 사용하기
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/hr");
			conn = ds.getConnection(); //DBCP에서 한 개를 빌려온다
			
		} catch (Exception e) {
		}
	}
	
	public void disconnect() {
		if( rs!=null ) {
			try{ rs.close(); }catch(Exception e) {}
		}
		if( ps!=null ) {
			try{ ps.close(); }catch(Exception e) {}
		}
		if( conn!=null ) { //DBCP 객체를 반환
			try{ conn.close(); }catch(Exception e) {}
		}
	}
	
}
