package com.hcl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hcl.bean.CarBean;
import com.hcl.bean.CustomerBean;
import com.hcl.util.DBUtil;

public class CustomerDao {
	public boolean createLogin(CustomerBean bean)
	{
		boolean flag=false;
		try {
			Connection con=DBUtil.getConnection();
			String name=bean.getName();
			String user=bean.getUsername();
			String pass=bean.getUserpass();
			String gender=bean.getGender();
			String address=bean.getAddress();
			double contact=bean.getContactno();
			String email=bean.getEmailid();
				String qry1="insert into ACR_TBL_CUSTOMER_DETAILS values(ACR_SEQ_CUSTOMER_ID_Sequence.nextval,?,?,?,?,?,?,?)";
				PreparedStatement pstmt1=con.prepareStatement(qry1);
						
						pstmt1.setString(1, name);
						pstmt1.setString(2, user);
						pstmt1.setString(3, pass);
						pstmt1.setString(4, gender);
						pstmt1.setString(5, address);
						pstmt1.setDouble(6, contact);
						pstmt1.setString(7, email);
				int rst1=pstmt1.executeUpdate();
						flag=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return flag;
		
	}
	
	public List<CustomerBean> listAllCustomers()
	{
		List<CustomerBean> list=new ArrayList<CustomerBean>();
		try {
			String qry="select * from ACR_TBL_CUSTOMER_DETAILS";
			Connection con=DBUtil.getConnection();
			PreparedStatement pstmt=con.prepareStatement(qry);
			ResultSet rst=pstmt.executeQuery();
			while(rst.next())
			{
				CustomerBean bean=new CustomerBean();
			    bean.setCustomer_id(rst.getInt(1));
				bean.setName(rst.getString(2));
				bean.setUsername(rst.getString(3));
				bean.setUserpass(rst.getString(4));
				bean.setGender(rst.getString(5));
				bean.setAddress(rst.getString(6));
				bean.setContactno(rst.getDouble(7));
				bean.setEmailid(rst.getString(8));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
		
	}
	public boolean deleteCustomer(String customerid)
	{
		boolean  flag=false;
		 try {
				String qry2="delete from ACR_TBL_CUSTOMER_DETAILS where CUSTOMER_ID=?";
				  
				   Connection con=DBUtil.getConnection();
				   PreparedStatement pstmt2=con.prepareStatement(qry2);
				   pstmt2.setString(1, customerid);
				  
				   int n=pstmt2.executeUpdate();
				   if(n>0)
					   flag=true;
				   else
					   flag=false;
			} catch (SQLException e) {
				flag=false;
				e.printStackTrace();
			}
			return(flag);   
	}
	public boolean updateCustomerDetails(String name,String username, String userpass, String gender, String address, double contactno, String emailid )
	{
		boolean  flag=false;
		 try {
				String qry="update car set CUSTOMER_NAME=?,CUSTOMER_USER_NAME=?,CUSTOMER_USER_PASS=?,CUSTOMER_GENDER=?,CUSTOMER_ADDRESS=?,CUSTOMER_CONTACT_NUMBER=?,CUSTOMER_EMAIL_ID=? where CUSTOMER_USER_NAME=? ";
				  
				   Connection con=DBUtil.getConnection();
				   PreparedStatement pstmt=con.prepareStatement(qry);
				   
				   pstmt.setString(1, name);
				   pstmt.setString(2, username);
				   pstmt.setString(3, userpass);
				   pstmt.setString(4, gender);
				   pstmt.setString(5, address);
				   pstmt.setDouble(6, contactno);
				   pstmt.setString(7, emailid);
				   int n=pstmt.executeUpdate();
				   if(n>0)
					   flag=true;
				   else
					   flag=false;
			} catch (SQLException e) {
				flag=false;
				e.printStackTrace();
			}
			return(flag);   
	}
}
