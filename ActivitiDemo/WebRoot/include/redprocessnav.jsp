<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Common Navigation Panel for our site -->
<li id="submenu">
    <h2>Menu</h2>
    <ul>
        <li><a href="../jsp/index.jsp">Homepage</a></li>
		<li><a href="../jsp/projectconsole.jsp">Project Demo</a></li>
		<li><a href="../jsp/myprocessconsole.jsp">Process Demo</a></li>
		<li><a href="../jsp/xengineprocessconsole.jsp">XEngine Process Demo</a></li>
		<li><a href="../jsp/redprocessconsole.jsp">Red Line Process Demo</a></li>
        <li><a href="../controller/redProcessDeployController">部署</a></li>
        <li><a href="javascript:redprocessCreateInstance();">创建实例</a></li>
        <li><a href="../controller/redProcessGetCurrentActivityController">当前节点</a></li>
        <li><a href="../controller/redProcessGetTaskController">当前工作</a></li>
        <li><a href="javascript:redprocessCompleteTask();">完成工作</a></li>
    </ul>
</li>