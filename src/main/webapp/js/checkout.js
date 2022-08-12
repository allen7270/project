function check(){
    username= document.getElementById('username');
    loc= document.getElementById('loc');
    mail= document.getElementById('mail');
    phone= document.getElementById('phone');
    mailpattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    phonepattern= /09\d{8}/;
    go= true;
    // username
    if(username.value==""){
        alert('名字未填寫!');
        username.focus();
        go= false;
        return false;
    } else{
        go= true;
    }
    // location
    if(loc.value==""){
        alert('地址未填寫!');
        loc.focus();
        go= false;
        return false;
    } else{
        go= true;
    }
    mail
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
		alert("訂餐成功!");
        document.dataForm.submit();
    }
}