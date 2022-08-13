function show(){
    if(window.ActiveXObject){
    xmlHTTP=new ActiveXObject("Microsoft.XMLHTTP");
    }
    else if(window.XMLHttpRequest){
        xmlHTTP=new XMLHttpRequest();
    }
    xmlHTTP.open("post","http://localhost:8080/project/Showorder?", true);
    xmlHTTP.onreadystatechange=function check_status(){
    if(xmlHTTP.readyState == 4 && xmlHTTP.status == 200){
        var ans=xmlHTTP.responseText;
        var item="";
        ans=ans.split(',');
        document.getElementById("tdName").innerText= ans[0];
        document.getElementById("tdDate").innerText= ans[1];
        document.getElementById("tdLoc").innerText= ans[2];
        document.getElementById("tdMail").innerText= ans[3];
        document.getElementById("tdCell").innerText= ans[4];
        document.getElementById("tdPay").innerText= ans[5];
        for(i=6; i<ans.length; i++){
            item+=ans[i];
        }
        document.getElementById("tdItem").innerText= item;
    }
    }
    xmlHTTP.send();
}