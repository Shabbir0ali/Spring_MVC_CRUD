package com.shabbir.springMVC.project.Model.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shabbir.springMVC.project.Model.Dao.StudentDao;
import com.shabbir.springMVC.project.Model.Entity.StudentBean;

@Service
public class StudentService {

	@Autowired
	private StudentDao dao;

	public StudentDao getDao() {
		return dao;
	}

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}

	public boolean save(StudentBean bean) {
		boolean save = dao.save(bean);
		return save;
	}

	public boolean deleteByE(String email,int id) {

		boolean f = dao.deleteByEmail(email,id);
		
		return f;
	}

	public StudentBean findById(int id) {
		StudentBean bean = dao.findByIds(id);
		return bean;
	}

	public boolean update(StudentBean bean) {
		boolean update = dao.update(bean);
		return update;
	}
	
	
}
