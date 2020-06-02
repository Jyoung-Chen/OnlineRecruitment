window.onload=function(){
    var op=998;
    var up=101;
    var flag=false;
    var i=1;
    var arr=new Array();
    arr[0]="../../image/login/1000.jpg";
    arr[1]="../../image/login/1001.jpg";
    arr[2]="../../image/login/1002.jpg";
    arr[3]="../../image/login/1003.jpg";
    arr[4]="../../image/login/1004.jpg";
    arr[5]="../../image/login/1005.jpg";
    arr[6]="../../image/login/1006.jpg";
    arr[7]="../../image/login/1007.jpg";
    arr[8]="../../image/login/1008.jpg";
    arr[9]="../../image/login/1009.jpg";
    var div1Node=document.getElementById("image1");
    var div2Node=document.getElementById("image2");

    setInterval(function () {
        if(flag==false) {
            op--;
            up++;
            if(op<101){
                div1Node.src=arr[i];
                i++;
                if(i>9){
                    i=0;
                }
                flag=true;
            }
        }else {
            op++;
            up--;
            if(op>998){
                div2Node.src=arr[i];
                i++;
                if(i>9){
                    i=0;
                }
                flag=false;
            }
        }
        div1Node.style.opacity = "0." + op;
        div2Node.style.opacity = "0." + up;
    },10);
}
function register() {
    var nameNode = document.getElementById("AdminNumber");
    var passNode = document.getElementById("AdminPassword");
    if (nameNode.value.length > 0 && passNode.value.length > 0) {
        return true;
    } else {
        alert("账号或密码不能为空！");
        return false;
    }
}
