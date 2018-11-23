package com.rev.proj1.service;

import java.util.ArrayList;
import java.util.List;

import com.rev.proj1.DAO.RTypeDao;
import com.rev.proj1.pojos.RType;

public class RTypeService {
	
	static RTypeDao typeDao = new RTypeDao();
	
	public List<RType> getAll(){
		List<RType> types = new ArrayList<RType>();
		types = typeDao.findALL();		
		return types;
	}
	
	// Might not need this...
	public String getRTypeById(int id) {
		String type = null;
		type = typeDao.findTypeById(id);
		return type;
	}

}
