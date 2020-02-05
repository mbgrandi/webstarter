package com.example.webstarter.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.webstarter.General;

@Entity
@Table(name="order_products")
public class OrderProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "order_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "order_products_order_id_fk"))
    private Order order;
 
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "order_products_product_id_fk" ))
    private Product product;
	
    @Column(name="product_quantity", nullable = false)
	private Integer productQuantity;

    public OrderProduct() {
    }
    
	public OrderProduct(Order order, Product product, Integer productQuantity) {
		this.order = order;
		this.product = product;
		this.productQuantity = productQuantity;
	}
	
	public Order getOrder() {
		return order;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	public BigDecimal getProductTotal() {
		BigDecimal total = new BigDecimal(0);
		if (product.getProductPrice() != null && productQuantity != null) {
			total = product.getProductPrice().multiply(new BigDecimal(productQuantity));
		}
		return total;
	}
	
	public String getProductTotalCurrency() {
		String totalCurrency = General.currencyFormat(getProductTotal());
		return totalCurrency;
	}

	@Override
	public int hashCode() {
		return Objects.hash(order.getOrderDate(), order.getOrderNumber(), product.getProductCode(), product.getProductName(), productQuantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof OrderProduct)) return false;
		OrderProduct that = (OrderProduct) obj;
		return 	Objects.equals(order.getOrderDate(), that.order.getOrderDate()) &&
				Objects.equals(order.getOrderNumber(), that.order.getOrderNumber()) &&
				Objects.equals(product.getProductCode(), that.product.getProductCode()) &&
				Objects.equals(product.getProductName(), that.product.getProductName()) &&
				Objects.equals(productQuantity, that.productQuantity);
	}

	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", order=" + order + ", product=" + product + ", productQuantity="
				+ productQuantity + "]";
	}
}
