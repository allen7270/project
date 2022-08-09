function verify(){
    account= document.getElementById('account');
    passwd= document.getElementById('passwd');
    go= true;
    if(account.value==""){
        alert("帳號未輸入!");
        account.focus();
        go= false;
        return false;
    } else{
        go =true;
    }
    if(passwd.value==""){
        alert("密碼未輸入!");
        passwd.focus();
        go= false;
        return false;
    } else{
        go =true;
    }
    if(go==true){
        document.loginDataForm.submit();
    }
}