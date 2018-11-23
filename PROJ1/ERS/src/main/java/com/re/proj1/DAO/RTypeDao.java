package com.re.proj1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.re.proj1.util.ConnectionFactory;

public class RTypeDao {


	public String findTypeById(int id) {
		String type = null;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT R_TYPE FROM REIMBURSEMENT_TYPE WHERE R_TYPE_ID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			type = rs.getString(1);			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return type;
	}

}
