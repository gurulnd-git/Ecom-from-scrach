package com.lynntech.ecom.model.order;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.generic.SalesManagerEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;


/**
 * Order line items related to an order.
 * @author casams1
 *
 */

@Entity
@Table(name="ORDER_TOTAL" )
public class OrderTotal extends SalesManagerEntity<Long, OrderTotal> {
	private static final long serialVersionUID = -5885315557404081674L;
	
	@Id
	@Column(name = "ORDER_ACCOUNT_ID", unique=true, nullable=false)
	private Long id;
	
	@Column(name ="CODE", nullable=false)
	private String orderTotalCode;//SHIPPING, TAX
	
	@Column(name ="TITLE", nullable=true)
	private String title;
	
	@Column(name ="TEXT", nullable=true)
	@Type(type = "org.hibernate.type.TextType")
	private String text;
	
	@Column(name ="VALUE", precision=15, scale=4, nullable=false )
	private BigDecimal value;
	
	@Column(name ="MODULE", length=60 , nullable=true )
	private String module;
	
	@Column(name ="ORDER_VALUE_TYPE")
	@Enumerated(value = EnumType.STRING)
	private OrderValueType orderValueType = OrderValueType.ONE_TIME;
	
	@Column(name ="ORDER_TOTAL_TYPE")
	@Enumerated(value = EnumType.STRING)
	private OrderTotalType orderTotalType = null;
	
	@Column(name ="SORT_ORDER", nullable=false)
	private int sortOrder;
	
	@ManyToOne(targetEntity = Order.class)
	@JoinColumn(name = "ORDER_ID", nullable=false)
	private Order order;
	
	public OrderTotal() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setOrderTotalCode(String orderTotalCode) {
		this.orderTotalCode = orderTotalCode;
	}

	public String getOrderTotalCode() {
		return orderTotalCode;
	}

	public void setOrderValueType(OrderValueType orderValueType) {
		this.orderValueType = orderValueType;
	}

	public OrderValueType getOrderValueType() {
		return orderValueType;
	}

	public void setOrderTotalType(OrderTotalType orderTotalType) {
		this.orderTotalType = orderTotalType;
	}

	public OrderTotalType getOrderTotalType() {
		return orderTotalType;
	}


}