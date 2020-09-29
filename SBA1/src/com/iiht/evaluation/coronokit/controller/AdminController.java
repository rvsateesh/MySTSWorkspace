package com.iiht.evaluation.coronokit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiht.evaluation.coronokit.dao.AdminDao;
import com.iiht.evaluation.coronokit.dao.ConnectionFactory;
import com.iiht.evaluation.coronokit.dao.ProductMasterDao;
import com.iiht.evaluation.coronokit.exception.ServiceException;
import com.iiht.evaluation.coronokit.model.ProductMaster;
import com.iiht.evaluation.coronokit.service.AdminService;
import com.iiht.evaluation.coronokit.service.AdminServiceImpl;

@WebServlet({"/admin","/list"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDao adminDao;
	private AdminService adminService;

	@Override
	public void init() throws ServletException {
		adminService = new AdminServiceImpl(adminDao);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action =  request.getParameter("action");
		String viewName = "";
		try {
			switch (action) {
			case "login" : 
				viewName = adminLogin(request, response);
				break;
			case "newproduct":
				viewName = showNewProductForm(request, response);
				break;
			case "insertproduct":
				viewName = insertProduct(request, response);
				break;
			case "deleteproduct":
				viewName = deleteProduct(request, response);
				break;
			case "editproduct":
				viewName = showEditProductForm(request, response);
				break;
			case "updateproduct":
				viewName = updateProduct(request, response);
				break;
			case "list":
				viewName = listAllProducts(request, response);
				break;	
			case "logout":
				viewName = adminLogout(request, response);
				break;	
			default : viewName = "notfound.jsp"; break;		
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		RequestDispatcher dispatch = 
					request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);
		
		
	}

	private String adminLogout(HttpServletRequest request, HttpServletResponse response) {		
		return "index.jsp";
	}

	private String listAllProducts(HttpServletRequest request, HttpServletResponse response) {
		String view = "";

		try {
			List<ProductMaster> products = adminService.getAllProducts();
			request.setAttribute("products", products);
			view = "listproducts.jsp";
		} catch (ServiceException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errPage.jsp";
		}

		return view;
	}

	private String updateProduct(HttpServletRequest request, HttpServletResponse response) {
		int pid = Integer.parseInt(request.getParameter("pid"));
		String view = "";

		try {
			ProductMaster product = adminService.getProduct(pid);
			request.setAttribute("product", product);
			view = "editproduct.jsp";
		} catch (ServiceException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errPage.jsp";
		}

		return view;
	}

	private String showEditProductForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String deleteProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String insertProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String showNewProductForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String adminLogin(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		if(request.getParameter("loginid") == "admin" && request.getParameter("password") == "admin") {view = "listproducts.jsp";}
		else view = "listproducts.jsp";
		return view;
		
	}

	
}