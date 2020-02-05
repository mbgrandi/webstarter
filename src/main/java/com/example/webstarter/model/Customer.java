package com.example.webstarter.model;

import java.io.Serializable;
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

@Entity
@Table(name = "customers")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 5776016415467057570L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="customer_code", nullable = false)
	private String customerCode;
	
	@Column(name="customer_first_name", nullable = false)
	private String customerFirstName;
	
	@Column(name="customer_last_name", nullable = false)
	private String customerLastName;
	
	@Column(name="shipping_address", nullable = false)
	private String shippingAddress;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Order> orders = new HashSet<>();
	
	public Customer() {
	}
	
	public Customer(String customerCode, String customerFirstName, String customerLastName, String shippingAddress) {
		this.customerCode = customerCode;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.shippingAddress = shippingAddress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerCode=" + customerCode + ", customerFirstName=" + customerFirstName
				+ ", customerLastName=" + customerLastName + ", shippingAddress=" + shippingAddress + "]";
	}

}
