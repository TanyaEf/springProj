package com.globallogic.springProj.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonTableResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("Result")
	private String result;

	@JsonProperty("Records")
	private List<User> records;
	
	@JsonProperty("TotalRecordCount")
	private Integer totalRecordCount;
	
	@JsonProperty("allRoles")
	private List<Role> allRoles;
	

	public JsonTableResponse(String result, List<User> records,
			Integer totalRecordCount, List<Role> allRoles) {
		super();
		this.result = result;
		this.records = records;
		this.totalRecordCount = totalRecordCount;
		this.allRoles = allRoles;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<User> getRecords() {
		return records;
	}

	public void setRecords(List<User> records) {
		this.records = records;
	}

}
