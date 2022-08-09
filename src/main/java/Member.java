

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.DataBase;

/**
 * Servlet implementation class Member
 */
@WebServlet("/Member")
public class Member extends HttpServlet {
	
	ServletConfig cfg;
	
	public void init(ServletConfig cfg) throws ServletException {
		super.init(cfg);
		this.cfg= cfg;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		var context= cfg.getServletContext();
		var out= response.getWriter();
		String account= (String)context.getAttribute("account");
		String passwd= (String)context.getAttribute("passwd");
		var dataBase= new DataBase();
		
		String[] data=dataBase.loadData(account, passwd);
		String dataA=String.join(",", data);
		out.print(dataA);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
