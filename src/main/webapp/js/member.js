function show(){
	if(window.ActiveXObject){
		xmlHTTP=new ActiveXObject("Microsoft.XMLHTTP");
		}
		else if(window.XMLHttpRequest){
			xmlHTTP=new XMLHttpRequest();
		}
		xmlHTTP.open("get","http://localhost:8080/project/Member?", true);
		xmlHTTP.onreadystatechange=function check_status(){
		if(xmlHTTP.readyState == 4 && xmlHTTP.status == 200){
			var ans=xmlHTTP.responseText;
			ans=ans.split(',');
			document.getElementById("username").innerText= ans[0];
			document.getElementById("account").innerText= ans[1];
			document.getElementById("passwd").innerText= ans[2];
			document.getElementById("mail").innerText= ans[3];	
			document.getElementById("phone").innerText= ans[4];
		}
		}
		xmlHTTP.send();
}
function alter(){
	alert("ok!");
	// document.getElementById("username").innerHTML='<input type="text" name="username" id="username" size="40">';
	// document.getElementById("account").innerHTML='<input type="text" name="username" id="username" size="40">';
	// document.getElementById("passwd").innerHTML='<input type="text" name="username" id="username" size="40">';
	// document.getElementById("mail").innerHTML='<input type="text" name="username" id="username" size="40">';
	// document.getElementById("phone").innerHTML='<input type="text" name="username" id="username" size="40">';
	// document.getElementById("button").value="確認";
	// document.getElementById("button").innerHTML='<input type="submit" value="確認">'
	// alert("ok!");
}