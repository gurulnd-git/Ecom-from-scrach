package com.lynntech.ecom.model.catalog.product.type;

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
@Table(name = "PRODUCT_TYPE")
public class ProductType extends SalesManagerEntity<Long, ProductType> implements Auditable {
  private static final long serialVersionUID = 65541494628227593L;

  public final static String GENERAL_TYPE = "GENERAL";

  @Id
  @Column(name = "PRODUCT_TYPE_ID", unique = true, nullable = false)
  private Long id;

  @Embedded
  private AuditSection auditSection = new AuditSection();
  
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productType")
  private Set<ProductTypeDescription> descriptions = new HashSet<ProductTypeDescription>();

  @Column(name = "PRD_TYPE_CODE")
  private String code;

  @Column(name = "PRD_TYPE_ADD_TO_CART")
  private Boolean allowAddToCart;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MERCHANT_ID", nullable = true)
  private MerchantStore merchantStore;

  public ProductType() {}

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

  public boolean isAllowAddToCart() {
    return allowAddToCart;
  }

  public void setAllowAddToCart(boolean allowAddToCart) {
    this.allowAddToCart = allowAddToCart;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Boolean getAllowAddToCart() {
    return allowAddToCart;
  }

  public void setAllowAddToCart(Boolean allowAddToCart) {
    this.allowAddToCart = allowAddToCart;
  }

  public MerchantStore getMerchantStore() {
    return merchantStore;
  }

  public void setMerchantStore(MerchantStore merchantStore) {
    this.merchantStore = merchantStore;
  }


}
