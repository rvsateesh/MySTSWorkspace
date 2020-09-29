package com.wellsfargo.fsd.JavaWeb3.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.fsd.JavaWeb3.model.VisitorModel;
import com.wellsfargo.fsd.JavaWeb3.service.VisitorService;

/**
 * Servlet implementation class VisitorServlet
 */
@WebServlet("/vs")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VisitorModel visitorModel = new VisitorModel();
		
		visitorModel.setTitle(request.getParameter("title"));
		visitorModel.setFullName(request.getParameter("fullName"));
		visitorModel.setDateOfBirth(LocalDate.parse(request.getParameter("dateOfBirth")));
		
		VisitorService visitorService = new VisitorService();
		visitorService.computeAge(visitorModel);
		String greeting = visitorService.getGreeting();
		
		request.setAttribute("msg", greeting + visitorModel.getTitle()+visitorModel.getFullName());
		request.setAttribute("age", "You are "+ visitorModel.getAge() + " yrs in age.");
		
		RequestDispatcher rd = request.getRequestDispatcher("VisitorPage.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}