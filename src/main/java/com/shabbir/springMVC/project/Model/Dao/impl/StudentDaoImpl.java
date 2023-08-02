package com.shabbir.springMVC.project.Model.Dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.shabbir.springMVC.project.Model.Dao.StudentDao;
import com.shabbir.springMVC.project.Model.Entity.StudentBean;

@Repository
@Component
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public boolean save(StudentBean bean) {
		boolean flag= false;
		 @SuppressWarnings("deprecation")
		 List<?> list = hibernateTemplate.findByNamedParam("FROM StudentBean WHERE email = :email", "email", bean.getEmail());
		 if(list.isEmpty()) {
			 flag = true;
				hibernateTemplate.persist(bean);
		 }
		 else {
			flag = false;
		}
		 
		
		return flag;
	}

	@Transactional
	public boolean deleteByEmail(String email, int id) {

		@SuppressWarnings("unchecked")
		Query<StudentBean> query = hibernateTemplate.getSessionFactory().getCurrentSession()
				.createQuery("delete from StudentBean where email = :e and id = :i");
		query.setParameter("e", email);
		query.setParameter("i", id);
		int executeUpdate = query.executeUpdate();

		return executeUpdate > 0;
	}

	@Transactional
	public StudentBean findByIds(int id) {
		StudentBean load = hibernateTemplate.load(StudentBean.class, id);
		System.out.println(load.getAadharNumber());
		return load;
	}

	@Transactional
	public boolean update(StudentBean bean) {
		try {
			
			hibernateTemplate.update(bean);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}