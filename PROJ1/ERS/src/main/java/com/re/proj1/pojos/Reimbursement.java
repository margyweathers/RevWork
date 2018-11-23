package com.re.proj1.pojos;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reimbursement {
	

	private int rId;
	private int author;
	private int rResolver;
	private double amount;
	private String submitDate;
	private String resolveDate;
	private int rType;
	private String rDesc;
	private int rStatus;
	static SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy HH:mm");
	static DecimalFormat decf = new DecimalFormat("0.00"); 
	
	public Reimbursement() {}
	
	public Reimbursement(int author, double amount, int rType, String rDesc, int rStatus) {
		super();
		this.author = author;
		this.amount = amount;
		this.rType = rType;
		this.rDesc = rDesc;
		this.rStatus = rStatus;
		submitDate = df.format(new Date());
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
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
		Reimbursement.df = df;
	}

	public static DecimalFormat getDecf() {
		return decf;
	}

	public static void setDecf(DecimalFormat decf) {
		Reimbursement.decf = decf;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [rId=" + rId + ", author=" + author + ", rResolver=" + rResolver + ", amount=" + amount
				+ ", rType=" + rType + ", rStatus=" + rStatus + "]";
	}	
	
	

}
