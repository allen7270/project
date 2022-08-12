

import java.io.IOException;
import java.util.ArrayList;

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
 * @className Checkout
 * @author allen
 * @date 2022年8月12日 上午8:30:21
 */
@WebServlet("/Order")
public class Order extends HttpServlet {
	
	ServletConfig cfg;
	
	public void init(ServletConfig cfg) throws ServletException {
		super.init(cfg);
		this.cfg= cfg;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		var context= cfg.getServletContext();
		String[] data= {"set1","set2","set3","carte1","carte2","carte3","carte4","carte5","carte6","carte7","carte8"};
		for(int i=0; i<data.length; i++) {
			context.setAttribute(data[i], request.getParameter(data[i]));
		}
		response.sendRedirect("Shopcar.html");	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
