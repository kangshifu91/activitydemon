package org.asdmp.restday.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.asdmp.restday.service.ProjectService;

/**
 * Servlet implementation class createInstanceController
 */
@WebServlet("/controller/projectCreateInstanceController")
public class ProjectCreateInstanceController extends HttpServlet {
	private static final long serialVersionUID = 11L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectCreateInstanceController() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		ProjectService service = new ProjectService();
		
		String procId = service.createInstance();
		request.setAttribute("responseText","流程实例ID========"+procId);
		String name = service.getCurrectActivity(procId);
		request.setAttribute("fromnode","开始");
		request.setAttribute("node",name);
		request.getRequestDispatcher("../jsp/projectconsole.jsp").forward(request, response); 
	}

}
