package com.lynntech.ecom.model.order.orderstatus;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.order.Order;
import com.lynntech.ecom.utils.CloneUtils;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="ORDER_STATUS_HISTORY" )
public class OrderStatusHistory implements Serializable {
	private static final long serialVersionUID = 3438730310126102187L;
	
	@Id
	@Column( name="ORDER_STATUS_HISTORY_ID")
	private Long id;
	
	@ManyToOne(targetEntity = Order.class)
	@JoinColumn(name = "ORDER_ID", nullable = false)
	private Order order;
	
	@Enumerated(value = EnumType.STRING)
	private OrderStatus status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_ADDED", nullable = false)
	private Date dateAdded;
	
	@Column(name = "CUSTOMER_NOTIFIED")
	private Integer customerNotified;

	@Column(name = "COMMENTS")
	@Type(type = "org.hibernate.type.TextType")
	private String comments;

	public OrderStatusHistory() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Date getDateAdded() {
		return CloneUtils.clone(dateAdded);
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = CloneUtils.clone(dateAdded);
	}

	public Integer getCustomerNotified() {
		return customerNotified;
	}

	public void setCustomerNotified(Integer customerNotified) {
		this.customerNotified = customerNotified;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}