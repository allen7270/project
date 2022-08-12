function showData(){
    if(window.ActiveXObject){
		xmlHTTP=new ActiveXObject("Microsoft.XMLHTTP");
		}
		else if(window.XMLHttpRequest){
			xmlHTTP=new XMLHttpRequest();
		}
		xmlHTTP.open("post","http://localhost:8080/project/Payment?show=yes", true);
		xmlHTTP.onreadystatechange=function check_status(){
		if(xmlHTTP.readyState == 4 && xmlHTTP.status == 200){
			var ans=xmlHTTP.responseText;
			document.getElementById("total").innerText= ans;
		}
		}
		xmlHTTP.send();
}
function ok(){
    document.dataForm.submit();
    alert("訂餐成功");
}