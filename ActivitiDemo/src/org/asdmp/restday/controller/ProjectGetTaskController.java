package org.asdmp.restday.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.asdmp.restday.service.ProjectService;

/**
 * Servlet implementation class GetTaskController
 */
@WebServlet("/controller/projectGetTaskController")
public class ProjectGetTaskController extends HttpServlet {
	private static final long serialVersionUID = 14L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectGetTaskController() {
        super();        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ProjectService service = new ProjectService();
		String activityName = "";
		try {		
			activityName = service.getTask(service.processInstanceId);
		} catch (Exception e) {
			
		}
		System.out.println("当前任务所在节点===" + activityName);
		request.setAttribute("responseText","当前任务所在节点========"+activityName);
		request.setAttribute("fromnode",activityName);
		request.setAttribute("node",activityName);
		request.getRequestDispatcher("../jsp/projectconsole.jsp").forward(request, response); 
	}

}
