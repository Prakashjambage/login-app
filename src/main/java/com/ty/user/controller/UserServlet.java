package com.ty.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.user.dao.UserDao;
import com.ty.user.dto.User;

@WebServlet("/login")
public class UserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserDao userDao = new UserDao();
		User user = userDao.validateUser(email, password);
		
		if(user !=null) {
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("username", user.getName());

			RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1> Sorry invalid user name or password</h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
			
		}
		
	}
}
