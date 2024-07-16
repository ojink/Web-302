package level5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import level5.model.Level5DAO;

public class DeleteLevel5 implements Command{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		// 비지니스로직
		// 선택한 제품코드 정보를 DB에서 삭제하기
		new Level5DAO().deleteCode( 
						request.getParameter("code"));
	}

}
