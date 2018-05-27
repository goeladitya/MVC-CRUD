package com.bmpl.crud.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmpl.crud.dao.ProductDAO;
import com.bmpl.crud.dto.ProductDTO;


@WebServlet("/deleteData")
public class deleteData extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ProductDAO productDAO= new ProductDAO();
		try{
			String del= request.getParameter("del");
			productDAO.deleteData(del);
			ArrayList<ProductDTO> productList = productDAO.getProducts();
			request.setAttribute("prodlist", productList);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
