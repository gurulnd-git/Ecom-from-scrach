package com.lynntech.ecom.model.system;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.common.audit.AuditListener;
import com.lynntech.ecom.model.common.audit.AuditSection;
import com.lynntech.ecom.model.common.audit.Auditable;
import com.lynntech.ecom.model.generic.SalesManagerEntity;
import com.lynntech.ecom.model.merchant.MerchantStore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Merchant configuration information
 * 
 * @author Carl Samson
 *
 */
@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "MERCHANT_CONFIGURATION",
    uniqueConstraints = @UniqueConstraint(columnNames = {"MERCHANT_ID", "CONFIG_KEY"}))
public class MerchantConfiguration extends SalesManagerEntity<Long, MerchantConfiguration>
    implements Serializable, Auditable {

  /**
   * 
   */
  private static final long serialVersionUID = 4246917986731953459L;

  @Id
  @Column(name = "MERCHANT_CONFIG_ID")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MERCHANT_ID", nullable = true)
  private MerchantStore merchantStore;

  @Embedded
  private AuditSection auditSection = new AuditSection();

  @Column(name = "CONFIG_KEY")
  private String key;

  /**
   * activate and deactivate configuration
   */
  @Column(name = "ACTIVE", nullable = true)
  private Boolean active = new Boolean(false);


  @Column(name = "VALUE")
  @Type(type = "org.hibernate.type.TextType")
  private String value;

  @Column(name = "TYPE")
  @Enumerated(value = EnumType.STRING)
  private MerchantConfigurationType merchantConfigurationType =
      MerchantConfigurationType.INTEGRATION;

  public void setKey(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public AuditSection getAuditSection() {
    return auditSection;
  }

  public void setAuditSection(AuditSection auditSection) {
    this.auditSection = auditSection;
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }



  public MerchantStore getMerchantStore() {
    return merchantStore;
  }

  public void setMerchantStore(MerchantStore merchantStore) {
    this.merchantStore = merchantStore;
  }

  public void setMerchantConfigurationType(MerchantConfigurationType merchantConfigurationType) {
    this.merchantConfigurationType = merchantConfigurationType;
  }

  public MerchantConfigurationType getMerchantConfigurationType() {
    return merchantConfigurationType;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }


}
