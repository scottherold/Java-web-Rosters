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

import com.sherold.web.models.Player;
import com.sherold.web.models.Roster;
import com.sherold.web.models.Team;

/**
 * Servlet implementation class Players
 */
@WebServlet("/Players")
public class Players extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instantiates session
		HttpSession session = request.getSession();
		
		// Instantiates the Roster from session
		Roster r = (Roster) session.getAttribute("roster");
		
		// Instantiates the teams ArrayList from Roster
		ArrayList<Team> rTeams = r.getTeams();
		
		// Grabs Team object from ArrayList using the form data
		Team t = rTeams.get(Integer.parseInt(request.getParameter("id")));
		
		// Sets the Team as the model for the view
		request.setAttribute("team", t);
		request.setAttribute("index", Integer.parseInt(request.getParameter("id")));
		
		// Let the view handle the request
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/NewPlayer.jsp");
		view.forward(request,  response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instantiates session
		HttpSession session = request.getSession();
		
		// Instantiates the Roster from session
		Roster r = (Roster) session.getAttribute("roster");
		
		// Instantiates the teams ArrayList from Roster
		ArrayList<Team> rTeams = r.getTeams();
		
		// Instantiates new Player object with the submitted form information
		Player p = new Player(request.getParameter("first_name"), request.getParameter("last_name"), Integer.parseInt(request.getParameter("age")));
					
		// Grabs Team object from ArrayList using the form data
		Team t = rTeams.get(Integer.parseInt(request.getParameter("id")));
		
		// Instantiates the team object's players ArrayList
		ArrayList<Player> pList = t.getPlayers();
		
		// Adds the instantiated player to the pList
		pList.add(p);
		
		// Sets the team's new players list
		t.setPlayers(pList);
		
		// Sets the updated team object to the proper array index in the teams list
		rTeams.set(Integer.parseInt(request.getParameter("id")), t);
		
		// Sets the roster for r
		r.setTeams(rTeams);
		
		// Overwrites session roster with new roster
		session.setAttribute("roster", r);
		
		// Sets the Team as the model for the view
		request.setAttribute("team", t);
		request.setAttribute("index", Integer.parseInt(request.getParameter("id")));
		
		// Let the view handle the request
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/TeamInfo.jsp");
		view.forward(request,  response);
	}

}
