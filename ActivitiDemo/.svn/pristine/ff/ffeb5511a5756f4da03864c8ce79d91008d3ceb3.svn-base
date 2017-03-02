<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JBPM Console</title>
<link href="../css/default.css" rel="stylesheet" type="text/css" />
<script charset='utf-8' type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
<script charset='utf-8' type="text/javascript" src="../xengine/xcore.js"></script>
<script charset='utf-8' type="text/javascript" src="../xengine/xutil.js"></script>
<script charset='utf-8' type="text/javascript" src="../xengine/xevent.js"></script>
<script charset='utf-8' type="text/javascript" src="../xengine/xsys.js"></script>
<script charset='utf-8' type="text/javascript" src="../xengine/xrenderobj.js"></script>
<script charset='utf-8' type="text/javascript" src="../xengine/xscene.js"></script>
<script charset='utf-8' type="text/javascript" src="../xengine/xscenemanager.js"></script>
<script charset='utf-8' type="text/javascript" src="../xengine/xapp.js"></script>
<script charset='utf-8' type="text/javascript" src="../js/ball.js"></script>
<script charset='utf-8' type="text/javascript" src="../js/Rectangle.js"></script>
<script charset='utf-8' type="text/javascript" src="../js/RoundCornerRectangle.js"></script>
</head>
<body>
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
                    	<jsp:include page="../include/xengineprocessnav.jsp"/>
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
 var g = new Game();
 var fromnode0 = "<%= request.getAttribute("fromnode") %>";
 var node0 = "<%= request.getAttribute("node") %>";
 function initGame()
 {
   var scm = g.sceneManager; 
   var sc = scm.createScene([{"name":"title","x":20,"y":200,"w":860,"h":323}]);
   sc.setBGImg("../image/MyProcess.png",1);
   initRenderObj(sc,fromnode0,node0);
 }

 function initRenderObj(sc,fromnode,node)
 {
	 var obj = sc.createRObj(Ball.ClassName);
	 obj.setNodes(fromnode,node);
	 var obj3 = sc.createRObj(RoundCornerRectangle.ClassName);
	 obj3.isVisible = false;
	 if (node0=="综合办公室审批"){
 	 	obj3.config(440,100,105,55,12);
 		obj.setRect(obj3);
 		obj.setShowRect(false);
	 }else if (node0 == "发起项目立项申请"){
		obj3.config(210,100,105,55,12);
		obj.setRect(obj3);
		obj.setShowRect(false);
	 }
}

function xengineprocessCreateInstance(){
	$("#submitform").attr("action","../controller/xengineProcessCreateInstanceController");
	$("#submitform").submit();
}

function xengineprocessCompleteTask(){
	$("#submitform").attr("action","../controller/xengineProcessCompleteTaskController");
	$("#submitform").submit();
}

	
initGame();
g.run(50);
</script>
</body>
</html>
