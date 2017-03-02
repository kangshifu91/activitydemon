<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JBPM Console</title>
<link href="../css/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
</head>
<body onload="drawworkflow()">
<div id="wrapper">
        <jsp:include page="../include/header_wide.jsp" /> 
            <!-- end div#header -->
            <div id="page_wide">
                <div id="content">
                    <div id="welcome">
                        <h2></h2>
                        <!-- Fetch Rows -->
                        <center>
                        <form id="submitform" name="submitform" method="post">
                        <input type="hidden" name="fromnode" id="fromnode" value="<%= request.getAttribute("fromnode") %>">
                        <input type="hidden" name="node" id="node" value="<%= request.getAttribute("node") %>">
                        <select name="action" id="action">
                        	<option value="approve">批准</option>
                        	<option value="reject">退回</option>
                        </select>
                        </form>
                        <img id="img1" alt="" src="../image/MyProcess.png" style="display:none">
                        <img id="img2" alt="" src="../image/MyProcess_red.png" style="display:none">
                        <%= request.getAttribute("responseText") %><br/>
						<%= request.getAttribute("fromnode") %><br/>
						<%= request.getAttribute("node") %>	<br/>
                        <canvas id="canvas" width="1100" height="500" style="background:white"></canvras>			
                        </center>
                    </div>
                    <!-- end div#welcome -->
                </div>
                <!-- end div#content -->
                <div id="sidebar">
                    <!--ul-->
                    	<jsp:include page="../include/redprocessnav.jsp"/>
                        <!-- end navigation -->
                        <jsp:include page="../include/updates.jsp"/>
                    <!--/ul-->
                </div>
                <!-- end div#sidebar -->
                <div style="clear: both; height: 1px"></div>
            </div>
            <jsp:include page="../include/footer_wide.jsp" />
        </div>
        <!-- end div#wrapper -->
<script type="text/javascript">
function drawworkflow(){
	 var ctx = $("#canvas").get(0).getContext("2d");
	 ctx.clearRect(0,0,1100,500);
	 ctx.drawImage(document.getElementById("img1"),0,0);
	 var node = "<%=request.getAttribute("node")%>";
	 var fromnode = "<%=request.getAttribute("fromnode")%>";
	 if (fromnode == "开始"&&node=="发起项目立项申请"){
		 ctx.drawImage(document.getElementById("img2"),84,99,232,57,84,99,232,57);
	 }
	 else if (fromnode == "发起项目立项申请" &&node=="综合办公室审批"){
		ctx.drawImage(document.getElementById("img2"),316,99,230,57,316,99,230,57);
	 }
	 else if (fromnode == "综合办公室审批"&&node=="发起项目立项申请"){
		ctx.drawImage(document.getElementById("img2"),209,96,495,153,209,96,495,153);
		ctx.drawImage(document.getElementById("img1"),315,95,231,60,315,95,231,60);
	 } 
	 else if (fromnode == "综合办公室审批"&&node=="结束"){
		ctx.drawImage(document.getElementById("img2"),545,100,312,46,545,100,312,46);
	 }
	 else if (fromnode == "发起项目立项申请" &&node=="发起项目立项申请"){
		ctx.drawImage(document.getElementById("img2"),210,100,105,56,210,100,105,56);
	 }
	 
	 else if (fromnode == "综合办公室审批" &&node=="综合办公室审批"){
		ctx.drawImage(document.getElementById("img2"),440,100,105,56,440,100,105,56);
	 }
}


function redprocessCreateInstance(){
	$("#submitform").attr("action","../controller/redProcessCreateInstanceController");
	$("#submitform").submit();
}

function redprocessCompleteTask(){
	$("#submitform").attr("action","../controller/redProcessCompleteTaskController");
	$("#submitform").submit();
}

</script>
</body>
</html>
