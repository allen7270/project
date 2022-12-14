

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.DataBase;

/**
 * 
 * @projectName project
 * @className Root
 * @author allen
 * @date 2022年8月8日 下午2:45:53
 * Servlet implementation class Login
 */
@WebServlet("/Root")
public class Root extends HttpServlet {
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
		String p=(String)request.getParameter("punch");
		if(p.equals("null")) {
			String[] data=dataBase.loadPunchdata(account, passwd);
			String dataA=String.join(",", data);
			out.print(dataA);
		}
		else if(p.equals("true")) {
			dataBase.punch(account);
			String[] data=dataBase.loadPunchdata(account, passwd);
			String dataA=String.join(",", data);
			out.print(dataA);
		}	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
