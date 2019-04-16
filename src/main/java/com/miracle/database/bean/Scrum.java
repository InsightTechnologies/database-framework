package com.miracle.database.bean;

import org.mongojack.Id;

public class Scrum {

	@Id
	private int id;
	private String apiEndpoint;
	private String token;

	public Scrum(String apiEndpoint, String token) {
		super();
		this.apiEndpoint = apiEndpoint;
		this.token = token;
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
