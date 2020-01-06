package com.lynntech.ecom.model.reference.country;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.common.description.Description;
import com.lynntech.ecom.model.reference.language.Language;

import javax.persistence.*;

@Entity
@Table(name = "COUNTRY_DESCRIPTION", uniqueConstraints={
	@UniqueConstraint(columnNames={
			"COUNTRY_ID",
			"LANGUAGE_ID"
		})
	}
)
public class CountryDescription extends Description {
	private static final long serialVersionUID = 9048940117896071174L;
	
	@ManyToOne(targetEntity = Country.class)
	@JoinColumn(name = "COUNTRY_ID", nullable = false)
	private Country country;
	
	public CountryDescription() {
	}
	
	public CountryDescription(Language language, String name) {
		this.setLanguage(language);
		this.setName(name);
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
}
