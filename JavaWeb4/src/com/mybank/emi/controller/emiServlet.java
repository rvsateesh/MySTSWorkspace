package com.mybank.emi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybank.emi.model.EmiModel;
import com.mybank.emi.service.EmiService;

/**
 * Servlet implementation class emiServlet
 */
@WebServlet("/EmiCalc")
public class emiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmiModel emiModel = new EmiModel();
		emiModel.setPrinciple(Double.parseDouble(request.getParameter("principle")));
		emiModel.setRoi(Double.parseDouble(request.getParameter("roi")));
		emiModel.setTerm(Integer.parseInt(request.getParameter("term")));
		
		EmiService es = new EmiService();
		es.EmiCalculator(emiModel);
		request.setAttribute("emi", "Your EMI is " + emiModel.getEmi());
		
		RequestDispatcher rd = request.getRequestDispatcher("EmiCalculator.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
