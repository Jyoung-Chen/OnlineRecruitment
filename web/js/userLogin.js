$(function(){
    var url = "/WebProject/JobsServlet";
    $.post(url, {}, function (data, status) {
        var list = $.parseJSON(data);
        console.log("data = " + data);
        console.log("list = " + list);
        var tbodyNode=$("#tb");
        list.forEach(
            function (job) {
                tbodyNode.append("<tr id='"+job.jobId+"'><td>"+job.jobId+"</td><td>" + job.jobName +"</td><td>"+job.jobDemand+"</td><td>"+job.jobSalary+"</td><td>"+ job.jobHot+"</td></tr>");
            }
        );
    });
});


function register() {
    var nameNode = $("#userNumber");
    var passNode = $("#userPassword");
    if (nameNode.val().length > 0 && passNode.val().length > 0) {
        return true;
    } else {
        alert("账号或密码不能为空！");
        return false;
    }
}