package com.re.proj1.service;

import com.re.proj1.DAO.RTypeDao;

public class RTypeService {
	
	static RTypeDao typeDao = new RTypeDao();
	
	public String getRTypeById(int id) {
		String type = null;
		type = typeDao.findTypeById(id);
		return type;
	}

}
