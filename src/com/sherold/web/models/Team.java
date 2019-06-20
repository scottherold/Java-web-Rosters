package com.sherold.web.models;

import java.util.ArrayList;

public class Team {
	// <----- Attributes ----->
	private String team_name;
	private ArrayList<Player> players;
	
	// <----- Constructors ----->
	public Team() {
		// players must be created at team object instantiation
		this.players = new ArrayList<Player>();
	}
	
	public Team(String team_name) {
		this.team_name = team_name;
		// players must be created at team object instantiation
		this.players = new ArrayList<Player>();
	}

	// <----- Getters/Setters ----->
	// team_name
	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
}
