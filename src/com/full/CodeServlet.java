package com.full;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CodeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		int args = Integer.parseInt(req.getParameter("args"));
		String[] code = new String[1];
		ArrayList<Integer> list = new ArrayList<Integer>();
		int count = 1;
		while (args-- > 0) {
			String key = "number" + count++;
			int value = Integer.parseInt(req.getParameter(key));
			list.add(value);
		}
		if (operation.equals("add"))
			code = ResultGenerator.functionCreator(operation, 0, '+', list);
		else if (operation.equals("mul"))
			code = ResultGenerator.functionCreator(operation, 1, '*', list);
		else if (operation.equals("sub"))
			code = ResultGenerator.functionCreator(operation, 0, '-', list);
		//PrintWriter out = resp.getWriter();
		
		req.setAttribute("code", code);
		req.setAttribute("inputs", list);
		req.setAttribute("result", ResultGenerator.getOutput());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("result.jsp");
		dispatcher.forward(req, resp);
//		for (String line : code) {
//			out.println(line);
//		}
//		out.println("------------------------------------------------------------------");
//		out.println("Inputs : " + list);
//		out.println("Result : " + ResultGenerator.getOutput());
	}

}
