package com.cmpe202.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ItemsDetails")
public class ItemsDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	String id;
	@Column(name = "name")
	String name;
	@Column(name = "itemprice")
	double itemprice;
	@Column(name = "itemsize")
	String itemsize;

	@Override
	public String toString() {
		return "ItemsDetails [id=" + id + ", name=" + name + ", itemprice=" + itemprice + ", itemsize=" + itemsize
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getItemprice() {
		return itemprice;
	}

	public void setItemprice(double itemprice) {
		this.itemprice = itemprice;
	}

	public String getItemsize() {
		return itemsize;
	}

	public void setItemsize(String itemsize) {
		this.itemsize = itemsize;
	}



	
	
	
	
	

}
