package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String address = request.getParameter("addr");
		int age = Integer.parseInt(request.getParameter("age"));
		String profession = request.getParameter("proff");
		
		
		int rows = DbUtil.register(name,password,address, age, profession);
		
		 out.println("<html><body bgcolor=cyan>");
		if(rows!= 0) {
       
	     	out.println("<h1>Hi "+name+"!  You are registered.</h1><br/>");
			
			out.println("<H2>Please login to browse the contents......</h2>");
			out.println("<a href=\"login.html\">Login</a><br>");
		}else {
			out.println("<h1>Hi "+name+"!  Registration failed. Please contact administration.</h1><br/>");
		}
		out.println("</body></html>");
		
		
		System.out.println("name: "+name);
		System.out.println("password: "+password);
		System.out.println("address: "+address);
		System.out.println("age: "+age);
		System.out.println("profession: "+profession);
		
	}

}
