

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.Data;
import project.DataBase;
import project.Treat;

/**
 * 
 * @projectName project
 * @className Register
 * @author allen
 * @date 2022年8月4日 下午7:48:04
 * Servlet implementation class Login
 */
@WebServlet("/Register")
public class Register extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setContentType("text/html;charset=utf-8");
//		var out= response.getWriter();
		String name= request.getParameter("username");
		String account= request.getParameter("account");
		String passwd= request.getParameter("passwd");
		String mail= request.getParameter("mail");
		String phone= request.getParameter("phone");
		// Encryption passwd
		var treat= new Treat();
		var data= new Data(name, account, treat.Encryption(passwd), mail, phone);
		var dataBase= new DataBase();
		dataBase.add(data);
		// if register successful redirect to member.html
		response.sendRedirect("Login.html");
	}

}
