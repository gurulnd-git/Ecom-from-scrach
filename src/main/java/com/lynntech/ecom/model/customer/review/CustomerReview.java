package com.lynntech.ecom.model.customer.review;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.common.audit.AuditListener;
import com.lynntech.ecom.model.common.audit.AuditSection;
import com.lynntech.ecom.model.common.audit.Auditable;
import com.lynntech.ecom.model.customer.Customer;
import com.lynntech.ecom.model.generic.SalesManagerEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "CUSTOMER_REVIEW", uniqueConstraints={
		@UniqueConstraint(columnNames={
				"CUSTOMERS_ID",
				"REVIEWED_CUSTOMER_ID"
			})
		}
)
public class CustomerReview extends SalesManagerEntity<Long, CustomerReview> implements Auditable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CUSTOMER_REVIEW_ID", unique=true, nullable=false)
	private Long id;
	
	@Embedded
	private AuditSection audit = new AuditSection();
	
	@Column(name = "REVIEWS_RATING")
	private Double reviewRating;
	
	@Column(name = "REVIEWS_READ")
	private Long reviewRead;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REVIEW_DATE")
	private Date reviewDate;
	
	@Column(name = "STATUS")
	private Integer status;

	@ManyToOne
	@JoinColumn(name="CUSTOMERS_ID")
	private Customer customer;
	

	
	@OneToOne
	@JoinColumn(name="REVIEWED_CUSTOMER_ID")
	private Customer reviewedCustomer;

	public Customer getReviewedCustomer() {
		return reviewedCustomer;
	}

	public void setReviewedCustomer(Customer reviewedCustomer) {
		this.reviewedCustomer = reviewedCustomer;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customerReview")
	private Set<CustomerReviewDescription> descriptions = new HashSet<CustomerReviewDescription>();
	
	public CustomerReview() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getReviewRating() {
		return reviewRating;
	}

	public void setReviewRating(Double reviewRating) {
		this.reviewRating = reviewRating;
	}

	public Long getReviewRead() {
		return reviewRead;
	}

	public void setReviewRead(Long reviewRead) {
		this.reviewRead = reviewRead;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Set<CustomerReviewDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<CustomerReviewDescription> descriptions) {
		this.descriptions = descriptions;
	}
	
	@Override
	public AuditSection getAuditSection() {
		return audit;
	}
	
	@Override
	public void setAuditSection(AuditSection audit) {
		this.audit = audit;
	}
	
	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

}
