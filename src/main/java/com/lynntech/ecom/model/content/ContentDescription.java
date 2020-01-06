package com.lynntech.ecom.model.content;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.common.description.Description;
import com.lynntech.ecom.model.reference.language.Language;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CONTENT_DESCRIPTION",uniqueConstraints={
		@UniqueConstraint(columnNames={
			"CONTENT_ID",
			"LANGUAGE_ID"
		})
	}
)
public class ContentDescription extends Description implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1252756716545768599L;

	@ManyToOne(targetEntity = Content.class)
	@JoinColumn(name = "CONTENT_ID", nullable = false)
	private Content content;

	@Column(name="SEF_URL", length=120)
	private String seUrl;

	
	@Column(name="META_KEYWORDS")
	private String metatagKeywords;
	
	@Column(name="META_TITLE")
	private String metatagTitle;
	
	public String getMetatagTitle() {
		return metatagTitle;
	}

	public void setMetatagTitle(String metatagTitle) {
		this.metatagTitle = metatagTitle;
	}

	@Column(name="META_DESCRIPTION")
	private String metatagDescription;
	
	public ContentDescription() {
	}
	
	public ContentDescription(String name, Language language) {
		this.setName(name);
		this.setLanguage(language);
		super.setId(0L);
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public String getSeUrl() {
		return seUrl;
	}

	public void setSeUrl(String seUrl) {
		this.seUrl = seUrl;
	}


	public String getMetatagKeywords() {
		return metatagKeywords;
	}

	public void setMetatagKeywords(String metatagKeywords) {
		this.metatagKeywords = metatagKeywords;
	}

	public String getMetatagDescription() {
		return metatagDescription;
	}

	public void setMetatagDescription(String metatagDescription) {
		this.metatagDescription = metatagDescription;
	}

}
