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
            <span>Root-OnlineOrder</span>
        </div>
        <div style="float: left;width: 23%;">
        <p><br></p>
        </div>
        <form method="post" action="http://localhost:8080/project/RootMember.jsp">
            <fieldset class="account backdrop-blur">
                <table width="700">
                    <tr>
                        <th>流水號</th>
                        <th>日期</th>
                        <th>名字</th>
                        <th>付款方式</th>
                        <th>訂餐內容</th>
                    </tr>
                    <%
                    	DataBase dataBase= new DataBase();
                    	ArrayList<String> data= dataBase.showOnlineOrder();
                    	ArrayList<String> info= dataBase.showOnlineOrderInfo();
                    	String[] menu= {"s1","s2","s3","c1","c2","c3","c4","c5","c6","c7","c8"};
                    	String item="";
          				for(int j=0, k=0; j<data.size(); j++){
          					if(k>10){
          						k=0;
          					}
          					if(j%11==0&&j!=0){
          						item+=";";
          					}
          					if(!data.get(j).equals("0")){
          						item+=menu[k]+":"+data.get(j)+" ";
          					}
          					k++;
          				}
               			String[] itemA= item.split(";");
                    	double record=info.size()/4;
                    	for(int i=0; i<record; i++){
                    		out.print("<tr>");
                    		out.print("<td>"+info.get(0+(4*i))+"</td>");
                    		out.print("<td>"+info.get(1+(4*i))+"</td>");
                    		out.print("<td>"+info.get(2+(4*i))+"</td>");
                    		out.print("<td>"+info.get(3+(4*i))+"</td>");
                    		out.print("<td>"+itemA[i]+"</td>");
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