package com.hcl.bean;

public class CarBean {
	
	private int carid;
	private String carname;
	private String carnumber;
	private int carseater;
	private String cartype;
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public int getCarseater() {
		return carseater;
	}
	public void setCarseater(int carseater) {
		this.carseater = carseater;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	@Override
	public String toString() {
		return "CarBean [carid=" + carid + ", carname=" + carname + ", carnumber=" + carnumber + ", carseater="
				+ carseater + ", cartype=" + cartype + "]";
	}
	
}
