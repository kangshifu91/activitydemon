package org.asdmp.restday.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.asdmp.restday.service.MyProcessService;

/**
 * Servlet implementation class GetCurrectActivity
 */
@WebServlet("/controller/xengineProcessGetCurrentActivityController")
public class XengineProcessGetCurrentActivityController extends HttpServlet {
	private static final long serialVersionUID = 4L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XengineProcessGetCurrentActivityController() {
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
		try {
			MyProcessService service = new MyProcessService();
			String processInstanceId = service.processInstanceId;
			String name = "";
			try {
				name = service.getCurrectActivity(processInstanceId);
			} catch (Exception e){
				
			}
			request.setAttribute("responseText","到达节点名称========"+name);
			request.setAttribute("fromnode",name);
			request.setAttribute("node",name);
		} catch (Exception e){
			
		}
		request.getRequestDispatcher("../jsp/xengineprocessconsole.jsp").forward(request, response); 
	}

}
