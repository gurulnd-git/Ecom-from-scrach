package com.lynntech.ecom.model.order;

import com.lynntech.ecom.model.common.EntityList;

import java.util.List;

public class OrderList extends EntityList {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6645927228659963628L;
	private List<Order> orders;

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Order> getOrders() {
		return orders;
	}

}
