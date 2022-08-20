<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="project.DataBase, java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Root</title>
    <style>
        @import url(css/member.css) (max-width: 1399px);
        @import url(css/member_w14.css) (min-width: 1399px);
    </style>
</head>
<body class="b">
    <div class="div1">
        <ul>
            <li><a class="index" href="Home.html" >HOME</a></li>
            <li><a class="index" href="Reserved.html">RESERVED</a></li>
            <li><a class="index" href="Menu.html">MENU</a></li>
            <li><a class="index" href="Login.html"style="color: rgba(0, 0, 0, 0.463)">LOGIN</a></li>
        </ul>
    </div>
    <div>
        <div class="login">
            <span>Root-Punch</span>
        </div>
        <div style="float: left;width: 23%;">
        <p><br></p>
        </div>
        <form>
            <fieldset class="account backdrop-blur">
                <table width="700">
                    <tr>
                        <th>日期</th>
                        <th>帳號</th>
                        <th>上班</th>
                        <th>下班</th>
                    </tr>
                    <%
                    	DataBase dataBase= new DataBase();
                    	ArrayList<String> data= dataBase.showPunch();
                    	// dataNumber is data column
                    	int dataNumber=4;
                    	// record is data row
                    	double record=data.size()/dataNumber;
                    	for(int i=0; i<record; i++){
                    		out.print("<tr>");
                    		for(int j=0; j<dataNumber; j++){
                    			out.print("<td>"+data.get(j+(dataNumber*i))+"</td>");
                    		}
                    		out.print("</tr>");
                    	}
                    %>
                </table>
                <p class="text" style="margin-bottom: 3%;"></p>
                <a href="Root.html" class="alter">管理員首頁</a>
            </fieldset>
        </form>
    </div>
</body>
</html>