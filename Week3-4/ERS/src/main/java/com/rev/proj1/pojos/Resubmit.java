package com.rev.proj1.pojos;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Resubmit {
	
	private int resubmitId;
	private int origRId;
	private int rResolver;
	private double amount;
	private String submitDate;
	private String resubmitDate;
	private String resolveDate;
	private int rType;
	private String rDesc;
	private int rStatus;
	static SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy HH:mm");
	static DecimalFormat decf = new DecimalFormat("0.00");
	
	public Resubmit(int origRId, int rResolver, double amount, String submitDate, int rType, String rDesc,
			int rStatus) {
		super();
		this.origRId = origRId;
		this.rResolver = rResolver;
		this.amount = amount;
		this.submitDate = submitDate;
		this.rType = rType;
		this.rDesc = rDesc;
		this.rStatus = rStatus;
		resubmitDate = df.format(new Date());
	}

	public int getResubmitId() {
		return resubmitId;
	}

	public void setResubmitId(int resubmitId) {
		this.resubmitId = resubmitId;
	}

	public int getOrigRId() {
		return origRId;
	}

	public void setOrigRId(int origRId) {
		this.origRId = origRId;
	}

	public int getrResolver() {
		return rResolver;
	}

	public void setrResolver(int rResolver) {
		this.rResolver = rResolver;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getResubmitDate() {
		return resubmitDate;
	}

	public void setResubmitDate(String resubmitDate) {
		this.resubmitDate = resubmitDate;
	}

	public String getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(String resolveDate) {
		this.resolveDate = resolveDate;
	}

	public int getrType() {
		return rType;
	}

	public void setrType(int rType) {
		this.rType = rType;
	}

	public String getrDesc() {
		return rDesc;
	}

	public void setrDesc(String rDesc) {
		this.rDesc = rDesc;
	}

	public int getrStatus() {
		return rStatus;
	}

	public void setrStatus(int rStatus) {
		this.rStatus = rStatus;
	}

	public static SimpleDateFormat getDf() {
		return df;
	}

	public static void setDf(SimpleDateFormat df) {
		Resubmit.df = df;
	}

	public static DecimalFormat getDecf() {
		return decf;
	}

	public static void setDecf(DecimalFormat decf) {
		Resubmit.decf = decf;
	}
	
	
	
	
	

}
