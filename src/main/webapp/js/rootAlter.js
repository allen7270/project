function check(){
    passwd= document.getElementById('passwdIn');
    mail= document.getElementById('mailIn');
    phone= document.getElementById('phoneIn');
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
        document.data.submit();
    }
}