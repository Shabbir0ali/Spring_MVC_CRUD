package com.shabbir.springMVC.project.Model.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shabbir.springMVC.project.Model.Dao.RegisterDao;
import com.shabbir.springMVC.project.Model.Entity.RegisterBean;

@Service
public class RegisterService {

	@Autowired
	private RegisterDao dao ;

	public RegisterDao getDao() {
		return dao;
	}

	public void setDao(RegisterDao dao) {
		this.dao = dao;
	}

	public int register(RegisterBean bean) {
	
		int save = this.dao.save(bean);
		return save;
	}

	public boolean login(RegisterBean bean) {
		
		boolean login = this.dao.loginCheck(bean);
		return login;
	}
	
	public RegisterBean getValue(String email) {
		RegisterBean bean = dao.getval(email);
		return bean;
	}
	
}
