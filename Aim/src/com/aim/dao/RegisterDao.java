package com.aim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aim.model.RegisterUser;

@Repository
public class RegisterDao {
@Autowired
JdbcTemplate jdbcTemplate;
	public String insertInfo(RegisterUser user) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=jdbcTemplate.getDataSource().getConnection();
		PreparedStatement pst=con.prepareStatement("Select * from register where Email = ?");
		pst.setString(1, user.getEmail());
		ResultSet rs=pst.executeQuery();
		Pattern pat1=Pattern.compile("[a-zA-Z0-9.]*[@][a-z.]*");
		Matcher m1=pat1.matcher(user.getEmail());
		if(m1.find() && m1.group().equals(user.getEmail()))
		{
			if(user.getPassword().equals(user.getPassword2()))
			{
				if(rs.next())
				{
					return "AlreadyExist";
				}
				else
				{
					PreparedStatement pst2=con.prepareStatement("insert into register values(?,?,?,?)");
					pst2.setString(1, user.getUsername());
					pst2.setString(2, user.getEmail());
					pst2.setString(3, user.getPassword());
					pst2.setString(4, user.getPassword2());
					pst2.executeUpdate();
				}
			}
			else
			{
				return "PasswordMismatched";
			}
		}
		else
		{
			return "InvalidEmail";
		}
		return "login";
	}

}
