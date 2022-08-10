

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.DataBase;
import project.ReservedData;

/**
 * 
 * @projectName project
 * @className Reserved
 * @author allen
 * @date 2022年8月5日 下午2:58:27
 * Servlet implementation class Login
 */
@WebServlet("/Reserved")
public class Reserved extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name= request.getParameter("username");
		String mail= request.getParameter("mail");
		String phone= request.getParameter("phone");
		String [] dateA= {"dateC", "dateG", "dateL"};
		String [] timeA= {"timeC", "timeG", "timeL"};
		String [] numberA= {"numberC", "numberG", "numberL"};
		String deptno="", date="", time="", number="";
		int i;
		
		for(i=0; i<dateA.length; i++) {
			date= request.getParameter(dateA[i]);
			time=  request.getParameter(timeA[i]);
			number= request.getParameter(numberA[i]);
			if(date.length()!=0) {
				break;
			} else {
				continue;
			}
		}
		switch(i) {
		case 0:
			deptno= "D01";
			break;
		case 1:
			deptno= "D02";
			break;
		case 2:
			deptno= "D03";
			break;
		}
		var rdata= new ReservedData(name, deptno, date, time, number, mail, phone);
		var dataBase= new DataBase();
		dataBase.insert(rdata);
		response.sendRedirect("Menu.html");
	}

}
