package org.asdmp.restday.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.asdmp.restday.ProjectDecision;

public class ProjectService{
	public static RepositoryService repositoryService;
	
	public static RuntimeService executionService;
	
	public static TaskService taskService ;
	
	public static HistoryService historyServcie;
	
	
	public static ManagementService managermentService;
	
	public static IdentityService identityService; 	
	public static ProcessEngine processEngine;
	
	public static String processInstanceId;

	public void deploy() {
		startUp();
		//repositoryService.createDeployment().addResourceFromClasspath("project.jpdl.xml").deploy();
		repositoryService.createDeployment().addClasspathResource("Project.bpmn").deploy();
		print("Jerry", "deloy");
	}

	public String createInstance() {
		startUp();
		ProcessInstance processInstance = executionService.startProcessInstanceByKey("project");
		processInstanceId = processInstance.getId();
		print("流程实例ID",processInstanceId);
		return processInstanceId;
	}

	public String getCurrectActivity(String processInstanceId) {
		startUp();
		//String name = executionService.createExecutionQuery().processInstanceId(processInstanceId).list().get(0).toString();
		String name = taskService.createTaskQuery().processInstanceId(processInstanceId).list().get(0).getName();
		return name;
	}

	public String getTask(String processInstanceId){
		startUp();
		String activityName = taskService.createTaskQuery().list().get(0).getName();
		return activityName;
	}
	
	public void completeTask(String node,String action) {
		startUp();
		List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstanceId).list();
		Task task = tasks.get(0);
		print("tasksize", tasks.size());
		Map<String,Object> map = new HashMap<String, Object>();
		ProjectDecision projectDecision = new ProjectDecision();
		projectDecision.setAction(action);
		map.put("projectDecision", projectDecision);
		taskService.complete(task.getId(), map);
		print("Jerry",action);
		print("Jerry", "complete");
	}
	
	public static void startUp(){
		processEngine = ProcessEngines.getDefaultProcessEngine();
		repositoryService = processEngine.getRepositoryService();
		executionService = processEngine.getRuntimeService();
		taskService = processEngine.getTaskService();
		historyServcie = processEngine.getHistoryService();
		managermentService = processEngine.getManagementService();
		identityService = processEngine.getIdentityService();
	}
	
	public void print(String name,String value){
		System.out.println(name + "=============" + value);
	}
	
	public void print(String name,int value){
		System.out.println(name + "=============" + value);
	}
}
