package com.lynntech.ecom.model.customer.attribute;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.generic.SalesManagerEntity;

import javax.persistence.*;

@Entity
@Table(name="CUSTOMER_OPTION_SET",
	uniqueConstraints={
		@UniqueConstraint(columnNames={
				"CUSTOMER_OPTION_ID",
				"CUSTOMER_OPTION_VALUE_ID"
			})
	}
)
public class CustomerOptionSet extends SalesManagerEntity<Long, CustomerOptionSet> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CUSTOMER_OPTIONSET_ID", unique=true, nullable=false)
	private Long id;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_OPTION_ID", nullable=false)
	private CustomerOption customerOption = null;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_OPTION_VALUE_ID", nullable=false)
	private CustomerOptionValue customerOptionValue = null;
	


	@Column(name="SORT_ORDER")
	private Integer sortOrder = new Integer(0);
	


	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public void setCustomerOptionValue(CustomerOptionValue customerOptionValue) {
		this.customerOptionValue = customerOptionValue;
	}

	public CustomerOptionValue getCustomerOptionValue() {
		return customerOptionValue;
	}

	public void setCustomerOption(CustomerOption customerOption) {
		this.customerOption = customerOption;
	}

	public CustomerOption getCustomerOption() {
		return customerOption;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}


}
