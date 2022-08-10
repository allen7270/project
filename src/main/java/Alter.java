

import java.io.IOException;

import javax.servlet.ServletConfig;
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
 * @className Alter
 * @author allen
 * @date 2022年8月9日 下午3:35:28
 *
 * Servlet implementation class Alter
 */
@WebServlet("/Alter")
public class Alter extends HttpServlet {
	ServletConfig scg; 
	public void init(ServletConfig scg) throws ServletException {
		super.init(scg);
		this.scg= scg;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		var context= scg.getServletContext();
		String account= (String)context.getAttribute("account");
		String passwd= (String)context.getAttribute("passwd");
		String passwdAlter= request.getParameter("passwd");
		String mail= request.getParameter("mail");
		String phone= request.getParameter("phone");
		var database= new DataBase();
		var data= new Data();
		data.setAccount(account);
		data.setPasswd(passwd);
		data.setMail(mail);
		data.setphone(phone);
		database.alter(data,passwdAlter);
		response.sendRedirect("Login.html");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
