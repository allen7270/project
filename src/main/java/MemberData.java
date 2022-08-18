

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.DataBase;

/**
 * Servlet implementation class MemberData
 */
@WebServlet("/MemberData")
public class MemberData extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int username= Integer.parseInt(request.getParameter("username"));
		var dataBase= new DataBase();
		var data= dataBase.showMemberDetail();
		var dataA= new ArrayList<String>();
		// data column
		int column=4;
		for(int i=0; i<column; i++) {
			dataA.add(data.get(i+(column*username)));
		}
//		dataA.add(data.get(0+(column*username)));
//		dataA.add(data.get(1+(column*username)));
//		dataA.add(data.get(2+(column*username)));
//		dataA.add(data.get(3+(column*username)));
		var out= response.getWriter();
		out.print(String.join(",", dataA));
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
