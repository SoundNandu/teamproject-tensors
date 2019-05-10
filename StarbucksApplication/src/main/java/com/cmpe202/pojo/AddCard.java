package com.cmpe202.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CardDetails")
public class AddCard  implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8252899578975938914L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	String id;
	@Column(name = "cardNo")
	String cardNo;
	@Column(name = "codeNo")
	String codeNo;
	@Column(name = "balance")
	double balance;
	@Column(name = "userid")
	int userid;
	

	public AddCard(String id, String cardNo, String codeNo, double balance, int userid) {
		super();
		this.id = id;
		this.cardNo = cardNo;
		this.codeNo = codeNo;
		this.balance = balance;
		this.userid = userid;
	}
	public AddCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AddCard [id=" + id + ", cardNo=" + cardNo + ", codeNo=" + codeNo + ", balance=" + balance + ", userid="
				+ userid + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCodeNo() {
		return codeNo;
	}
	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}


	
	
	
}
