function show(){
	if(window.ActiveXObject){
		xmlHTTP=new ActiveXObject("Microsoft.XMLHTTP");
		}
		else if(window.XMLHttpRequest){
			xmlHTTP=new XMLHttpRequest();
		}
		xmlHTTP.open("get","http://localhost:8080/project/Showorder?", true);
		xmlHTTP.onreadystatechange=function check_status(){
		if(xmlHTTP.readyState == 4 && xmlHTTP.status == 200){
			var ans=xmlHTTP.responseText;
			ans=ans.split(',');
            document.write("ans:"+ans[1]);
            // document.getElementById("tdName").innerText= ans[0];
            // document.getElementById("tdDate").innerText= ans[1];
            // document.getElementById("tdItem").innerText= ans[2];
		}
		}
		xmlHTTP.send();
}
