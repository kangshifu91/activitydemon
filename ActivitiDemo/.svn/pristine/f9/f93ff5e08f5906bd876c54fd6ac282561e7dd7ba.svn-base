package test.asdmp.restday;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RestDayTest extends TestCase {
	protected RepositoryService repositoryService;
	
	protected RuntimeService executionService;
	
	protected TaskService taskService ;
	
	protected HistoryService historyServcie;
	
	
	protected ManagementService managermentService;
	
	protected IdentityService identityService; 	
	protected ProcessEngine processEngine;
	
	protected ClassPathXmlApplicationContext applicationContext;
	
	protected static String processInstanceId;

	@Test
	public void testdeploy() {
		startUp();
		//repositoryService.createDeployment().addResourceFromClasspath("restday.jpdl.xml").deploy();
		print("Jerry", "deloy");
	}

	@Test
	public void testcreateInstance() {
		startUp();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("to", "部长");
		ProcessInstance processInstance = executionService.startProcessInstanceByKey("restday", map);		
		processInstanceId = processInstance.getId();
		print("流程实例ID",processInstanceId);
	}

	@Test
	public void testgetCurrectActivity() {
		startUp();
		//String name = executionService.createProcessInstanceQuery().processInstanceId(processInstanceId).uniqueResult().findActiveActivityNames().toString();
		//print("到达节点名称",name);
	}

	@Test
	public void testgetTask() {
		startUp();
		//String activityName = executionService.createProcessInstanceQuery().processInstanceId(processInstanceId).uniqueResult().findActiveActivityNames().toString();
		//System.out.println("当前任务所在节点===" + activityName);
	}
	
	@Test
	public void testcompleteTask() {
		startUp();
//		List<Task> tasks = taskService.findPersonalTasks("部长");
//		print("tasksize", tasks.size());
//		taskService.completeTask(tasks.get(0).getId());
		print("Jerry", "complete");
	}
	
	protected void startUp(){
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		applicationContext.start();
		processEngine = (ProcessEngine)applicationContext.getBean("processEngine");
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

	@Test
	public void testMyTest() {
		Assert.assertTrue(true);
	}
}
