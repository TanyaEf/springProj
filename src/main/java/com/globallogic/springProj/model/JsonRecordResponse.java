package com.globallogic.springProj.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonRecordResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("Result")
	private String result;

	@JsonProperty("Record")
	private User record;
	
	public JsonRecordResponse(String result, User record) {
		super();
		this.result = result;
		this.record = record;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public User getRecord() {
		return record;
	}

	public void setRecord(User record) {
		this.record = record;
	}

}
