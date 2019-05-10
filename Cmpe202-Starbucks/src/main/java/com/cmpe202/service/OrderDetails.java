package com.cmpe202.service;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cmpe202.pojo.itemtest;
import com.fasterxml.jackson.annotation.JsonIgnore;

import net.bytebuddy.build.ToStringPlugin.Exclude;

@Entity
@Table(name = "OrderDetails")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	String id;
	@Column(name = "userid")
	int userid;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid")
	int orderid;
	@Column(name = "itemname")
	String itemname;
	@Column(name = "itemsize")
	String itemsize;
	@Column(name = "quantity")
	int quantity;
	@Column(name = "totalamount")
	double totalamount;
	@Column(name = "orderdate")
	Date orderdate;
	
	public ArrayList<itemtest> itemtest1;
	
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	
	public ArrayList<itemtest> getItemtest1() {
		return itemtest1;
	}
	public void setItemtest1(ArrayList<itemtest> itemtest1) {
		this.itemtest1 = itemtest1;
	}
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", userid=" + userid + ", itemname=" + itemname + ", itemsize=" + itemsize
				+ ", quantity=" + quantity + ", totalamount=" + totalamount + ", orderdate=" + orderdate + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getItemsize() {
		return itemsize;
	}
	public void setItemsize(String itemsize) {
		this.itemsize = itemsize;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	

}
