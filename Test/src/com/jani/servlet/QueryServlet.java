package com.jani.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jani.bean.User;
import com.jani.service.Service;
import com.jani.service.impl.ServiceImpl;
@WebServlet("/queryServlet")
public class QueryServlet extends HttpServlet{
	
	private Service service=new ServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> list=service.query();
		req.getSession().setAttribute("user", list);
		req.getRequestDispatcher("/main.jsp").forward(req, resp);
	}
	
}
