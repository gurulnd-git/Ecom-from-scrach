package com.lynntech.ecom.model.system;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.common.audit.AuditListener;
import com.lynntech.ecom.model.common.audit.AuditSection;
import com.lynntech.ecom.model.common.audit.Auditable;
import com.lynntech.ecom.model.generic.SalesManagerEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "MODULE_CONFIGURATION")


public class IntegrationModule extends SalesManagerEntity<Long, IntegrationModule> implements Serializable, Auditable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -357523134800965997L;

	@Id
	@Column(name = "MODULE_CONF_ID")
	private Long id;
	
	

	@Column(name="MODULE")
	private String module;
	
	@Column(name="CODE", nullable=false)
	private String code;
	
	@Column(name="REGIONS")
	private String regions;
	
	@Column(name="CONFIGURATION")
	@Type(type = "org.hibernate.type.TextType")
	private String configuration;
	
	@Column(name="DETAILS")
	@Type(type = "org.hibernate.type.TextType")
	private String configDetails;
	
	@Column(name="TYPE")
	private String type;


	@Column(name="IMAGE")
	private String image;
	
	@Column(name="CUSTOM_IND")
	private boolean customModule = false;
	
	@Transient
	private Set<String> regionsSet = new HashSet<String>();
	
	/**
	 * Contains a map of module config by environment (DEV,PROD)
	 */
	@Transient
	private Map<String,ModuleConfig> moduleConfigs = new HashMap<String,ModuleConfig>();
	
	
	@Transient
	private Map<String,String> details = new HashMap<String,String>();

	
	public Map<String, String> getDetails() {
		return details;
	}



	public void setDetails(Map<String, String> details) {
		this.details = details;
	}



	@Embedded
	private AuditSection auditSection = new AuditSection();



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



	public String getModule() {
		return module;
	}



	public void setModule(String module) {
		this.module = module;
	}



	public String getRegions() {
		return regions;
	}



	public void setRegions(String regions) {
		this.regions = regions;
	}



	public String getConfiguration() {
		return configuration;
	}



	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}



	public void setRegionsSet(Set<String> regionsSet) {
		this.regionsSet = regionsSet;
	}



	public Set<String> getRegionsSet() {
		return regionsSet;
	}




	public void setCode(String code) {
		this.code = code;
	}



	public String getCode() {
		return code;
	}



	public void setModuleConfigs(Map<String,ModuleConfig> moduleConfigs) {
		this.moduleConfigs = moduleConfigs;
	}



	public Map<String,ModuleConfig> getModuleConfigs() {
		return moduleConfigs;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getImage() {
		return image;
	}



	public void setCustomModule(boolean customModule) {
		this.customModule = customModule;
	}



	public boolean isCustomModule() {
		return customModule;
	}

	public String getConfigDetails() {
		return configDetails;
	}



	public void setConfigDetails(String configDetails) {
		this.configDetails = configDetails;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getType() {
		return type;
	}



}
