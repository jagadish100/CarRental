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

public class CarDao {
	public boolean addCar(CarBean bean)
	{
		boolean flag=false;
		try {
			Connection con=DBUtil.getConnection();
			
			int id=bean.getCarid();
			String carname=bean.getCarname();
			String carnumber=bean.getCarnumber();
			int carseater=bean.getCarseater();
			String gender=bean.getCartype();
			
				String qry1="insert into car values(?,?,?,?,?)";
				PreparedStatement pstmt1=con.prepareStatement(qry1);
						pstmt1.setInt(1, id);
						pstmt1.setString(2, carname);
						pstmt1.setString(3, carnumber);
						pstmt1.setInt(4, carseater);
						pstmt1.setString(5, gender);
					
				int rst1=pstmt1.executeUpdate();
						flag=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return flag;
		
	}
	public List<CarBean> listAll()
	{
		List<CarBean> list=new ArrayList<CarBean>();
		try {
			String qry="select * from car";
			Connection con=DBUtil.getConnection();
			PreparedStatement pstmt=con.prepareStatement(qry);
			ResultSet rst=pstmt.executeQuery();
			while(rst.next())
			{
				CarBean bean=new CarBean();
				bean.setCarid(rst.getInt(1));
				bean.setCarname(rst.getString(2));
				bean.setCarnumber(rst.getString(3));
				bean.setCarseater(rst.getInt(4));
				bean.setCartype(rst.getString(5));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
		
	}
	
	public boolean deleteCar(String carid)
	{
		boolean  flag=false;
		 try {
				String qry="delete from car where car_id=?";
				  
				   Connection con=DBUtil.getConnection();
				   PreparedStatement pstmt=con.prepareStatement(qry);
				   pstmt.setString(1, carid);
				  
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
	public boolean updateCar(String carname, String carnumber, int carseater, String cartype, int carid)
	{
		boolean  flag=false;
		 try {
				String qry="update car set carname=?,carnumber=?,carseater=?,cartype=? where carid=? ";
				  
				   Connection con=DBUtil.getConnection();
				   PreparedStatement pstmt=con.prepareStatement(qry);
				   pstmt.setString(1, carname);
				   pstmt.setString(2, carnumber);
				   pstmt.setInt(3, carseater);
				   pstmt.setString(4, cartype);
				   pstmt.setInt(5, carid);
				  
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
