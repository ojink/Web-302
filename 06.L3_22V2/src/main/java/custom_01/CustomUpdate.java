package custom_01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import model.CustomDAO;
import model.CustomDTO;

public class CustomUpdate implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//비지니스로직
		//화면에서 변경입력한 정보로 DB에 변경저장
		CustomDTO dto = new CustomDTO();
		dto.setC_email( request.getParameter("c_email") );
		dto.setC_name( request.getParameter("c_name") );
		dto.setC_tel( request.getParameter("c_tel") );
		dto.setP_pw( request.getParameter("p_pw") );
		dto.setP_id( request.getParameter("p_id") );
		
		CustomDAO dao = new CustomDAO();
		dao.updateCustom(dto);
	}

}
