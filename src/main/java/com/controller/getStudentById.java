package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Student;
import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;


@WebServlet("/getStudentById")
public class getStudentById extends HttpServlet {
	
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        int id=Integer.parseInt(request.getParameter("id"));

	        StudentDAO dao = new StudentDAOImpl();
	        Student student = dao.getStudentById(id);

	        if (student != null) {
	            out.print("<h1>Student Details</h1>");
	            out.print("<p>ID: " + student.getId() + "</p>");
	            out.print("<p>Name: " + student.getName() + "</p>");
	            out.print("<p>Marks: " + student.getMarks() + "</p>");
	        } else {
	            out.print("<h1>No student found with ID: " + id + "</h1>");
	        }
	}

}
