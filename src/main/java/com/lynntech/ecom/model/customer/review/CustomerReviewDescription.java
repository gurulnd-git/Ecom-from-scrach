/*
 * Licensed to csti consulting 
 * You may obtain a copy of the License at
 *
 * http://www.csticonsulting.com
 * Copyright (c) 2006-Aug 24, 2010 Consultation CS-TI inc. 
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.lynntech.ecom.model.customer.review;

import com.lynntech.ecom.constants.SchemaConstant;
import com.lynntech.ecom.model.common.description.Description;
import com.lynntech.ecom.model.reference.language.Language;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER_REVIEW_DESCRIPTION", uniqueConstraints={
	@UniqueConstraint(columnNames={
		"CUSTOMER_REVIEW_ID",
		"LANGUAGE_ID"
	})
})
public class CustomerReviewDescription extends Description {
	private static final long serialVersionUID = -1L;

	@ManyToOne(targetEntity = CustomerReview.class)
	@JoinColumn(name="CUSTOMER_REVIEW_ID")
	private CustomerReview customerReview;

	public CustomerReview getCustomerReview() {
		return customerReview;
	}

	public void setCustomerReview(CustomerReview customerReview) {
		this.customerReview = customerReview;
	}

	public CustomerReviewDescription() {
	}

	public CustomerReviewDescription(Language language, String name) {
		this.setLanguage(language);
		this.setName(name);
	}


}
