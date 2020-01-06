package com.lynntech.ecom.model.catalog.product.attribute;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.common.description.Description;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_OPTION_VALUE_DESCRIPTION", uniqueConstraints={
	@UniqueConstraint(columnNames={
			"PRODUCT_OPTION_VALUE_ID",
			"LANGUAGE_ID"
		})
	}
)
public class ProductOptionValueDescription extends Description {
	private static final long serialVersionUID = 7402155175956813576L;
	
	@ManyToOne(targetEntity = ProductOptionValue.class)
	@JoinColumn(name = "PRODUCT_OPTION_VALUE_ID")
	private ProductOptionValue productOptionValue;
	
	public ProductOptionValueDescription() {
	}

	public ProductOptionValue getProductOptionValue() {
		return productOptionValue;
	}

	public void setProductOptionValue(ProductOptionValue productOptionValue) {
		this.productOptionValue = productOptionValue;
	}

}
