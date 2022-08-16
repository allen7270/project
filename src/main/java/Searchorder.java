

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @projectName project
 * @className Searchorder
 * @author allen
 * @date 2022年8月13日 上午9:45:09
 */
@WebServlet("/Searchorder")
public class Searchorder extends HttpServlet {
//	ServletConfig cfg;
//	public void init(ServletConfig cfg) throws ServletException{
//		super.init(cfg);
//		this.cfg= cfg;
//	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
//		var context= cfg.getServletContext();
		String name= request.getParameter("tdName");
		String date= request.getParameter("tdDate");
//		context.setAttribute("name", name);
//		context.setAttribute("date", date);
//		response.sendRedirect("Showorder.html");
		var session= request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("date", date);
		response.sendRedirect("Showorder.jsp");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
