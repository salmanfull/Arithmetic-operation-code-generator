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
		String operation = req.getParameter("operator");
		int args = Integer.parseInt(req.getParameter("numberOfInputs"));
		String[] code = null;
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
		else if (operation.equals("div"))
			code = ResultGenerator.functionCreatorForDiv(list.get(0), list.get(1));

		req.setAttribute("code", code);
		req.setAttribute("inputs", list);
		req.setAttribute("result", ResultGenerator.getOutput());

		RequestDispatcher dispatcher = req.getRequestDispatcher("result.jsp");
		dispatcher.forward(req, resp);

	}

}
