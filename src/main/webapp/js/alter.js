function show(){
    if(window.ActiveXObject){
        xmlHTTP=new ActiveXObject("Microsoft.XMLHTTP");
    } else if(window.XMLHttpRequest){
        xmlHTTP=new XMLHttpRequest();
    }
    xmlHTTP.open("get","http://localhost:8080/project/Member?", true);
    xmlHTTP.onreadystatechange=function check_status(){
        if(xmlHTTP.readyState == 4 && xmlHTTP.status == 200){
            var ans=xmlHTTP.responseText;
            ans=ans.split(',');
            document.getElementById("username").innerText= ans[0];
            document.getElementById("account").innerText= ans[1];
        }
    } 
    xmlHTTP.send();
    }
    function check(){
        passwd= document.getElementById('passwd');
        mail= document.getElementById('mail');
        phone= document.getElementById('phone');
        mailpattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
        phonepattern= /09\d{8}/;
        go= true;
        // passwd
        if(passwd.value==""){
            alert('密碼未填寫!');
            passwd.focus();
            go= false;
            return false;
        } else if(passwd.value.length<5){
            alert('密碼長度不足!');
            passwd.select();
            go= false;
            return false;
        } else{
            go= true;
        }
        // mail
        if(!mailpattern.test(mail.value)){
            alert('信箱格式錯誤!');
            mail.focus();
            go= false;
            return false;
        } else{
            go= true;
        }
        // phone
        if(!phonepattern.test(phone.value)){
            alert('電話未填寫!');
            phone.focus();
            go= false;
            return false;
        } else{
            go= true;
        }
        // submit!!
        if(go){
            alert("修改成功!");
            document.dataForm.submit();
        }
    }