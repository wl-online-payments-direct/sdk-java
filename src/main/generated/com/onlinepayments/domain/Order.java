/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class Order {

    private AdditionalOrderInput additionalInput;

    private AmountOfMoney amountOfMoney;

    private Customer customer;

    private Discount discount;

    private OrderReferences references;

    private Shipping shipping;

    private ShoppingCart shoppingCart;

    private SurchargeSpecificInput surchargeSpecificInput;

    private Long totalTaxAmount;

    /**
     * This object contains additional input on the order.
     */
    public AdditionalOrderInput getAdditionalInput() {
        return additionalInput;
    }

    /**
     * This object contains additional input on the order.
     */
    public void setAdditionalInput(AdditionalOrderInput value) {
        this.additionalInput = value;
    }

    /**
     * This object contains additional input on the order.
     */
    public Order withAdditionalInput(AdditionalOrderInput value) {
        this.additionalInput = value;
        return this;
    }

    /**
     * Object containing amount and ISO currency code attributes
     */
    public AmountOfMoney getAmountOfMoney() {
        return amountOfMoney;
    }

    /**
     * Object containing amount and ISO currency code attributes
     */
    public void setAmountOfMoney(AmountOfMoney value) {
        this.amountOfMoney = value;
    }

    /**
     * Object containing amount and ISO currency code attributes
     */
    public Order withAmountOfMoney(AmountOfMoney value) {
        this.amountOfMoney = value;
        return this;
    }

    /**
     * Object containing the details of the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Object containing the details of the customer
     */
    public void setCustomer(Customer value) {
        this.customer = value;
    }

    /**
     * Object containing the details of the customer
     */
    public Order withCustomer(Customer value) {
        this.customer = value;
        return this;
    }

    /**
     * Object to apply a discount to the total basket by adding a discount line.
     */
    public Discount getDiscount() {
        return discount;
    }

    /**
     * Object to apply a discount to the total basket by adding a discount line.
     */
    public void setDiscount(Discount value) {
        this.discount = value;
    }

    /**
     * Object to apply a discount to the total basket by adding a discount line.
     */
    public Order withDiscount(Discount value) {
        this.discount = value;
        return this;
    }

    /**
     * Object that holds all reference properties that are linked to this transaction
     */
    public OrderReferences getReferences() {
        return references;
    }

    /**
     * Object that holds all reference properties that are linked to this transaction
     */
    public void setReferences(OrderReferences value) {
        this.references = value;
    }

    /**
     * Object that holds all reference properties that are linked to this transaction
     */
    public Order withReferences(OrderReferences value) {
        this.references = value;
        return this;
    }

    /**
     * Object containing information regarding shipping / delivery
     */
    public Shipping getShipping() {
        return shipping;
    }

    /**
     * Object containing information regarding shipping / delivery
     */
    public void setShipping(Shipping value) {
        this.shipping = value;
    }

    /**
     * Object containing information regarding shipping / delivery
     */
    public Order withShipping(Shipping value) {
        this.shipping = value;
        return this;
    }

    /**
     * Shopping cart data, including items and specific amounts.
     */
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    /**
     * Shopping cart data, including items and specific amounts.
     */
    public void setShoppingCart(ShoppingCart value) {
        this.shoppingCart = value;
    }

    /**
     * Shopping cart data, including items and specific amounts.
     */
    public Order withShoppingCart(ShoppingCart value) {
        this.shoppingCart = value;
        return this;
    }

    /**
     * Object containing specific input required to apply surcharging to an order.
     */
    public SurchargeSpecificInput getSurchargeSpecificInput() {
        return surchargeSpecificInput;
    }

    /**
     * Object containing specific input required to apply surcharging to an order.
     */
    public void setSurchargeSpecificInput(SurchargeSpecificInput value) {
        this.surchargeSpecificInput = value;
    }

    /**
     * Object containing specific input required to apply surcharging to an order.
     */
    public Order withSurchargeSpecificInput(SurchargeSpecificInput value) {
        this.surchargeSpecificInput = value;
        return this;
    }

    /**
     * tax amount, in minor currency units of the order. Omit if not applicable or not known. This amount is assumed to be included in the order.AmountOfMoney for the payment. There is no validation on this field, outside the fact the amount should be lower than the total payment amount.
     */
    public Long getTotalTaxAmount() {
        return totalTaxAmount;
    }

    /**
     * tax amount, in minor currency units of the order. Omit if not applicable or not known. This amount is assumed to be included in the order.AmountOfMoney for the payment. There is no validation on this field, outside the fact the amount should be lower than the total payment amount.
     */
    public void setTotalTaxAmount(Long value) {
        this.totalTaxAmount = value;
    }

    /**
     * tax amount, in minor currency units of the order. Omit if not applicable or not known. This amount is assumed to be included in the order.AmountOfMoney for the payment. There is no validation on this field, outside the fact the amount should be lower than the total payment amount.
     */
    public Order withTotalTaxAmount(Long value) {
        this.totalTaxAmount = value;
        return this;
    }
}
