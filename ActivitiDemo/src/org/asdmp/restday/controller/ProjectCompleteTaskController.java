package org.asdmp.restday.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.asdmp.restday.service.ProjectService;

/**
 * Servlet implementation class CompleteTaskController
 */
@WebServlet("/controller/projectCompleteTaskController")
public class ProjectCompleteTaskController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectCompleteTaskController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HtrtpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ProjectService service = new ProjectService();
		String current = request.getParameter("node");
		String action =  request.getParameter("action");
		String name2 ="结束";
		try {
			service.completeTask(current,action);
			service.print("Jerry", "complete");
			name2 = service.getCurrectActivity(service.processInstanceId);
			
			request.setAttribute("fromnode",current);
			request.setAttribute("node",name2);
			request.setAttribute("responseText","Jerry========Complete");
			System.out.println("fromnode========"+current);
			System.out.println("node========"+name2);
			System.out.println("Jerry========Complete");
		} catch(Exception e){
			//e.printStackTrace();
			name2 = "结束";
			
			request.setAttribute("fromnode",current);
			request.setAttribute("node",name2);
			request.setAttribute("responseText","Jerry========Complete");
			System.out.println("fromnode========"+current);
			System.out.println("node========"+name2);
			System.out.println("Jerry========Complete");
		}

		request.getRequestDispatcher("../jsp/projectconsole.jsp").forward(request, response); 
	}

}

