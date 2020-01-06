package com.lynntech.ecom.model.customer.attribute;

import com.lynntech.ecom.model.generic.SalesManagerEntity;
import com.lynntech.ecom.model.merchant.MerchantStore;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="CUSTOMER_OPTION_VALUE", indexes = { @Index(name="CUST_OPT_VAL_CODE_IDX",columnList = "CUSTOMER_OPT_VAL_CODE")}, uniqueConstraints=
	@UniqueConstraint(columnNames = {"MERCHANT_ID", "CUSTOMER_OPT_VAL_CODE"}))
public class CustomerOptionValue extends SalesManagerEntity<Long, CustomerOptionValue> {
	private static final long serialVersionUID = 3736085877929910891L;

	@Id
	@Column(name="CUSTOMER_OPTION_VALUE_ID")
	private Long id;
	
	@Column(name="SORT_ORDER")
	private Integer sortOrder = 0;
	
	@Column(name="CUSTOMER_OPT_VAL_IMAGE")
	private String customerOptionValueImage;
	
	@Pattern(regexp="^[a-zA-Z0-9_]*$")
	@Column(name="CUSTOMER_OPT_VAL_CODE")
	private String code;
	
	
	@Valid
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customerOptionValue")
	private Set<CustomerOptionValueDescription> descriptions = new HashSet<CustomerOptionValueDescription>();
	
	@Transient
	private List<CustomerOptionValueDescription> descriptionsList = new ArrayList<CustomerOptionValueDescription>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="MERCHANT_ID", nullable=false)
	private MerchantStore merchantStore;

	public CustomerOptionValue() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}


	public Set<CustomerOptionValueDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<CustomerOptionValueDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public MerchantStore getMerchantStore() {
		return merchantStore;
	}

	public void setMerchantStore(MerchantStore merchantStore) {
		this.merchantStore = merchantStore;
	}

	public void setDescriptionsList(List<CustomerOptionValueDescription> descriptionsList) {
		this.descriptionsList = descriptionsList;
	}

	public List<CustomerOptionValueDescription> getDescriptionsList() {
		return descriptionsList; 
	}
	
	public List<CustomerOptionValueDescription> getDescriptionsSettoList() {
		if(descriptionsList==null || descriptionsList.size()==0) {
			descriptionsList = new ArrayList<CustomerOptionValueDescription>(this.getDescriptions());
		} 
		return descriptionsList;
	}

	//public void setImage(MultipartFile image) {
	//	this.image = image;
	//}

	//public MultipartFile getImage() {
	//	return image;
	//}


	public String getCustomerOptionValueImage() {
		return customerOptionValueImage;
	}

	public void setCustomerOptionValueImage(String customerOptionValueImage) {
		this.customerOptionValueImage = customerOptionValueImage;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}
	



}
