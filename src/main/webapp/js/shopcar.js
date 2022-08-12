function showData(){
    if(window.ActiveXObject){
		xmlHTTP=new ActiveXObject("Microsoft.XMLHTTP");
		}
		else if(window.XMLHttpRequest){
			xmlHTTP=new XMLHttpRequest();
		}
		xmlHTTP.open("get","http://localhost:8080/project/Shopcar?", true);
		xmlHTTP.onreadystatechange=function check_status(){
		if(xmlHTTP.readyState == 4 && xmlHTTP.status == 200){
			var ans=xmlHTTP.responseText;
			ans=ans.split(',');
			document.getElementById("set1").innerText= ans[0];
			document.getElementById("set2").innerText= ans[1];
			document.getElementById("set3").innerText= ans[2];
			document.getElementById("carte1").innerText= ans[3];	
			document.getElementById("carte2").innerText= ans[4];
            document.getElementById("carte3").innerText= ans[5];
            document.getElementById("carte4").innerText= ans[6];
            document.getElementById("carte5").innerText= ans[7];
            document.getElementById("carte6").innerText= ans[8];
            document.getElementById("carte7").innerText= ans[9];
            document.getElementById("carte8").innerText= ans[10];
		}
		}
		xmlHTTP.send();
}
function ok(){
    if(window.ActiveXObject){
		xmlHTTP=new ActiveXObject("Microsoft.XMLHTTP");
		}
		else if(window.XMLHttpRequest){
			xmlHTTP=new XMLHttpRequest();
		}
		xmlHTTP.open("get","http://localhost:8080/project/Shopcar?check=ok", true);
		xmlHTTP.onreadystatechange=function check_status(){
		if(xmlHTTP.readyState == 4 && xmlHTTP.status == 200){
			var ans=xmlHTTP.responseText;
            
		}
		}
		xmlHTTP.send();
}