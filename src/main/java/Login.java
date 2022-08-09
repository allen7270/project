

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.DataBase;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	ServletConfig scf;
	
	public void init(ServletConfig scf)throws ServletException {
		super.init(scf);
		this.scf= scf;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setContentType("text/html;charset=utf-8");
		var context= scf.getServletContext();
		var dataBase= new DataBase();
		String account= request.getParameter("account");
		String passwd= request.getParameter("passwd");
		String verify=dataBase.verify(account, passwd);
		if(verify.equals("member")) {
			context.setAttribute("account", account);
			context.setAttribute("passwd", passwd);
			response.sendRedirect("Member.html");
		} else if(verify.equals("root")) {
			context.setAttribute("account", account);
			context.setAttribute("passwd", passwd);
			response.sendRedirect("Root.html");
		} else {
			response.sendRedirect("Login.html");
		}
	}
	
}
