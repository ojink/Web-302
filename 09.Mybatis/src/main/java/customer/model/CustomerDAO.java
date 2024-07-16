package customer.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.MybatisFactory;

public class CustomerDAO {
	private SqlSession sql; //쿼리실행기능을 가진 클래스
	public CustomerDAO() {
		sql = MybatisFactory.getInstance();
	}
	
	//CRUD: Create, Read, Update, Delete
	
	//신규고객등록
	public int registerCustomer(CustomerDTO dto) {
		return sql.insert("customer.registerCustomer", dto);
	}
	
	//고객정보 변경저장
	public int updateCustomer(CustomerDTO dto) {
		return sql.update("customer.updateCustomer", dto);
	}
	
	//고객정보 삭제
	public int deleteCustomer(int id) {
		return sql.delete("customer.deleteCustomer", id);
	}
	
	//고객정보조회
	public CustomerDTO getOneCustomer(int id) {
		CustomerDTO dto = sql.selectOne("customer.getOneCustomer", id);
		return dto;
	}
	
	
	//고객목록조회
	public List<CustomerDTO> getListOfCustomer() {
		List<CustomerDTO> list = sql.selectList("customer.getListOfCustomer");
		return list;
	}
}
