function show(){
    if(window.ActiveXObject){
        xmlHTTP=new ActiveXObject("Microsoft.XMLHTTP");
    }
    else if(window.XMLHttpRequest){
        xmlHTTP=new XMLHttpRequest();
    }
    xmlHTTP.open("get","http://localhost:8080/project/Root?punch=null", true);
    xmlHTTP.onreadystatechange=function check_status(){
    if(xmlHTTP.readyState == 4 && xmlHTTP.status == 200){
        var ans=xmlHTTP.responseText;
        ans=ans.split(',');
        document.getElementById("username").innerText= ans[0];
        document.getElementById("account").innerText= ans[1];
        document.getElementById("passwd").innerText= ans[2];
        document.getElementById("mail").innerText= ans[3];	
        document.getElementById("phone").innerText= ans[4];
        document.getElementById("date").innerText= ans[5];
        document.getElementById("in").innerText= ans[6];
        document.getElementById("out").innerText= ans[7];
    }
    }
    xmlHTTP.send();
}
function punch(){
	alert("打卡成功!");
    if(window.ActiveXObject){
        xmlHTTP=new ActiveXObject("Microsoft.XMLHTTP");
    }
    else if(window.XMLHttpRequest){
        xmlHTTP=new XMLHttpRequest();
    }
    xmlHTTP.open("get","http://localhost:8080/project/Root?punch=true", true);
    xmlHTTP.onreadystatechange=function check_status(){
    if(xmlHTTP.readyState == 4 && xmlHTTP.status == 200){
        var ans=xmlHTTP.responseText;
        ans=ans.split(',');
        document.getElementById("username").innerText= ans[0];
        document.getElementById("account").innerText= ans[1];
        document.getElementById("passwd").innerText= ans[2];
        document.getElementById("mail").innerText= ans[3];	
        document.getElementById("phone").innerText= ans[4];
        document.getElementById("date").innerText= ans[5];
        document.getElementById("in").innerText= ans[6];
        document.getElementById("out").innerText= ans[7];
    }
    }
    xmlHTTP.send();
}