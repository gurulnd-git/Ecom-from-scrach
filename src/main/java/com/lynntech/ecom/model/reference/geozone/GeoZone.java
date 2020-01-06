package com.lynntech.ecom.model.reference.geozone;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.generic.SalesManagerEntity;
import com.lynntech.ecom.model.reference.country.Country;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GEOZONE")
// TODO : create DAO / Service
public class GeoZone extends SalesManagerEntity<Long, GeoZone> {
	private static final long serialVersionUID = -5992008645857938825L;
	
	@Id
	@Column(name = "GEOZONE_ID")
	private Long id;
	
	@OneToMany(mappedBy = "geoZone", cascade = CascadeType.ALL)
	private List<GeoZoneDescription> descriptions = new ArrayList<GeoZoneDescription>();
	
	@OneToMany(mappedBy = "geoZone", targetEntity = Country.class)
	private List<Country> countries = new ArrayList<Country>();
	

	
	@Column(name = "GEOZONE_NAME")
	private String name;
	
	@Column(name = "GEOZONE_CODE")
	private String code;
	
	public GeoZone() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public List<GeoZoneDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<GeoZoneDescription> descriptions) {
		this.descriptions = descriptions;
	}


}
