package com.lynntech.ecom.model.order;

import com.lynntech.ecom.model.common.Criteria;

public class OrderCriteria extends Criteria {
	
	private String customerName;
	private String paymentMethod;
	private Long customerId;
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerName() {
		return customerName;
	}
    public Long getCustomerId()
    {
        return customerId;
    }
    public void setCustomerId( Long customerId )
    {
        this.customerId = customerId;
    }
   
	
	
	

}
