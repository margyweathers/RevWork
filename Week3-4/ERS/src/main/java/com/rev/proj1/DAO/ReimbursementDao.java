package com.rev.proj1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.proj1.pojos.Reimbursement;
import com.rev.proj1.util.ConnectionFactory;

public class ReimbursementDao {

	/**
	 * 
	 * @return All Reimbursements. Null if none exist
	 */
	public List<Reimbursement> findAll(){
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM REIMBURSEMENTS ORDER BY R_ID";
			Statement statement = conn.createStatement();	// Statement... Potential for SQL injection
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setrId(rs.getInt(1));
				r.setAuthor(rs.getInt(2));
				r.setrResolver(rs.getInt(3));
				r.setAmount(rs.getDouble(4));
				r.setSubmitDate(rs.getString(5));
				r.setResolveDate(rs.getString(6));
				r.setrType(rs.getInt(7));
				r.setrDesc(rs.getString(8));
				r.setrStatus(rs.getInt(9));
				reimbs.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return reimbs;
	}
	
	public List<Reimbursement> findByAuthorId(int author){
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE AUTHOR = ? ORDER BY R_ID";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, author);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setrId(rs.getInt(1));
				r.setAuthor(rs.getInt(2));
				r.setrResolver(rs.getInt(3));
				r.setAmount(rs.getDouble(4));
				r.setSubmitDate(rs.getString(5));
				r.setResolveDate(rs.getString(6));
				r.setrType(rs.getInt(7));
				r.setrDesc(rs.getString(8));
				r.setrStatus(rs.getInt(9));
				reimbs.add(r);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return reimbs;
	}
	
	public List<Reimbursement> findByResolverId(int resolver){
		List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE R_RESOLVER = ? ORDER BY R_ID";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, resolver);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setrId(rs.getInt(1));
				r.setAuthor(rs.getInt(2));
				r.setrResolver(rs.getInt(3));
				r.setAmount(rs.getDouble(4));
				r.setSubmitDate(rs.getString(5));
				r.setResolveDate(rs.getString(6));
				r.setrType(rs.getInt(7));
				r.setrDesc(rs.getString(8));
				r.setrStatus(rs.getInt(9));
				reimbs.add(r);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return reimbs;
	}
	
	public Reimbursement create(Reimbursement r) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			// Create a reimbursement with null resolver and resolve date
			String sql = "INSERT INTO REIMBURSEMENTS (AUTHOR, AMOUNT, SUBMIT_DATE, R_TYPE, R_DESC, R_STATUS) "
					+ "VALUES(?, ?, ?, ?, ?, ?)";
			String[] keyNames = {"R_ID"};
			PreparedStatement ps = conn.prepareStatement(sql, keyNames);
			ps.setInt(1, r.getAuthor());
			ps.setDouble(2,r.getAmount());
			ps.setString(3, r.getSubmitDate());
			ps.setInt(4, r.getrType());
			ps.setString(5, r.getrDesc());
			ps.setInt(6, r.getrStatus());
			int numRows = ps.executeUpdate();
			if (numRows == 0) {
				return null;
			}		
			else {
				ResultSet pk = ps.getGeneratedKeys();	// primary keys
				while (pk.next()) {
					r.setrId(pk.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	/**
	 * 
	 * @param Reimbursement r
	 * @return Reimbursement if update was successful. Null if not.
	 */
	public Reimbursement update(Reimbursement r) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "UPDATE REIMBURSEMENTS SET AUTHOR = ?, R_RESOLVER = ?, AMOUNT = ?, SUBMIT_DATE = ?, "
					+ "RESOLVE_DATE = ?, R_TYPE = ?, R_DESC = ?, R_STATUS = ? WHERE R_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getAuthor());
			ps.setInt(2, r.getrResolver());
			ps.setDouble(3,r.getAmount());
			ps.setString(4, r.getSubmitDate());
			ps.setString(5,  r.getResolveDate());
			ps.setInt(6, r.getrType());
			ps.setString(7, r.getrDesc());
			ps.setInt(8, r.getrStatus());
			ps.setInt(9, r.getrId());
			int numRows = ps.executeUpdate();
			if (numRows == 0) {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return r;
	}
	
	
	
	
	
	
	
	
	
	
}

















