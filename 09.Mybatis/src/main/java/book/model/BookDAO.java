package book.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MybatisFactory;

public class BookDAO {
	private SqlSession sql	;
	
	public BookDAO() {
		sql = MybatisFactory.getHanulInstance();
	}
	
	public List<BookDTO> getListOfBook(){
		return sql.selectList("book.getListOfBook");
	}
	
}
