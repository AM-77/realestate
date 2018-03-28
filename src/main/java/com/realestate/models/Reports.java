package com.realestate.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reports {

	@Id
	@GeneratedValue
	private int id;
	
	private String repoter;
	private int id_appointement;
	private String report;
	private Date time;
	private int v_operator;
	
	public Reports() {
		super();
	}

	public Reports(int id, String repoter, int id_appointement, String report, Date time, int v_operator) {
		super();
		this.id = id;
		this.repoter = repoter;
		this.id_appointement = id_appointement;
		this.report = report;
		this.time = time;
		this.v_operator = v_operator;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRepoter() {
		return repoter;
	}

	public void setRepoter(String repoter) {
		this.repoter = repoter;
	}

	public int getId_appointement() {
		return id_appointement;
	}

	public void setId_appointement(int id_appointement) {
		this.id_appointement = id_appointement;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getV_operator() {
		return v_operator;
	}

	public void setV_operator(int v_operator) {
		this.v_operator = v_operator;
	}

}

