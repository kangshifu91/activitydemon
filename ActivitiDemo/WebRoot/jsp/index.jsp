<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Homepage</title>
<link href="../css/default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="wrapper">
        <jsp:include page="../include/header.jsp" /> 
            <!-- end div#header -->
            <div id="page">
                <div id="content">
                    <div id="welcome">
                        <h2></h2>
                        <!-- Fetch Rows -->
                        <center>
						Welcome to Activiti Demo!
                        </center>
                    </div>
                    <!-- end div#welcome -->
                </div>
                <!-- end div#content -->
                <div id="sidebar">
                    <!--ul-->
                    	<jsp:include page="../include/indexnav.jsp"/>
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

</body>
</html>