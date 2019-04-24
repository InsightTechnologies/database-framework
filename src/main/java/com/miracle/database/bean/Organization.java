package com.miracle.database.bean;

import org.mongojack.Id;

public class Organization {

	@Id
	private int _id;
	private String orgName;
	private String orgEmail;

	public Organization() {

	}

	public Organization(String orgName, String orgEmail) {
		this.orgName = orgName;
		this.orgEmail = orgEmail;
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
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * @return the orgEmail
	 */
	public String getOrgEmail() {
		return orgEmail;
	}

	/**
	 * @param orgEmail the orgEmail to set
	 */
	public void setOrgEmail(String orgEmail) {
		this.orgEmail = orgEmail;
	}
}
