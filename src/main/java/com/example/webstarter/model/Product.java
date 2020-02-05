package com.example.webstarter.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.webstarter.General;

@Entity
@Table(name="products")
public class Product implements Serializable {
	
	private static final long serialVersionUID = -1216099801526996851L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="product_code", nullable = false)
	private String productCode;
	
	@Column(name="product_name", nullable = false)
	private String productName;
	
	@Column(name="product_price", nullable = false)
	private BigDecimal productPrice;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<OrderProduct> orderProducts = new HashSet<>();
	
	public Product() {
	}
	
	public Product(String productCode, String productName, BigDecimal productPrice) {
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	
	public String getProductPriceCurrency() {
		String priceCurrency = null;
		if (productPrice != null) {
			priceCurrency = General.currencyFormat(productPrice);
		}
		return priceCurrency;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productCode=" + productCode + ", productName=" + productName + ", productPrice="
				+ productPrice + "]";
	}
}
