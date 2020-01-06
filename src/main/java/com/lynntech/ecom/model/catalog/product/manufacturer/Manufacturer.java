package com.lynntech.ecom.model.catalog.product.manufacturer;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.common.audit.AuditListener;
import com.lynntech.ecom.model.common.audit.AuditSection;
import com.lynntech.ecom.model.common.audit.Auditable;
import com.lynntech.ecom.model.generic.SalesManagerEntity;
import com.lynntech.ecom.model.merchant.MerchantStore;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "MANUFACTURER", uniqueConstraints=
@UniqueConstraint(columnNames = {"MERCHANT_ID", "CODE"}) )
public class Manufacturer extends SalesManagerEntity<Long, Manufacturer> implements Auditable {
	private static final long serialVersionUID = 80693964563570099L;
	
	public static final String DEFAULT_MANUFACTURER = "DEFAULT";
	
	@Id
	@Column(name = "MANUFACTURER_ID", unique=true, nullable=false)
	private Long id;
	
	@Embedded
	private AuditSection auditSection = new AuditSection();
	
	@OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private Set<ManufacturerDescription> descriptions = new HashSet<ManufacturerDescription>();
	
	@Column(name = "MANUFACTURER_IMAGE")
	private String image;
	
	@Column(name="SORT_ORDER")
	private Integer order = new Integer(0);

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="MERCHANT_ID", nullable=false)
	private MerchantStore merchantStore;
	

	@Column(name="CODE", length=100, nullable=false)
	private String code;

	public Manufacturer() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public AuditSection getAuditSection() {
		return auditSection;
	}
	
	@Override
	public void setAuditSection(AuditSection auditSection) {
		this.auditSection = auditSection;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Set<ManufacturerDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<ManufacturerDescription> descriptions) {
		this.descriptions = descriptions;
	}



	public MerchantStore getMerchantStore() {
		return merchantStore;
	}

	public void setMerchantStore(MerchantStore merchantStore) {
		this.merchantStore = merchantStore;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getOrder() {
		return order;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


}
