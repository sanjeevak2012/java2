package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		
		System.out.println(name+" : "+password);
		
		out.println("<html><body bgcolor=cyan>");
		
		int rows = DbUtil.login( name,  password) ;
		
		if(rows!=0) {
			out.println("<h1>Hi "+name+"!  Welcome to the site</h1><br/>");
			out.println("<H2>You can browse the contents......</h2>");
		}else {
			out.println("<h1>Hi "+name+"!  Login Failed. please register.</h1><br/>");
			out.println("<a href=register.html>Register</a>");
		}
		
		
		
		out.println("</body></html>");
		
	}

}
