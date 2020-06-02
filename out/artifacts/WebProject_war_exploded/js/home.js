var flag=1;
function sf() {
    var div1=document.getElementById("qiye1");
    if(flag==1){
        div1.style.display="block";
        flag=0;
    }else{
        div1.style.display="none";
        flag=1;
    }
}
function menuOnClick(node) {
    var divNode = document.getElementById("aside");
    var childDivArr = divNode.getElementsByTagName("div");

    var showDiv = node.nextSibling;

    for (var i = 0; i < childDivArr.length; i++) {
        if (childDivArr[i] === showDiv) {
            // 如果点击的是这个div上面的h2，就打开这个div
            childDivArr[i].style.display = "block";
        } else {
            // 否则就关闭这个div
            childDivArr[i].style.display = "none";
        }
    }
}