package level3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import level3.model.Level3DAO;

public class DeleteLevel3 implements Command{

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		// 비지니스로직
		// 선택한 회원정보를 DB에서 삭제하기
		new Level3DAO().deleteLevel3( request.getParameter("id") );
	}

}
