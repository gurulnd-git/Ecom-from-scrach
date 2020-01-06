package com.lynntech.ecom.model.shoppingcart;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.catalog.product.attribute.ProductAttribute;
import com.lynntech.ecom.model.common.audit.AuditListener;
import com.lynntech.ecom.model.common.audit.AuditSection;
import com.lynntech.ecom.model.common.audit.Auditable;
import com.lynntech.ecom.model.generic.SalesManagerEntity;

import javax.persistence.*;


@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "SHOPPING_CART_ATTR_ITEM")
public class ShoppingCartAttributeItem extends SalesManagerEntity<Long, ShoppingCartAttributeItem> implements Auditable {


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SHP_CART_ATTR_ITEM_ID", unique=true, nullable=false)
	private Long id;

	@Embedded
	private AuditSection auditSection = new AuditSection();
	

	
	@Column(name="PRODUCT_ATTR_ID", nullable=false)
	private Long productAttributeId;
	
	@Transient
	private ProductAttribute productAttribute;
	

	
	@ManyToOne(targetEntity = ShoppingCartItem.class)
	@JoinColumn(name = "SHP_CART_ITEM_ID", nullable = false)
	private ShoppingCartItem shoppingCartItem;
	
	public ShoppingCartAttributeItem(ShoppingCartItem shoppingCartItem, ProductAttribute productAttribute) {
		this.shoppingCartItem = shoppingCartItem;
		this.productAttribute = productAttribute;
		this.productAttributeId = productAttribute.getId();
	}
	
	public ShoppingCartAttributeItem() {

	}
	
	

	public ShoppingCartItem getShoppingCartItem() {
		return shoppingCartItem;
	}

	public void setShoppingCartItem(ShoppingCartItem shoppingCartItem) {
		this.shoppingCartItem = shoppingCartItem;
	}

	@Override
	public AuditSection getAuditSection() {
		return auditSection;
	}

	@Override
	public void setAuditSection(AuditSection audit) {
		this.auditSection = audit;
		
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}


	public void setProductAttributeId(Long productAttributeId) {
		this.productAttributeId = productAttributeId;
	}

	public Long getProductAttributeId() {
		return productAttributeId;
	}

	public void setProductAttribute(ProductAttribute productAttribute) {
		this.productAttribute = productAttribute;
	}

	public ProductAttribute getProductAttribute() {
		return productAttribute;
	}


}
