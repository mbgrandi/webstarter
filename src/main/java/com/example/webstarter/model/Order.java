package com.example.webstarter.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.webstarter.General;

@Entity
@Table(name="orders")
public class Order implements Serializable {

	private static final long serialVersionUID = -9161728791529324284L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="order_number", nullable = false)
	private String orderNumber;
	
	@Column(name="order_date", nullable = false)
	private String orderDate;
	
	private BigDecimal orderTotal;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "orders_customer_id_fk" ))
	private Customer customer;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<OrderProduct> orderProducts = new HashSet<>();
	
	public Order() {
	}
	
	public Order(String orderNumber, String orderDate, Customer customer) {
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.customer = customer;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public Date getOrderDate(String source, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = formatter.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public BigDecimal getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}
	public String getOrderTotalCurrency() {
		String totalCurrency = General.currencyFormat(getOrderTotal());
		return totalCurrency;
	}
	

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", customer="
				+ customer + "]";
	}
}
