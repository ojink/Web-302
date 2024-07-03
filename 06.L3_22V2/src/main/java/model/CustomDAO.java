package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CustomDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//선택한 회원정보조회
	public CustomDTO getOneCustom(String id) {
		connect();
		CustomDTO dto = null;
		String sql 
		= "select * from custom_01 "
		+ "where p_id = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if( rs.next() ) {
				dto = new CustomDTO();
				dto.setC_email( rs.getString("c_email") );
				dto.setC_name( rs.getString("c_name") );
				dto.setC_tel( rs.getString("c_tel") );
				dto.setP_id( rs.getString("p_id") );
				dto.setP_pw( rs.getString("p_pw") );
			}
		} catch (SQLException e) {
		} finally {
			disconn();
		}
		return dto;
	}
	
	//회원목록조회
	public ArrayList<CustomDTO> getListOfCustom() {
		connect();
		ArrayList<CustomDTO> list = new ArrayList<CustomDTO>();
		String sql = "select * from custom_01";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				CustomDTO dto = new CustomDTO();
				dto.setC_email( rs.getString("c_email") );
				dto.setC_name( rs.getString("c_name") );
				dto.setC_tel( rs.getString("c_tel") );
				dto.setP_id( rs.getString("p_id") );
				dto.setP_pw( rs.getString("p_pw") );
				list.add( dto );
			}
		} catch (SQLException e) {
		} finally {
			disconn();
		}
		return list;
	}
	
	
	private void disconn() {
		if( rs!=null ) {
			try{ rs.close(); }catch(Exception e) {}
		}
		if( ps!=null ) {
			try{ ps.close(); }catch(Exception e) {}
		}
		if( conn!=null ) {
			try{ conn.close(); }catch(Exception e) {}
		}
	}
	
	private void connect() {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/hr");
			conn = ds.getConnection();
			
		} catch (Exception e) {
		}
	}
	
}
