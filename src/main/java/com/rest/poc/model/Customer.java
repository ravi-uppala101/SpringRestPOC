package com.rest.poc.model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * customer object for mongodb
 * @author nft887
 *
 */
@Document(collection = "Customers")
@JsonPropertyOrder({"accountId","sortId","rewardsBalance","eligibilityIndicator","transactions"})
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	@JsonIgnore
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private String _id;
	
	@JsonProperty("accountId")
	private String accountId;
	
	@JsonProperty("sortId")
	private String sortId;
	
	@JsonProperty("rewardsBalance")
	private String rewardsBalance;
	
	@JsonProperty("eligibilityInd")
	private String eligibilityInd;
	

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getSortId() {
		return sortId;
	}

	public void setSortId(String sortId) {
		this.sortId = sortId;
	}

	public String getRewardsBalance() {
		return rewardsBalance;
	}

	public void setRewardsBalance(String rewardsBalance) {
		this.rewardsBalance = rewardsBalance;
	}

	public String getEligibilityInd() {
		return eligibilityInd;
	}

	public void setEligibilityInd(String eligibilityInd) {
		this.eligibilityInd = eligibilityInd;
	}


	@Override
	public String toString() {
		return "Customer [_id=" + _id + ", accountId=" + accountId + ", sortId=" + sortId + ", rewardsBalance="
				+ rewardsBalance + ", eligibilityInd=" + eligibilityInd + "]";
	}

}
