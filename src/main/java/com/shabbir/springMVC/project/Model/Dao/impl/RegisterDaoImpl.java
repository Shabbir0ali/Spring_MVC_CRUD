package com.shabbir.springMVC.project.Model.Dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.shabbir.springMVC.project.Model.Dao.RegisterDao;
import com.shabbir.springMVC.project.Model.Entity.RegisterBean;

@Repository
@Component
public class RegisterDaoImpl implements RegisterDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int save(RegisterBean bean) {
		int save = (Integer) hibernateTemplate.save(bean);
		return save;
	}

	public boolean loginCheck(RegisterBean bean) {
		boolean flag = false;
		Session session = hibernateTemplate.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		Query<RegisterBean> query = session.createQuery("from RegisterBean where email = :e and password = :p");
		query.setParameter("e", bean.getEmail());
		query.setParameter("p", bean.getPassword());

		List<RegisterBean> list = query.list();

		if (!list.isEmpty()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public RegisterBean getval(String email) {

		Session session = hibernateTemplate.getSessionFactory().openSession();
		 Query<RegisterBean> query = session.createQuery("from RegisterBean where email = :e");
		 query.setParameter("e", email);
		 List<RegisterBean> list = query.list();
		 session.close();
		return list.get(0);
	}

}
