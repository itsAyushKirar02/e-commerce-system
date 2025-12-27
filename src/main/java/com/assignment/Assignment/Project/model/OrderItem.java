package com.assignment.Assignment.Project.model;

 
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Order_Item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_item_seq_id;
    
    @Column(name = "order_id")
    private Integer orderId; // Foreign key column

    private Integer product_id;
    private Integer quantity;
    private String status;
	public Integer getOrder_item_seq_id() {
		return order_item_seq_id;
	}
	public void setOrder_item_seq_id(Integer order_item_seq_id) {
		this.order_item_seq_id = order_item_seq_id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

    
    
    
 }
