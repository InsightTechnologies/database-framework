package com.miracle.database.bean;

import org.mongojack.Id;

public class Team {

	@Id
	private int _id;
	private String teamName;
	private int velocity;
	private int workingHours;

	public Team() {

	}

	public Team(String teamName, int velocity, int workingHours) {
		super();
		this.teamName = teamName;
		this.velocity = velocity;
		this.workingHours = workingHours;
	}

	/**
	 * @return the _id
	 */
	public int get_id() {
		return _id;
	}

	/**
	 * @param _id the _id to set
	 */
	public void set_id(int _id) {
		this._id = _id;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/**
	 * @return the velocity
	 */
	public int getVelocity() {
		return velocity;
	}

	/**
	 * @param velocity the velocity to set
	 */
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	/**
	 * @return the workingHours
	 */
	public int getWorkingHours() {
		return workingHours;
	}

	/**
	 * @param workingHours the workingHours to set
	 */
	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}
}
