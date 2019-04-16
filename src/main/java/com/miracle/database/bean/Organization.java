package com.miracle.database.bean;

import org.mongojack.Id;

public class Organization {

	@Id
	private int id;
	private String orgName;
	private String orgEmail1;

	public Organization() {

	}

	public Organization(String orgName, String orgEmail1) {
		this.orgName = orgName;
		this.orgEmail1 = orgEmail1;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the orgEmail1
	 */
	public String getOrgEmail1() {
		return orgEmail1;
	}

	/**
	 * @param orgEmail1 the orgEmail1 to set
	 */
	public void setOrgEmail1(String orgEmail1) {
		this.orgEmail1 = orgEmail1;
	}
}
