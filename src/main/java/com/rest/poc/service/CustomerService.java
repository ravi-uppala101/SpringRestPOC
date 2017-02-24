package com.rest.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.rest.poc.model.Customer;
import com.rest.poc.utils.RewardsUtils;
/**
 * Customer service class to serve the customer related CRUP operaitons
 * @author nft887
 *
 */
@Service
public class CustomerService {
	@Autowired
	RewardsUtils rewardsUtil;
	/**
	 * finding the customer by account id
	 * @param customer
	 * @return
	 */
	public Customer selectCustomer(Customer customer){
		Query query = new Query();
		query.addCriteria(Criteria.where("accountId").is(customer.getAccountId()));
		return rewardsUtil.getMongoOperations().findOne(query, Customer.class);
	}
	/**
	 * inserting the customer
	 * @param customer
	 */
	public void insertCustomer(Customer customer){
		rewardsUtil.getMongoOperations().save(customer);
	}
	/**
	 * update customer in the database
	 * @param customer
	 */
	public void updateCustomer(Customer customer){
		Query query = new Query();
		query.addCriteria(Criteria.where("accountId").is(customer.getAccountId()));
		Update update = new Update();
		update.set("accountId", customer.getAccountId());
		update.set("sortId", customer.getSortId());
		update.set("rewardsBalance", customer.getRewardsBalance());
		update.set("eligibilityInd", customer.getEligibilityInd());
		rewardsUtil.getMongoOperations().updateFirst(query, update, Customer.class);
	}
	/**
	 * delete customer in the database
	 * @param customer
	 */
	public void deleteCustomer(Customer customer){
		Query query = new Query();
		query.addCriteria(Criteria.where("accountId").is(customer.getAccountId()));
		rewardsUtil.getMongoOperations().findAndRemove(query, Customer.class);
	}
	
	public RewardsUtils getRewardsUtil() {
		return rewardsUtil;
	}
	public void setRewardsUtil(RewardsUtils rewardsUtil) {
		this.rewardsUtil = rewardsUtil;
	}
	
	
}
