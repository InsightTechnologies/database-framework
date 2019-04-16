package com.miracle.database.bean;

import org.mongojack.Id;

public class Sprint {
	@Id
	private int id;
	private int duration;

	public Sprint() {

	}

	public Sprint(int duration) {
		this.setDuration(duration);
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
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
}
