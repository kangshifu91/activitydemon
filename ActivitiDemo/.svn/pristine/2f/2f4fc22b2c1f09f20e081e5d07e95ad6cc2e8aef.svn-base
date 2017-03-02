<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Activiti Console</title>
<link href="../css/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
</head>
<body onload="drawworkflow()">
<div id="wrapper">
        <jsp:include page="../include/header.jsp" /> 
            <!-- end div#header -->
            <div id="page">
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
                        <img id="img1" alt="" src="../image/project.png" style="display:none">
                        <%= request.getAttribute("responseText") %><br/>
						<%= request.getAttribute("fromnode") %><br/>
						<%= request.getAttribute("node") %>	<br/>
                        <canvas id="canvas" width="650" height="500" style="background:white"></canvras>			
                        </center>
                    </div>
                    <!-- end div#welcome -->
                </div>
                <!-- end div#content -->
                <div id="sidebar">
                    <!--ul-->
                    	<jsp:include page="../include/projectnav.jsp"/>
                        <!-- end navigation -->
                        <jsp:include page="../include/updates.jsp"/>
                    <!--/ul-->
                </div>
                <!-- end div#sidebar -->
                <div style="clear: both; height: 1px"></div>
            </div>
            <jsp:include page="../include/footer.jsp" />
        </div>
        <!-- end div#wrapper -->
<script type="text/javascript">
function drawworkflow(){
	 var node = "<%=request.getAttribute("node")%>";
	 var fromnode = "<%=request.getAttribute("fromnode")%>";
	 if (fromnode == "项目审核"&&node=="退回申请人"){
		 var intervalID = drawSection("项目审核","exclusive1");		 
		 var t=setTimeout(function(){
			 clearInterval(intervalID);
			 drawSection("exclusive1","退回申请人");
			},5000);
	 } else {
		drawSection(fromnode,node);
	}
}

function drawSection(fromnode,node){
	var startx;
	var starty;
	var endx;
	var endy;
	var rectx=0;
	var recty=0;
	var drawRect = false;
	if (fromnode=="开始"){
		startx = 30 + 35/2;
		starty = 170 + 35/2;
	} else if (fromnode=="项目审核"){
		startx = 160 + 105/2 + 40;
		starty = 160 + 55/2;		
	} else if (fromnode=="退回申请人"){
		startx = 348 + 105/2 + 40;
		starty = 320 + 55/2;
	}  else if (fromnode=="exclusive1"){
		startx = 380 + 40/2 ;
		starty = 167 + 40/2;
	}
	
	if (node=="结束"){
		endx = 560 + 35/2;
		endy = 170 + 35/2;
	} else if (node=="项目审核"){
		endx = 160 + 105/2 + 40;
		endy = 160 + 55/2;		
		rectx=160;
		recty=160;
		drawRect = true;
	} else if (node=="退回申请人"){
		endx = 348 + 105/2 + 40;
		endy = 320 + 55/2;
		rectx=348;
		recty=320;
		drawRect = true;
	}  else if (node=="exclusive1"){
		endx = 380 + 40/2 ;
		endy = 167 + 40/2;
	}
	
	if (fromnode== "null"){
		startx = endx;
		starty = endy;
	}
	return animi(startx,starty,endx,endy,rectx,recty,drawRect);
}

function drawcircle(x,y){
	var ctx= document.getElementById("canvas").getContext("2d");
	ctx.fillStyle="#FF0000";
	//ctx.strokeStyle="blue";
	ctx.beginPath();
	ctx.arc(x,y,10,0,Math.PI*2,true);
	ctx.closePath();
	ctx.fill();
	//ctx.stroke();
}

function projectcreateInstance(){
	$("#submitform").attr("action","../controller/projectCreateInstanceController");
	$("#submitform").submit();
}

function projectcompleteTask(){
	$("#submitform").attr("action","../controller/projectCompleteTaskController");
	$("#submitform").submit();
}

//开始
function animi(startx,starty,endx,endy,rectx, recty,showRect)
{
	var stepx = (endx-startx)/100;
	var stepy = (endy-starty)/100;
	var frameindex = 0;
 	//获取canvas上下文
	  var ctx = $("#canvas").get(0).getContext("2d");
	  var tId = setInterval(function(){ 
		     //先清空画布
		     if (endx==1000||startx==1000) {
		    	 ctx.drawImage(document.getElementById("img1"),0,0);
		    	 return;
		     }
			 ctx.clearRect(0,0,650,500);
			 ctx.drawImage(document.getElementById("img1"),0,0);
		     drawcircle(startx+frameindex*stepx,starty+frameindex*stepy);		     
		     if (frameindex==100) {
		    	 if (showRect){
			    	 var myrect = new Rect(rectx,recty,105,55);
			    	 roundRectanglePath(ctx,myrect,12);
		    	 }
		    	 return;
		     }
		     frameindex++;
		  },50);
	  return tId;
}

function roundRectanglePath(context,rect,radius)
{
	context.strokeStyle="red";
	context.lineWidth=3;
	
    context.beginPath();
    context.moveTo( rect.getX()+radius,rect.getY() );
    context.lineTo( rect.getRight()-radius,rect.getY() );
    context.arc( rect.getRight()-radius,rect.getY()+radius, radius, 3*Math.PI/2,2*Math.PI, false);
    context.lineTo( rect.getRight(),rect.getBottom()-radius);
    context.arc( rect.getRight()-radius,rect.getBottom()-radius, radius, 0, Math.PI/2, false);
    context.lineTo( rect.getX()+radius,rect.getBottom() );
    context.arc( rect.getX()+radius,rect.getBottom()-radius, radius, Math.PI/2, Math.PI, false);
    context.lineTo( rect.getX(),rect.getY()+radius);
    context.arc( rect.getX()+radius,rect.getY()+radius, radius,Math.PI, 3*Math.PI/2, false);
    context.closePath();
    context.stroke();
}

function Rect(x,y,width,height)
{
    this.x = x;
    this.y = y;
    this.width = width;
    this.height= height;
}

Rect.prototype.getX = function()
{
    return this.x;
};

Rect.prototype.getY = function()
{
    return this.y;
};

Rect.prototype.getWidth = function()
{
    return this.width;
};

Rect.prototype.getHeight = function()
{
    return this.height;
};

Rect.prototype.getLeft = function()
{
    return this.x;
};

Rect.prototype.getTop = function()
{
    return this.y;
};

Rect.prototype.getRight = function()
{
    return (this.x + this.width);
};

Rect.prototype.getBottom = function()
{
    return (this.y + this.height);
};
</script>
</body>
</html>
