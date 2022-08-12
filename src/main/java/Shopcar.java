

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Shopcar
 */
@WebServlet("/Shopcar")
public class Shopcar extends HttpServlet {
	ServletConfig scf;
	public void init(ServletConfig scf) throws ServletException {
		super.init(scf);
		this.scf= scf;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var context= scf.getServletContext();
		var order= new ArrayList<String>();
		String[] data= {"set1","set2","set3","carte1","carte2","carte3","carte4","carte5","carte6","carte7","carte8"};
		for(int i=0; i<data.length; i++) {
			order.add((String) context.getAttribute(data[i]));
			if(order.get(i).equals("")) {
				order.set(i, "0");
			}
		}
		String dataA= String.join(",", order);
		var out= response.getWriter();
		out.print(dataA);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
