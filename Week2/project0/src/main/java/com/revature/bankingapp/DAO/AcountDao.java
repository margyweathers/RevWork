package com.revature.bankingapp.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankingapp.pojos.Account;
import com.revature.bankingapp.util.ConnectionFactory;

public class AcountDao implements DAO<Account, Integer> {

	@Override
	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<Account>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM ACCOUNT";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);			
			while(rs.next()) {
				Account temp = new Account();
				temp.setAccId(rs.getInt(1));
				temp.setUsrId(rs.getInt(2));
				temp.setAccType(rs.getInt(3));
				temp.setNickname(rs.getString(4));
				temp.setBalance(rs.getDouble(5));
				temp.setInterest(rs.getDouble(6));
				temp.setActive(rs.getInt(7));
				accounts.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public Account findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account create(Account obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account update(Account obj) {
		// TODO Auto-generated method stub
		return null;
	}


}
