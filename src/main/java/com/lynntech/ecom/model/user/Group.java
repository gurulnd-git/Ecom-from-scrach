package com.lynntech.ecom.model.user;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.common.audit.AuditListener;
import com.lynntech.ecom.model.common.audit.AuditSection;
import com.lynntech.ecom.model.common.audit.Auditable;
import com.lynntech.ecom.model.generic.SalesManagerEntity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "SM_GROUP")
public class Group extends SalesManagerEntity<Integer, Group> implements Auditable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3786127652573709701L;
	@Id
	@Column(name = "GROUP_ID", unique=true, nullable=false)
	private Integer id;
	
	public Group() {
		
	}

	@Column(name ="GROUP_TYPE")
	@Enumerated(value = EnumType.STRING)
	private GroupType groupType;
	

	@Column(name="GROUP_NAME", unique=true)
	private String groupName;
	
	public Group(String groupName) {
		this.groupName = groupName;
	}
	
	@ManyToMany(mappedBy = "groups")//TODO LAZY LOAD
	private Set<Permission> permissions = new HashSet<Permission>();	
	
	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	@Embedded
	private AuditSection auditSection = new AuditSection();
	
	
	@Override
	public AuditSection getAuditSection() {
		return this.auditSection;
	}

	@Override
	public void setAuditSection(AuditSection audit) {
			this.auditSection = audit;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setGroupType(GroupType groupType) {
		this.groupType = groupType;
	}

	public GroupType getGroupType() {
		return groupType;
	}



}
