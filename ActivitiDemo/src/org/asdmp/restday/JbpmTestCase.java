package org.asdmp.restday;
import junit.framework.TestCase;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JbpmTestCase extends TestCase {
	
	protected RepositoryService repositoryService;
	
	protected RuntimeService executionService;
	
	protected TaskService taskService ;
	
	protected HistoryService historyServcie;
	
	
	protected ManagementService managermentService;
	
	protected IdentityService identityService; 	
	protected ProcessEngine processEngine;
	
	protected ClassPathXmlApplicationContext applicationContext;
	
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
}
