function print_99_1() {
    document.write("<table border='1'>");
    for (var i = 1; i <=9; i++) {
        document.write("<tr>");
        for (var j = 1; j <=i; j++) {
            document.write("<td>"+j+"×"+i+"="+i*j+"</td>");
        }
        document.write("<tr>");
    }
    document.write("</table>");
}
function print_99_2(){
    for (var i = 1; i <=9; i++) {
        for (var j = 1; j <=i; j++) {
            document.write(+j+"×"+i+"="+i*j+" "+"&nbsp");
        }
        document.write("<br>");
    }
}

function print_2() {
    document.getElementById("asd").innerHTML=asdasd;
}
$(function () {
    alert("2");
});
function register() {
    var nameNode = document.getElementById("userNumber");
    var passNode = document.getElementById("userPassword");
    var tispNode = document.getElementById("TisPassword");
    var tisnNode = document.getElementById("TisNumber");
    var divnNode = document.getElementById("div_number");
    if (nameNode.value.length > 0 && passNode.value.length > 0) {
        return true;
    } else {
        if (nameNode.value.length == 0) {
            tisnNode.style.display = "block";
            divnNode.style.border=" solid 2px red";
        }else{
            tisnNode.style.display = "none";
            divnNode.style.border=" solid 1px #aaaaaa"
        }
        if (passNode.value.length == 0) {
            tispNode.style.display = "block";
        }else{
            tispNode.style.display = "none";
        }
        return false;
    }
}
//window.onload=function ()
function gaga(){
    var x=innerWidth;
    var y=innerHeight;
    var removex=0;
    var removey=0;
    var flag=false;
    var flag1=false;
    setInterval(function () {
        if(flag==false){
            removex++;
            var divNode=document.getElementById("div1");
            divNode.style.left=removex+"px";
            if (removex==(x-200)){
                flag=true;
            }
        }else {
            removex--;
            var divNode=document.getElementById("div1");
            divNode.style.left=removex+"px";
            if (removex==(0)){
                flag=false;
            }
        }
        if(flag1==false){
            removey++;
            var divNode=document.getElementById("div1");
            divNode.style.top=removey+"px";
            if (removey==(y-200)){
                flag1=true;
            }
        }else {
            removey--;
            var divNode=document.getElementById("div1");
            divNode.style.top=removey+"px";
            if (removey==(0)){
                flag1=false;
            }
        }
    },3)
}

function ff(){
    var op=900;
    var up=101;
    var flag=false;
    var div1Node=document.getElementById("image1");
    var div2Node=document.getElementById("image2");
    setInterval(function () {
        if(flag==false) {
            op--;
            up++;
            if(op<101){
                flag=true;
            }
        }else {
            op++;
            up--;
            if(op>900){
                flag=false;
            }
        }
        div1Node.style.opacity = "0." + op;
        div2Node.style.opacity = "0." + up;
    },10);
}

