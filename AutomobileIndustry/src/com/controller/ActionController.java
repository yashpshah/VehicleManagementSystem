package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.Vehicle;
import com.dao.DatabaseHandler;

/**
 * Servlet implementation class ActionController
 */
@WebServlet("/ActionController")
public class ActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ActionController() {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("insert")) {
			Vehicle vehicle=new Vehicle();
			vehicle.setYear(Integer.parseInt(request.getParameter("year")));
			vehicle.setMake(request.getParameter("make"));
			vehicle.setModel(request.getParameter("model"));
			DatabaseHandler.create(vehicle);
			response.sendRedirect("show.jsp");
		}
		else if (action.equalsIgnoreCase("edit")) {
			int id=Integer.parseInt(request.getParameter("id"));
			Vehicle vehicle=DatabaseHandler.getVehicleById(id);
			request.setAttribute("s", vehicle);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}

		else if(action.equalsIgnoreCase("update")){
			Vehicle vehicle=new Vehicle();
			vehicle.setId(Integer.parseInt(request.getParameter("id")));
			vehicle.setYear(Integer.parseInt(request.getParameter("year")));
			vehicle.setMake(request.getParameter("make"));
			vehicle.setModel(request.getParameter("model"));
			DatabaseHandler.updateVehicle(vehicle);
			response.sendRedirect("show.jsp");
		}

		else if(action.equalsIgnoreCase("delete")){
			int id=Integer.parseInt(request.getParameter("id"));
			DatabaseHandler.delete(id);
			response.sendRedirect("show.jsp");
		}
	}
}
