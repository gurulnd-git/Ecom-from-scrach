package com.lynntech.ecom.model.content;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.common.audit.AuditListener;
import com.lynntech.ecom.model.common.audit.AuditSection;
import com.lynntech.ecom.model.generic.SalesManagerEntity;
import com.lynntech.ecom.model.merchant.MerchantStore;


import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "CONTENT",uniqueConstraints=
    @UniqueConstraint(columnNames = {"MERCHANT_ID", "CODE"}) )
public class Content extends SalesManagerEntity<Long, Content> implements Serializable {

	

	private static final long serialVersionUID = 1772757159185494620L;
	
	@Id
	@Column(name = "CONTENT_ID", unique=true, nullable=false)
	private Long id;
	
	@Embedded
	private AuditSection auditSection = new AuditSection();
	
	@Valid
	@OneToMany(mappedBy="content", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ContentDescription> descriptions = new ArrayList<ContentDescription>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="MERCHANT_ID", nullable=false)
	private MerchantStore merchantStore;
	

	@Column(name="CODE", length=100, nullable=false)
	private String code;
	
	@Column(name = "VISIBLE")
	private boolean visible;
	
	@Column(name = "LINK_TO_MENU")
	private boolean linkToMenu;

	@Column(name = "CONTENT_POSITION", length=10, nullable=true)
	@Enumerated(value = EnumType.STRING)
	private ContentPosition contentPosition;
	
	//Used for grouping
	//BOX, SECTION, PAGE
	@Column(name = "CONTENT_TYPE", length=10, nullable=true)
	@Enumerated(value = EnumType.STRING)
	private ContentType contentType; 
	
	@Column(name = "SORT_ORDER")
	private Integer sortOrder = 0;
	
	//A page can contain one product listing
	@Column(name = "PRODUCT_GROUP", nullable = true)
	private String productGroup;

	public String getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

	public void setAuditSection(AuditSection auditSection) {
		this.auditSection = auditSection;
	}

	public AuditSection getAuditSection() {
		return auditSection;
	}

	public MerchantStore getMerchantStore() {
		return merchantStore;
	}

	public void setMerchantStore(MerchantStore merchantStore) {
		this.merchantStore = merchantStore;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}



	public List<ContentDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<ContentDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

	public ContentType getContentType() {
		return contentType;
	}
	
	public ContentDescription getDescription() {
		
		if(this.getDescriptions()!=null && this.getDescriptions().size()>0) {
			return this.getDescriptions().get(0);
		}
		
		return null;
		
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setContentPosition(ContentPosition contentPosition) {
		this.contentPosition = contentPosition;
	}

	public ContentPosition getContentPosition() {
		return contentPosition;
	}
	


	public boolean isLinkToMenu() {
		return linkToMenu;
	}

	public void setLinkToMenu(boolean linkToMenu) {
		this.linkToMenu = linkToMenu;
	}

}