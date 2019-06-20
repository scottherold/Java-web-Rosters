package com.sherold.web.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sherold.web.models.Roster;
import com.sherold.web.models.Team;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instantiates session if it does not exist
		HttpSession session = request.getSession(false);

		// if no session, create session and instantiate new roster object
		if (session == null) {
			// Instantiate a new session
			session = request.getSession();
			
			// Instantiates a new roster
			Roster r = new Roster();
			
			// Adds roster to session
			session.setAttribute("roster", r);
				
			// Sets the Roster as the model for the view
			request.setAttribute("roster", r);
			
			// else use roster data from session and pass as model to the view
		} else {
			// Instantiates the Roster from session
			Roster r = (Roster) session.getAttribute("roster");
			
			// Sets the Roster as the model for the view
			request.setAttribute("roster", r);			
		}
		
		// Let the view handle the request
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Index.jsp");
		view.forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instantiates session
		HttpSession session = request.getSession();
		
		// Instantiates new Team object with the submitted team_name
		Team t = new Team(request.getParameter("team_name"));
		
		// Instantiates the Roster from session
		Roster r = (Roster) session.getAttribute("roster");
		
		// Instantiates the teams ArrayList from Roster
		ArrayList<Team> rTeams = r.getTeams();
		
		// Adds new to to Roster list
		rTeams.add(t);
		
		// Sets the roster for r
		r.setTeams(rTeams);
		
		// Overwrites session roster with new roster
		session.setAttribute("roster", r);
		
		// Let the view handle the request
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Index.jsp");
		view.forward(request,  response);
	}

}
