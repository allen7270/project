

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.DataBase;
import project.OrderData;
/**
 * 
 * @projectName project
 * @className Checkout
 * @author allen
 * @date 2022年8月12日 上午12:00:36
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	
	ServletConfig cfg;
	public void init(ServletConfig cfg) throws ServletException {
		super.init(cfg);
		this.cfg= cfg;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		var context= cfg.getServletContext();
		// orderDetail
		var order= new ArrayList<String>();
		String[] data= {"set1","set2","set3","carte1","carte2","carte3","carte4","carte5","carte6","carte7","carte8"};
		for(int i=0; i<data.length; i++) {
			order.add((String) context.getAttribute(data[i]));
			if(order.get(i).equals("")) {
				order.set(i, "0");
			}
		}
		// orderInfo
		String username= request.getParameter("username");
		String loc= request.getParameter("loc");
		String mail= request.getParameter("mail");
		String phone= request.getParameter("phone");
		var orderData= new OrderData(username, loc, mail, phone);
		var dataBase= new DataBase();
		context.setAttribute("username", username);
		dataBase.order(order, orderData);
		// back to Menu.html
		response.sendRedirect("Payment.html");
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
