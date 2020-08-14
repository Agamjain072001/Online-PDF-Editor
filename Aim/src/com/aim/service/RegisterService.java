package com.aim.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aim.dao.RegisterDao;
import com.aim.model.RegisterUser;

@Service
public class RegisterService {
@Autowired
RegisterDao registerdao;
	public String insertInfo(RegisterUser user) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Service first");
		String s=registerdao.insertInfo(user);
		System.out.println("Service last");
		return s;
	}
}
