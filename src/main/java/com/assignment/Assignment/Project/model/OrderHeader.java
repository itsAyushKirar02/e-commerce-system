package com.assignment.Assignment.Project.model;

 
import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Order_Header")
public class OrderHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;
    private Date order_date;
    private Integer customer_id;
    private Integer shipping_contact_mech_id;
    private Integer billing_contact_mech_id;

 
    @OneToMany(mappedBy = "orderId", cascade = CascadeType.REMOVE)
    private List<OrderItem> orderItems;

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public Integer getShipping_contact_mech_id() {
		return shipping_contact_mech_id;
	}

	public void setShipping_contact_mech_id(Integer shipping_contact_mech_id) {
		this.shipping_contact_mech_id = shipping_contact_mech_id;
	}

	public Integer getBilling_contact_mech_id() {
		return billing_contact_mech_id;
	}

	public void setBilling_contact_mech_id(Integer billing_contact_mech_id) {
		this.billing_contact_mech_id = billing_contact_mech_id;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

    
    
    
 }