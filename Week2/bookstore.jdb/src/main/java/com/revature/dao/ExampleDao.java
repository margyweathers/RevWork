package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


import com.revature.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class ExampleDao {
	
	public static void main(String[] args) {
//		System.out.println(getBookInfo(1));
	}
	
		static int getBooksByGenre(String genre) {
		int total = 0;
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "{? = call num_books_by_genre(?) }";			// CURLY BRACKETS FOR CALLABLE STATEMENT
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setString(2, genre);
			cs.execute();
			total = cs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
		
//		static BookInfo getBookInfo(int id) {
//			BookInfo b = null;
//			try(Connection conn = ConnectionFactory.getInstance().getConnection()){
//				String sql = "{ call get_book_info(?, ?)}";
//				CallableStatement cs = conn.prepareCall(sql);
//				cs.setInt(1, id);
//				cs.registerOutParameter(2, OracleTypes.CURSOR);
//				
//				cs.executeUpdate();
//				
//				ResultSet rs = (ResultSet) cs.getObject(2);
//				// b.book_id, b.isbn, a.first_name, a.last_name, b.title, b.price, g.name
//				while(rs.next()) {
//					b = new BookInfo();
//					b.setId(rs.getInt(1));
//					b.setIsbn(rs.getString(2));
//					b.setFn(rs.getString(3));
//					b.setLn(rs.getString(4));
//					b.setTitle(rs.getString(5));
//					b.setPrice(rs.getDouble(6));
//					b.setGenre(rs.getString(7));
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//			return b;
//		}
//
  }