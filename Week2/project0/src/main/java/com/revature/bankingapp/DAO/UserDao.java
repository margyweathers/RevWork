package com.revature.bankingapp.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.bankingapp.pojos.User;
import com.revature.bankingapp.util.ConnectionFactory;

public class UserDao implements DAO<User, Integer>  {

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User create(User obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "INSERT INTO USR (USERNAME, PW, FIRSTNAME, LASTNAME) VALUES(?,?,?,?)";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User update(User obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<User> getAllUsernames(){
		return null;
		
	}

}
