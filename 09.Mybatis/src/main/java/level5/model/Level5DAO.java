package level5.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MybatisFactory;

public class Level5DAO {
	private SqlSession sql;
	
	public Level5DAO() {
		sql = MybatisFactory.getInstance();
	}
	
	// CRUD
	// 제품코드 등록
	public int registerCode(Level5DTO dto) {
		return 0;
	}
	// 제품코드 조회
	public Level5DTO getOneCode(String code) {
		return sql.selectOne("level5.getOneCode", code);
	}
	// 제품코드목록 조회
	public List<Level5DTO> getListOfCode(){
		return null;
	}
	// 제품코드 정보 변경
	public int updateCode(Level5DTO dto) {
		return 0;
	}
	// 제품코드 정보 삭제
	public int deleteCode(String code) {
		return 0;
	}
}





