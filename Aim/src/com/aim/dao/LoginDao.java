package com.aim.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aim.model.LoginUser;

@Repository
public class LoginDao {
@Autowired
JdbcTemplate jdbcTemplate;
	public String insertLoginInfo(LoginUser user) throws IOException ,SQLException {
		// TODO Auto-generated method stub
		Connection con=jdbcTemplate.getDataSource().getConnection();
		PreparedStatement print=con.prepareStatement("select * from register where Username = ?");
		print.setString(1, user.getUsername());
		ResultSet rp=print.executeQuery();
		if(rp.next())
		{
			String pass=rp.getString("Password");
			if(pass.equals(user.getPassword()))
			{
				return "LogInnedHome";
			}
			else
			{
				return "InvalidPassword";
			}
		}
		else
		{
			return "InvalidUsername";
		}
	}

}
