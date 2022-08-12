

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.DataBase;
import project.OrderData;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/Payment")
public class Payment extends HttpServlet {
	ServletConfig cfg;
	public void init(ServletConfig cfg) throws ServletException {
		super.init(cfg);
		this.cfg= cfg;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		var context= cfg.getServletContext();
		String username= (String)context.getAttribute("username");
		String pay= request.getParameter("payMethod");
		String show= request.getParameter("show");
		if(show==null) {
			show="no";
		}
		var data= new OrderData();
		data.setUsername(username);
		data.setPaymentmethod(pay);
		var dataBase= new DataBase();
		if(show.equals("yes")) {
			// show total to Payment.html (Ajax)
			var out= response.getWriter();
			out.println(dataBase.show(data));
		}else {
			// update orderDetail(`paymentMethod`)
			dataBase.updatePay(data);
			// back to Menu.html
			response.sendRedirect("Menu.html");
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
