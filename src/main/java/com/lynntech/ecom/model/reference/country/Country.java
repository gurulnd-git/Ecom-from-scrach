package com.lynntech.ecom.model.reference.country;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.generic.SalesManagerEntity;
import com.lynntech.ecom.model.reference.geozone.GeoZone;
import com.lynntech.ecom.model.reference.zone.Zone;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COUNTRY")
@Cacheable
public class Country extends SalesManagerEntity<Integer, Country> {
	private static final long serialVersionUID = -7388011537255588035L;

	@Id
	@Column(name="COUNTRY_ID")
	private Integer id;
	
	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
	private Set<CountryDescription> descriptions = new HashSet<CountryDescription>();

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "country")
	private Set<Zone> zones = new HashSet<Zone>();
	
	@ManyToOne(targetEntity = GeoZone.class)
	@JoinColumn(name = "GEOZONE_ID")
	private GeoZone geoZone;
	
	@Column(name = "COUNTRY_SUPPORTED")
	private boolean supported = true;
	
	@Column(name = "COUNTRY_ISOCODE", unique=true, nullable = false)
	private String isoCode;
	
	@Transient
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country() {
	}
	
	public Country(String isoCode) {
		this.setIsoCode(isoCode);
	}
	
	public boolean getSupported() {
		return supported;
	}

	public void setSupported(boolean supported) {
		this.supported = supported;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}


	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}


	public Set<Zone> getZones() {
		return zones;
	}

	public void setZones(Set<Zone> zones) {
		this.zones = zones;
	}


	public GeoZone getGeoZone() {
		return geoZone;
	}

	public void setGeoZone(GeoZone geoZone) {
		this.geoZone = geoZone;
	}
	
	
	public Set<CountryDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<CountryDescription> descriptions) {
		this.descriptions = descriptions;
	}
}
