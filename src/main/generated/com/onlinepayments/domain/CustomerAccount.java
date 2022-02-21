/*
 * This class was auto-generated.
 */
package com.onlinepayments.domain;

/**
 * Object containing data related to the account the customer has with you
 */
public class CustomerAccount {

	private CustomerAccountAuthentication authentication = null;

	private String changeDate = null;

	private Boolean changedDuringCheckout = null;

	private String createDate = null;

	private Boolean hadSuspiciousActivity = null;

	private String passwordChangeDate = null;

	private Boolean passwordChangedDuringCheckout = null;

	private PaymentAccountOnFile paymentAccountOnFile = null;

	private CustomerPaymentActivity paymentActivity = null;

	/**
	 * Object containing data on the authentication used by the customer to access their account
	 */
	public CustomerAccountAuthentication getAuthentication() {
		return authentication;
	}

	/**
	 * Object containing data on the authentication used by the customer to access their account
	 */
	public void setAuthentication(CustomerAccountAuthentication value) {
		this.authentication = value;
	}

	/**
	 * Object containing data on the authentication used by the customer to access their account
	 */
	public CustomerAccount withAuthentication(CustomerAccountAuthentication value) {
		this.authentication = value;
		return this;
	}

	/**
	 * The last date (YYYYMMDD) on which the customer made changes to their account with you. These are changes to billing &amp; shipping address details, new payment account (tokens), or new users(s) added.
	 */
	public String getChangeDate() {
		return changeDate;
	}

	/**
	 * The last date (YYYYMMDD) on which the customer made changes to their account with you. These are changes to billing &amp; shipping address details, new payment account (tokens), or new users(s) added.
	 */
	public void setChangeDate(String value) {
		this.changeDate = value;
	}

	/**
	 * The last date (YYYYMMDD) on which the customer made changes to their account with you. These are changes to billing &amp; shipping address details, new payment account (tokens), or new users(s) added.
	 */
	public CustomerAccount withChangeDate(String value) {
		this.changeDate = value;
		return this;
	}

	/**
	 * * true = the customer made changes to their account during this checkout
	 * * false = the customer didn't change anything to their account during this checkout/n
	 * 
	 *  The changes ment here are changes to billing &amp; shipping address details, new payment account (tokens), or new users(s) added.
	 */
	public Boolean getChangedDuringCheckout() {
		return changedDuringCheckout;
	}

	/**
	 * * true = the customer made changes to their account during this checkout
	 * * false = the customer didn't change anything to their account during this checkout/n
	 * 
	 *  The changes ment here are changes to billing &amp; shipping address details, new payment account (tokens), or new users(s) added.
	 */
	public void setChangedDuringCheckout(Boolean value) {
		this.changedDuringCheckout = value;
	}

	/**
	 * * true = the customer made changes to their account during this checkout
	 * * false = the customer didn't change anything to their account during this checkout/n
	 * 
	 *  The changes ment here are changes to billing &amp; shipping address details, new payment account (tokens), or new users(s) added.
	 */
	public CustomerAccount withChangedDuringCheckout(Boolean value) {
		this.changedDuringCheckout = value;
		return this;
	}

	/**
	 * The date (YYYYMMDD) on which the customer created their account with you
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * The date (YYYYMMDD) on which the customer created their account with you
	 */
	public void setCreateDate(String value) {
		this.createDate = value;
	}

	/**
	 * The date (YYYYMMDD) on which the customer created their account with you
	 */
	public CustomerAccount withCreateDate(String value) {
		this.createDate = value;
		return this;
	}

	/**
	 * Specifies if you have experienced suspicious activity on the account of the customer
	 * 
	 * true = you have experienced suspicious activity (including previous fraud) on the customer account used for this transaction
	 * 
	 * false = you have experienced no suspicious activity (including previous fraud) on the customer account used for this transaction
	 */
	public Boolean getHadSuspiciousActivity() {
		return hadSuspiciousActivity;
	}

	/**
	 * Specifies if you have experienced suspicious activity on the account of the customer
	 * 
	 * true = you have experienced suspicious activity (including previous fraud) on the customer account used for this transaction
	 * 
	 * false = you have experienced no suspicious activity (including previous fraud) on the customer account used for this transaction
	 */
	public void setHadSuspiciousActivity(Boolean value) {
		this.hadSuspiciousActivity = value;
	}

	/**
	 * Specifies if you have experienced suspicious activity on the account of the customer
	 * 
	 * true = you have experienced suspicious activity (including previous fraud) on the customer account used for this transaction
	 * 
	 * false = you have experienced no suspicious activity (including previous fraud) on the customer account used for this transaction
	 */
	public CustomerAccount withHadSuspiciousActivity(Boolean value) {
		this.hadSuspiciousActivity = value;
		return this;
	}

	/**
	 * The last date (YYYYMMDD) on which the customer changed their password for the account used in this transaction
	 */
	public String getPasswordChangeDate() {
		return passwordChangeDate;
	}

	/**
	 * The last date (YYYYMMDD) on which the customer changed their password for the account used in this transaction
	 */
	public void setPasswordChangeDate(String value) {
		this.passwordChangeDate = value;
	}

	/**
	 * The last date (YYYYMMDD) on which the customer changed their password for the account used in this transaction
	 */
	public CustomerAccount withPasswordChangeDate(String value) {
		this.passwordChangeDate = value;
		return this;
	}

	/**
	 * Indicates if the password of an account is changed during this checkout
	 * 
	 * true = the customer made changes to their password of the account used during this checkout
	 * 
	 * false = the customer didn't change anything to their password of the account used during this checkout
	 */
	public Boolean getPasswordChangedDuringCheckout() {
		return passwordChangedDuringCheckout;
	}

	/**
	 * Indicates if the password of an account is changed during this checkout
	 * 
	 * true = the customer made changes to their password of the account used during this checkout
	 * 
	 * false = the customer didn't change anything to their password of the account used during this checkout
	 */
	public void setPasswordChangedDuringCheckout(Boolean value) {
		this.passwordChangedDuringCheckout = value;
	}

	/**
	 * Indicates if the password of an account is changed during this checkout
	 * 
	 * true = the customer made changes to their password of the account used during this checkout
	 * 
	 * false = the customer didn't change anything to their password of the account used during this checkout
	 */
	public CustomerAccount withPasswordChangedDuringCheckout(Boolean value) {
		this.passwordChangedDuringCheckout = value;
		return this;
	}

	/**
	 * Object containing information on the payment account data on file (tokens)
	 */
	public PaymentAccountOnFile getPaymentAccountOnFile() {
		return paymentAccountOnFile;
	}

	/**
	 * Object containing information on the payment account data on file (tokens)
	 */
	public void setPaymentAccountOnFile(PaymentAccountOnFile value) {
		this.paymentAccountOnFile = value;
	}

	/**
	 * Object containing information on the payment account data on file (tokens)
	 */
	public CustomerAccount withPaymentAccountOnFile(PaymentAccountOnFile value) {
		this.paymentAccountOnFile = value;
		return this;
	}

	/**
	 * Object containing data on the purchase history of the customer with you
	 */
	public CustomerPaymentActivity getPaymentActivity() {
		return paymentActivity;
	}

	/**
	 * Object containing data on the purchase history of the customer with you
	 */
	public void setPaymentActivity(CustomerPaymentActivity value) {
		this.paymentActivity = value;
	}

	/**
	 * Object containing data on the purchase history of the customer with you
	 */
	public CustomerAccount withPaymentActivity(CustomerPaymentActivity value) {
		this.paymentActivity = value;
		return this;
	}
}
