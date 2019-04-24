package com.miracle.database.bean;

import org.mongojack.Id;

public class Sprint {
	@Id
	private int _id;
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
