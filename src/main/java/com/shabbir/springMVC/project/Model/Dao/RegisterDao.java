package com.shabbir.springMVC.project.Model.Dao;

import com.shabbir.springMVC.project.Model.Entity.RegisterBean;

public interface RegisterDao {

	int save(RegisterBean bean);

	boolean loginCheck(RegisterBean bean);

	RegisterBean getval(String email);

}
