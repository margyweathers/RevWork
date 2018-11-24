package com.re.proj1.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.re.proj1.DAO.ReimbursementDao;
import com.re.proj1.pojos.Reimbursement;

public class ReimbursementService {
	static ReimbursementDao rd = new ReimbursementDao();
	
	public List<Reimbursement> getAllReimbursements(){
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		reimbs = rd.findAll();		
		return reimbs;
	}
	
	public List<Reimbursement> getReimbursementsByAuthor(int author){
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		reimbs= rd.findByAuthorId(author);
		return reimbs;
	}
	
	public List<Reimbursement> getPendingReimbursementsByAuthor(int author){
		List<Reimbursement> all = rd.findByAuthorId(author);
		List<Reimbursement> pending = new ArrayList<Reimbursement>();
		Reimbursement r;
		Iterator<Reimbursement> itr = all.iterator();
		while(itr.hasNext()) {
			r = itr.next();
			if (r.getrStatus() == 1) {
				pending.add(r);
			}
		}		
		return pending;
	}
	
	public List<Reimbursement> getPastReimbursementsByAuthor(int author){
		List<Reimbursement> all = rd.findByAuthorId(author);
		List<Reimbursement> past = new ArrayList<Reimbursement>();
		Reimbursement r;
		Iterator<Reimbursement> itr = all.iterator();
		while(itr.hasNext()) {
			r = itr.next();
			if (r.getrStatus() == 2 || r.getrType() == 3) {
				past.add(r);
			}
		}		
		return past;
	}
	
	public Reimbursement submit(Reimbursement r) {
		rd.create(r);
		return r;
	}

}
