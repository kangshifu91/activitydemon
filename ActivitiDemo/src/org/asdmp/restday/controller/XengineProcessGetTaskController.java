package org.asdmp.restday.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.asdmp.restday.service.MyProcessService;

/**
 * Servlet implementation class GetTaskController
 */
@WebServlet("/controller/xengineProcessGetTaskController")
public class XengineProcessGetTaskController extends HttpServlet {
	private static final long serialVersionUID = 5L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XengineProcessGetTaskController() {
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
		MyProcessService service = new MyProcessService();
		String activityName = "";
		try {		
			activityName = service.getTask(service.processInstanceId);
		} catch (Exception e) {
			
		}
		System.out.println("当前任务所在节点===" + activityName);
		request.setAttribute("responseText","当前任务所在节点========"+activityName);
		request.setAttribute("fromnode",activityName);
		request.setAttribute("node",activityName);
		request.getRequestDispatcher("../jsp/xengineprocessconsole.jsp").forward(request, response); 
	}

}
