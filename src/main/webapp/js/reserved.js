function check(){
    go= true;
    dateC= document.getElementById("dateC").value;
    timeC= document.getElementById("timeC").value;
    numberC= document.getElementById("numberC").value;
    // --
    dateG= document.getElementById("dateG").value;
    timeG= document.getElementById("timeG").value;
    numberG= document.getElementById("numberG").value;
    // --
    dateL= document.getElementById("dateL").value;
    timeL= document.getElementById("timeL").value;
    numberL= document.getElementById("numberL").value;

    if(!dateC.length==0||!dateG.length==0||!dateL.length==0){
        go= true;
    } else{
        alert("用餐日期未選取!");
        go= false;
        return false;
    }
    if(!timeC.length==0||!timeG.length==0||!timeL.length==0){
        go= true;
    } else{
        alert("用餐時間未選取!");
        go= false;
        return false;
    }
    if(!numberC.length==0||!numberG.length==0||!numberL.length==0){
        go= true;
    } else{
        alert("用餐人數未填寫!");
        go= false;
        return false;
    }

    if(go==true){
        alert("預約成功!");
        document.reservedForm.submit()
    }
}