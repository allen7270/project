

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
 * @className Showorder
 * @author allen
 * @date 2022年8月13日 上午9:54:39
 */
@WebServlet("/Showorder")
public class Showorder extends HttpServlet {
	ServletConfig scf;
	public void init(ServletConfig scf) throws ServletException{
		super.init(scf);
		this.scf= scf;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		var out= response.getWriter();
		var context= scf.getServletContext();
		String name= (String)context.getAttribute("name");
		String date= (String)context.getAttribute("date");
		var dataBase= new DataBase();
		var dataA=dataBase.searchOrder(name, date);
		String[] menu= {"s1","s2","s3","c1","c2","c3","c4","c5","c6","c7","c8"};
		var map= new HashMap<String, String>();
		for(int i=3, j=0; i<14; i++) {
			if(!dataA.get(i).equals("0")) {
				map.put(menu[j], dataA.get(i));
			}
		}
		var al= new ArrayList<String>();
		al.add(name);
		al.add(date);
		for(int i=14; i<=16; i++) {
			al.add(dataA.get(i));
		}
		al.add(dataA.get(17));
		for(var m: map.entrySet()) {
			al.add(m.getKey()+":"+m.getValue());
		}
		String al1=String.join(",", al);
		out.print(al1);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
