package com.miracle.database.bean;

import java.util.Date;

import org.mongojack.Id;

public class Release {

	@Id
	private int _id;
	private double version;
	private int noOfSprints;
	private Date startDate;
	private Date endDate;
	private String status;
	private String teamName;
	private String projectName;

	public Release() {

	}

	public Release(double version, int noOfSprints, Date startDate, Date endDate, String status, String teamName,
			String projectName) {
		super();
		this.version = version;
		this.noOfSprints = noOfSprints;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.teamName = teamName;
		this.projectName = projectName;
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
	 * @return the version
	 */
	public double getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(double version) {
		this.version = version;
	}

	/**
	 * @return the noOfSprints
	 */
	public int getNoOfSprints() {
		return noOfSprints;
	}

	/**
	 * @param noOfSprints the noOfSprints to set
	 */
	public void setNoOfSprints(int noOfSprints) {
		this.noOfSprints = noOfSprints;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
