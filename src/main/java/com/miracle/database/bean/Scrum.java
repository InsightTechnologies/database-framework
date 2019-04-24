package com.miracle.database.bean;

import org.mongojack.Id;

public class Scrum {

	@Id
	private int _id;
	private String apiEndpoint;
	private String token;

	public Scrum(String apiEndpoint, String token) {
		super();
		this.apiEndpoint = apiEndpoint;
		this.token = token;
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
	 * @return the apiEndpoint
	 */
	public String getApiEndpoint() {
		return apiEndpoint;
	}

	/**
	 * @param apiEndpoint the apiEndpoint to set
	 */
	public void setApiEndpoint(String apiEndpoint) {
		this.apiEndpoint = apiEndpoint;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

}
