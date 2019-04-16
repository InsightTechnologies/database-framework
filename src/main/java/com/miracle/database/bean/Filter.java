package com.miracle.database.bean;

import org.springframework.data.annotation.Id;

public class Filter {

	@Id
	private int id;
	private String filterType;
	private double velocityPercentage;

	public Filter() {
	}

	public Filter(String filterType, int velocityPercentage) {
		this.filterType = filterType;
		this.velocityPercentage = velocityPercentage;
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

}
