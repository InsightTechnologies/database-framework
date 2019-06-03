package com.miracle.database.bean;

import org.mongojack.Id;

public class Filter {

	@Id
	private int _id;
	private String filterType;
	private double velocityPercentage;

	public Filter() {
	}

	public Filter(String filterType, int velocityPercentage) {
		this.filterType = filterType;
		this.velocityPercentage = velocityPercentage;
	}

	/**
	 * @return the filterType
	 */
	public String getFilterType() {
		return filterType;
	}

	/**
	 * @param filterType the filterType to set
	 */
	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}

	/**
	 * @return the velocityPercentage
	 */
	public double getVelocityPercentage() {
		return velocityPercentage;
	}

	/**
	 * @param velocityPercentage the velocityPercentage to set
	 */
	public void setVelocityPercentage(double velocityPercentage) {
		this.velocityPercentage = velocityPercentage;
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

}
