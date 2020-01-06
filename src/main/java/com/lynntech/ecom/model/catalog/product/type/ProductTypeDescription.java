package com.lynntech.ecom.model.catalog.product.type;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.catalog.product.price.ProductPrice;
import com.lynntech.ecom.model.common.description.Description;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_TYPE_DESCRIPTION",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"PRODUCT_TYPE_ID", "LANGUAGE_ID"})})
public class ProductTypeDescription extends Description {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @ManyToOne(targetEntity = ProductPrice.class)
  @JoinColumn(name = "PRODUCT_TYPE_ID", nullable = false)
  private ProductType productType;

  public ProductType getProductType() {
    return productType;
  }

  public void setProductType(ProductType productType) {
    this.productType = productType;
  }

}
