package com.hcl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hcl.bean.AdminBean;
import com.hcl.util.DBUtil;

public class AdminDao {
	
	public boolean validate(AdminBean bean)
	{
		boolean flag=false;
		try {
			Connection con=DBUtil.getConnection();
			String user=bean.getUsername();
			String pass=bean.getUserpass();

		String qry="select * from ACR_TBL_ADMIN_DETAILS where USER_NAME=? and USER_PASS=?";
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
			
		}
		return flag;
}
}
