package com.lynntech.ecom.model.reference.language;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.common.audit.AuditListener;
import com.lynntech.ecom.model.common.audit.AuditSection;
import com.lynntech.ecom.model.common.audit.Auditable;
import com.lynntech.ecom.model.generic.SalesManagerEntity;
import com.lynntech.ecom.model.merchant.MerchantStore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "LANGUAGE")
@Cacheable
public class Language extends SalesManagerEntity<Integer, Language> implements Auditable {
  private static final long serialVersionUID = -7676627812941330669L;



  @Id
  @Column(name = "LANGUAGE_ID")
  private Integer id;

  @Embedded
  private AuditSection auditSection = new AuditSection();

  @Column(name = "CODE", nullable = false)
  private String code;

  @Column(name = "SORT_ORDER")
  private Integer sortOrder;

  @OneToMany(mappedBy = "defaultLanguage", targetEntity = MerchantStore.class)
  private List<MerchantStore> storesDefaultLanguage;

  @ManyToMany(mappedBy = "languages", targetEntity = MerchantStore.class, fetch = FetchType.LAZY)
  private List<MerchantStore> stores = new ArrayList<MerchantStore>();

  public Language() {}

  public Language(String code) {
    this.setCode(code);
  }

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Integer getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(Integer sortOrder) {
    this.sortOrder = sortOrder;
  }

  @Override
  public AuditSection getAuditSection() {
    return auditSection;
  }

  @Override
  public void setAuditSection(AuditSection auditSection) {
    this.auditSection = auditSection;
  }

  @Override
  public boolean equals(Object obj) {
    if (null == obj)
      return false;
    if (!(obj instanceof Language)) {
      return false;
    } else {
      Language language = (Language) obj;
      return (this.id == language.getId());
    }
  }
}
