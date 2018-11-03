package com.revature.bankingapp.DAO;

import java.io.Serializable;
import java.util.List;

public interface DAO<T, I extends Serializable> {

	List<T> findAll();
	T findById(I id);
	T create(T obj);
	T update(T obj);

	/*
	 * Adding this default method so that we have the capability
	 * to instantiate our DAO concrete classes with a reference
	 * to the DAO interface and use this method
	 */
	default boolean isUnique(T obj) {
		return true;
	}
	
	// default User methods
	default List<String> findAllUsernames(){
		return null;
	}
	default T findByUsername(String username) {
		return null;
	}
	
	// default Account methods
	default List<T> findByUserID(int id){
		return null;
	}
}
