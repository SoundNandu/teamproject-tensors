package com.cmpe202.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "PaymentDetails")
public class PaymentDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5295061001832074352L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	String id;
	@Column(name = "userid")
	int userid;
	@Column(name = "cardNo")
	String cardNo;
	
	@Column(name = "amounttotal")
	double amounttotal;
	
	
	
	
	public PaymentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentDetails(String id, int userid, String cardNo, double amounttotal) {
		super();
		this.id = id;
		this.userid = userid;
		this.cardNo = cardNo;
		this.amounttotal = amounttotal;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
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
	
	public double getAmounttotal() {
		return amounttotal;
	}
	public void setAmounttotal(double amounttotal) {
		this.amounttotal = amounttotal;
	}
	
	
	
	

}
