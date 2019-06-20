package com.sherold.web.models;

import java.util.ArrayList;

public class Roster {
	// <----- Attributes ----->
	private ArrayList<Team> teams;
	
	// <----- Constructors ----->
	public Roster() {
		this.teams = new ArrayList<Team>();
	}

	// <----- Getters/Setters ----->
	// teams
	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
}
