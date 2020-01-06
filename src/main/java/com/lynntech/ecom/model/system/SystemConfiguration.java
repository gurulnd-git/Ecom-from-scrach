package com.lynntech.ecom.model.system;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.common.audit.AuditListener;
import com.lynntech.ecom.model.common.audit.AuditSection;
import com.lynntech.ecom.model.common.audit.Auditable;
import com.lynntech.ecom.model.generic.SalesManagerEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Global system configuration information
 * @author casams1
 *
 */
@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "SYSTEM_CONFIGURATION")
public class SystemConfiguration extends SalesManagerEntity<Long, SystemConfiguration> implements Serializable, Auditable {
	private static final long serialVersionUID = 6831573162350751684L;
	
	@Id
	@Column(name = "SYSTEM_CONFIG_ID")
	private Long id;
	
	@Column(name="CONFIG_KEY")
	private String key;
	
	@Column(name="VALUE")
	private String value;
	
	@Embedded
	private AuditSection auditSection = new AuditSection();

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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
