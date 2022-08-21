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
    <script src="js/rootAlter.js"></script>
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
            <span>Root-Member</span>
        </div>
        <div style="float: left;width: 11%;">
        <p><br></p>
        </div>
        <fieldset class="account backdrop-blur">
        	<a class="alter" href="RootMember.jsp">會員資料</a>
            <a class="alter" style="margin-left: 10px;" href="RootOrderOnline.jsp">線上訂單</a>
            <a class="alter" style="margin-left: 10px;" href="RootOrderOnsite.jsp">線場訂單</a>
            <a class="alter" style="margin-left: 10px;" href="RootReserved.jsp">線上訂位</a>
            <a class="alter" style="margin-left: 10px;" href="RootPunch.jsp">打卡資料</a>
            <form name="data"  method="post" action="http://localhost:8080/project/RootMemberAlterSubmit">
	            <table width="990" style="margin-left: 15px; margin-top: 3%">
	                <tr>
	                    <th>帳號</th>
	                    <th>姓名</th>
	                    <th>密碼</th>
	                    <th>信箱</th>
	                    <th>電話</th>
	                </tr>
	                <tr>
	                <%
	                    DataBase dataBase= new DataBase();
	                    ArrayList<String> data= dataBase.showMemberAccount();
	                    String username="allen";
	                    out.print("<td><select onchange='show()' name='account' id='account'>");
	                    out.print("<option>請選擇</option>");
	                    for(int i=0; i<data.size(); i++){
	                        out.print("<option value='"+i+"'>"+data.get(i)+"</option>");
	                    }
	                    out.print("</td></select>");
	                %>
	                <script>
				        function show(){
				        	optionValue= document.getElementById('account').value;
				            // Ajax- get data
				        	if(window.ActiveXObject){
				        		xmlHTTP=new ActiveXObject("Microsoft.XMLHTTP");
				       		}
				       		else if(window.XMLHttpRequest){
				       			xmlHTTP=new XMLHttpRequest();
				       		}
				       		xmlHTTP.open('post','http://localhost:8080/project/MemberData?username='+optionValue+'', true);
				       		
				       		xmlHTTP.onreadystatechange=function check_status(){
				       		if(xmlHTTP.readyState == 4 && xmlHTTP.status == 200){
				       			var ans=xmlHTTP.responseText;
				       			ans=ans.split(',');
				       			document.getElementById('username').innerHTML='<input type="text" name="username" readonly value="'+ans[0]+'">';
				       			document.getElementById('passwd').innerHTML='<input type="text" name="passwd" id="passwdIn" placeholder=" 至少5位元" value="'+ans[1]+'">';
				       			document.getElementById('mail').innerHTML='<input name="mail" type="text" id="mailIn" placeholder=" xxx@xxx.xxx" value="'+ans[2]+'">';
				       			document.getElementById('phone').innerHTML='<input name="phone" type="text" id="phoneIn" placeholder=" 手機號碼" value="'+ans[3]+'">';
				       			document.getElementById('account').value=optionValue;
				       			
				       		}
				       		}
				       		xmlHTTP.send();
				        }
				    </script>
	                	<td id="username"></td>
	                	<td id="passwd"></td>
	                	<td id="mail"></td>
	                	<td id="phone"></td>
	                </tr>
	            </table>
	            <p class="text" style="margin-bottom: 3%;"></p>
                <a href="Root.html" class="alter">管理員首頁</a>
                <!-- submit account(optionValue) -->
                <input type="hidden" name="account" id="account">
                <input type="button" class="button" value="確認" onclick="check()">
            </form>
        </fieldset>
    </div>
</body>
</html>