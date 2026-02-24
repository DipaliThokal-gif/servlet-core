package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;
import com.model.Student;

@WebServlet("/StudentUpdateForm")
public class StudentUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentUpdateForm() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));

		StudentDAO dao = new StudentDAOImpl();  // you should overrid init

		Student student = dao.getStudentById(id);

		out.print("<form action='StudentUpdateServlet' method='get'>");

		out.print("<input type='text' name='id' value='" + student.getId() + "'>");
		out.print("<input type='text' name='name' value='" + student.getName() + "'>");
		out.print("<input type='text' name='marks' value='" + student.getMarks() + "'>");

		out.print("<input type='submit' value='UPADTE'>");
		out.print("</form>");

	}
}
