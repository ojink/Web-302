package l5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.CodeDAO;
import model.CodeDTO;

public class CodeUpdate implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//비지니스로직
		//화면의 정보 수집  -> DB에 변경저장
		CodeDTO dto = new CodeDTO();
		dto.setCode( request.getParameter("code"));
		dto.setMaker( request.getParameter("maker"));
		
		CodeDAO dao = new CodeDAO();
		dao.updateMaker(dto);
	}

}
