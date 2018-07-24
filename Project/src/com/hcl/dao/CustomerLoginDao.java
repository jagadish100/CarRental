package com.hcl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hcl.bean.CustomerBean;
import com.hcl.util.DBUtil;

public class CustomerLoginDao {
	public boolean validate(CustomerBean bean)
	{
		boolean flag=false;
		try {
			Connection con=DBUtil.getConnection();
			String user=bean.getUsername();
			String pass=bean.getUserpass();

		String qry="select * from customer_registration where user_name=? and user_pass=?";
			PreparedStatement pstmt=con.prepareStatement(qry);
					pstmt.setString(1, user);
					pstmt.setString(2, pass);
			ResultSet rst=pstmt.executeQuery();
		
			if(rst.next())
			{
				flag=true;
			}
			else
			{
				flag=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			flag=false;
			
		}
		System.out.println(" Flag = "+flag);
		return flag;
	}
	
	
}
