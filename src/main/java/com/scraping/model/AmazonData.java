package com.scraping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AmazonData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String ProductTitle;
	private String ProductPrice;

	public AmazonData(int id, String productTitle, String productPrice) {
		super();
		this.id = id;
		ProductTitle = productTitle;
		ProductPrice = productPrice;
	}

	public AmazonData() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductTitle() {
		return ProductTitle;
	}

	public void setProductTitle(String productTitle) {
		ProductTitle = productTitle;
	}

	public String getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(String string) {
		ProductPrice = string;
	}

	@Override
	public String toString() {
		return "AmazonData [id=" + id + ", ProductTitle=" + ProductTitle + ", ProductPrice=" + ProductPrice + "]";
	}

}
