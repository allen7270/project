function check(){
    // set
    set1= document.getElementById('set1').value;
    set2= document.getElementById('set2').value;
    set3= document.getElementById('set3').value;
    // carte
    carte1= document.getElementById('carte1').value;
    carte2= document.getElementById('carte2').value;
    carte3= document.getElementById('carte3').value;
    carte4= document.getElementById('carte4').value;
    carte5= document.getElementById('carte5').value;
    carte6= document.getElementById('carte6').value;
    carte7= document.getElementById('carte7').value;
    carte8= document.getElementById('carte8').value;
    if(!set1.length==0||!set2.length==0||!set3.length==0||!carte1.length==0||!carte2.length==0||!carte3.length==0||!carte4.length==0||!carte5.length==0||!carte6.length==0||!carte7.length==0||!carte8.length==0){
        document.orderForm.submit();
        alert("點餐成功");
    } else{
        alert("份數未填寫!");
    }
}