package com.aim.service;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aim.dao.LoginDao;
import com.aim.model.LoginUser;

@Service("loginService")
public class LoginService {
@Autowired
LoginDao loginDao;

	public String insertLoginInfo(LoginUser user) throws IOException ,SQLException {
		// TODO Auto-generated method stub
		System.out.println("LoginServiceFirst");
		String s=loginDao.insertLoginInfo(user);
		System.out.println("Login Service last");
		return s;
	}
}
