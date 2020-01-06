package com.lynntech.ecom.model.shoppingcart;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.catalog.product.Product;
import com.lynntech.ecom.model.catalog.product.price.FinalPrice;
import com.lynntech.ecom.model.common.audit.AuditListener;
import com.lynntech.ecom.model.common.audit.AuditSection;
import com.lynntech.ecom.model.common.audit.Auditable;
import com.lynntech.ecom.model.generic.SalesManagerEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "SHOPPING_CART_ITEM")
public class ShoppingCartItem extends SalesManagerEntity<Long, ShoppingCartItem> implements Auditable, Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SHP_CART_ITEM_ID", unique=true, nullable=false)
	private Long id;
	
	@ManyToOne(targetEntity = ShoppingCart.class)
	@JoinColumn(name = "SHP_CART_ID", nullable = false)
	private ShoppingCart shoppingCart;

	@Column(name="QUANTITY")
	private Integer quantity = new Integer(1);


	@Embedded
	private AuditSection auditSection = new AuditSection();
	
	@Column(name="PRODUCT_ID", nullable=false) //TODO CODE
	private Long productId;
	
	@Transient
	private boolean productVirtual;

	//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true, mappedBy = "shoppingCartItem")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "shoppingCartItem")
	private Set<ShoppingCartAttributeItem> attributes = new HashSet<ShoppingCartAttributeItem>();
	
	@Transient
	private BigDecimal itemPrice;//item final price including all rebates
	
	@Transient
	private BigDecimal subTotal;//item final price * quantity
	
	@Transient
	private FinalPrice finalPrice;//contains price details (raw prices)
	

	@Transient
	private Product product;
	
	@Transient
	private boolean obsolete = false;




	public ShoppingCartItem(ShoppingCart shoppingCart, Product product) {
		this.product = product;
		this.productId = product.getId();
		this.quantity = 1;
		this.shoppingCart = shoppingCart;
		
	}
	
	public ShoppingCartItem(Product product) {
		this.product = product;
		this.productId = product.getId();
		this.quantity = 1;

	}
	
	public ShoppingCartItem() {
		
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



	public void setAttributes(Set<ShoppingCartAttributeItem> attributes) {
		this.attributes = attributes;
	}

	public Set<ShoppingCartAttributeItem> getAttributes() {
		return attributes;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}



	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}
	
	public void addAttributes(ShoppingCartAttributeItem shoppingCartAttributeItem)
	{
	    this.attributes.add(shoppingCartAttributeItem);
	}
	
	public void removeAttributes(ShoppingCartAttributeItem shoppingCartAttributeItem)
	{
	    this.attributes.remove(shoppingCartAttributeItem);
	}

	public void removeAllAttributes(){
		this.attributes.removeAll(Collections.EMPTY_SET);
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setFinalPrice(FinalPrice finalPrice) {
		this.finalPrice = finalPrice;
	}

	public FinalPrice getFinalPrice() {
		return finalPrice;
	}
	
	public boolean isObsolete() {
		return obsolete;
	}

	public void setObsolete(boolean obsolete) {
		this.obsolete = obsolete;
	}
	

	public boolean isProductVirtual() {
		return productVirtual;
	}

	public void setProductVirtual(boolean productVirtual) {
		this.productVirtual = productVirtual;
	}

}
