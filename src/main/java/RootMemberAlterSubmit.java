

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.Data;
import project.DataBase;

/**
 * 
 * @projectName project
 * @className RootMemberAlterSubmit
 * @author allen
 * @date 2022年8月19日 上午8:28:37
 */
@WebServlet("/RootMemberAlterSubmit")
public class RootMemberAlterSubmit extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String account=request.getParameter("account");
		String username=request.getParameter("username");
		String passwd=request.getParameter("passwd");
		String mail=request.getParameter("mail");
		String phone=request.getParameter("phone");
		var dataBase= new DataBase();
		var dataA= dataBase.showMemberAccount();
		var data= new Data();
		data.setAccount(dataA.get(Integer.valueOf(account)));
		data.setUsername(username);
		data.setPasswd(passwd);
		data.setMail(mail);
		data.setphone(phone);
		dataBase.rootAltermamber(data);
		response.sendRedirect("RootMember.jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
