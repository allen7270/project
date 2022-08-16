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
            <li><a class="index" href="Home.html" >首頁</a></li>
            <li><a class="index" href="Reserved.html">線上訂位</a></li>
            <li><a class="index" href="Menu.html">菜單</a></li>
            <li><a class="index" href="Login.html"style="color: rgba(0, 0, 0, 0.463)">會員專區</a></li>
        </ul>
    </div>
    <div>
        <div class="login">
            <span>Root</span>
        </div>
        <div style="float: left;width: 23%;">
        <p><br></p>
        </div>
        <form method="post" action="http://localhost:8080/project/Root.jsp">
            <fieldset class="account backdrop-blur">
                <table width="700">
                    <tr>
                        <th>姓名</th>
                        <th>帳號</th>
                        <th>密碼</th>
                        <th>信箱</th>
                        <th>電話</th>
                    </tr>
                    <%
                    	DataBase dataBase= new DataBase();
                    	ArrayList<String> data= dataBase.showMember();
                    	double record=data.size()/5;
                    	for(int i=0; i<record; i++){
                    		out.print("<tr>");
                    		out.print("<td>"+data.get(0+(5*i))+"</td>");
                    		out.print("<td>"+data.get(1+(5*i))+"</td>");
                    		out.print("<td>"+data.get(2+(5*i))+"</td>");
                    		out.print("<td>"+data.get(3+(5*i))+"</td>");
                    		out.print("<td>"+data.get(4+(5*i))+"</td>");
                    		out.print("</tr>");
                    	}
                    %>
                </table>
                <p class="text" style="margin-bottom: 3%;"></p>
                <a href="Root.html" class="alter">管理員首頁</a>
                <input type="button" class="button" value="修改會員資料" onclick="alter()">
            </fieldset>
        </form>
    </div>
</body>
</html>