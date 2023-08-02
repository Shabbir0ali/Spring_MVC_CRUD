package com.shabbir.springMVC.project.Model.Dao;

import com.shabbir.springMVC.project.Model.Entity.StudentBean;

public interface StudentDao {

	boolean save(StudentBean bean);

	boolean deleteByEmail(String email,int id);

	StudentBean findByIds(int id);

	boolean update(StudentBean bean);

}
