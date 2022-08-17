<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="project.DataBase, java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order</title>
    <style>
        @import url(css/member.css) (max-width: 1399px);
        @import url(css/member_w14.css) (min-width: 1399px);
    </style>
    <script src="js/showorder.js"></script>
</head>
<body class="b" onload="show()">
    <div class="div1">
        <ul>
            <li><a class="index" href="Home.html" >首頁</a></li>
            <li><a class="index" href="Reserved.html">線上訂位</a></li>
            <li><a class="index" href="Menu.html" style="color: rgba(0, 0, 0, 0.463)">菜單</a></li>
            <li><a class="index" href="Login.html">會員專區</a></li>
        </ul>
    </div>
    <div>
        <div class="login">
            <span>Order</span>
        </div>
        <div style="float: left;width: 11%;">
        <p><br></p>
        </div>
        <form name="data" >
            <fieldset class="account backdrop-blur">
                <table width="1000">
                    <tr>
                        <th>訂購姓名</th>
                        <th>訂購日期</th>
                        <th>送貨地址</th>
                        <th>訂購信箱</th>
                        <th>訂購電話</th>
                        <th>付款方式</th>
                        <th>訂餐內容</th>
                    </tr>
                        <%
                        String name= (String)session.getAttribute("name");
                        String date= (String) session.getAttribute("date");
                        DataBase dataBase= new DataBase();
                        ArrayList<String> dataA= dataBase.searchOrder(name, date);
                        ArrayList<String> pay= dataBase.paymethod(name, date);
                        ArrayList<String> Info= dataBase.orderInfo(name);
                		String[] menu= {"s1","s2","s3","c1","c2","c3","c4","c5","c6","c7","c8"};
                		double record= (dataA.size()/11);
                		String item="";
          				for(int j=0, k=0; j<dataA.size(); j++){
          					if(k>10){
          						k=0;
          					}
          					if(j%11==0&&j!=0){
          						item+=";";
          					}
          					if(!dataA.get(j).equals("0")){
          						item+=menu[k]+":"+dataA.get(j)+" ";
          					}
          					k++;
          				}
               			String[] itemA= item.split(";");
                		for(int i=0; i<record; i++){
                			out.print("<tr>");
                			out.print("<td name='tdName' id='tdName'>"+name+"</td>");
                    		out.print("<td name='tdDate' id='tdDate'>"+date+"</td>");
                    		out.print("<td name='tdLoc' id='tdLoc'>"+Info.get(0)+"</td>");
                    		out.print("<td name='tdMail' id='tdMail'>"+Info.get(1)+"</td>");
                    		out.print("<td name='tdCell' id='tdCell'>"+Info.get(2)+"</td>");
                    		out.print("<td name='tdPay' id='tdPay'>"+pay.get(i)+"</td>");
                    		out.print("<td name='tdItem' id='tdItem'>"+itemA[i]+"</td>");
                		}
                   		out.print("</tr>");
                        %>
                </table>
                <p style="margin-bottom: 3%;"></p>
                <a href="Searchorder.html" class="alter"><img src="css/image/refresh.svg"  width="3%"></a>
            </fieldset>
        </form>
    </div>
</body>
</html>