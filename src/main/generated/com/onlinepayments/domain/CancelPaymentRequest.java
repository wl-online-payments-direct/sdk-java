/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

import java.util.List;

public class CancelPaymentRequest {

    private AmountOfMoney amountOfMoney;

    private Boolean isFinal;

    private List<LineItemDetail> lineItemDetails;

    private OperationPaymentReferences operationReferences;

    private ShippingDetail shipping;

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
    public CancelPaymentRequest withAmountOfMoney(AmountOfMoney value) {
        this.amountOfMoney = value;
        return this;
    }

    /**
     * This property indicates whether this will be the final operation. The default value for this property is false.
     */
    public Boolean getIsFinal() {
        return isFinal;
    }

    /**
     * This property indicates whether this will be the final operation. The default value for this property is false.
     */
    public void setIsFinal(Boolean value) {
        this.isFinal = value;
    }

    /**
     * This property indicates whether this will be the final operation. The default value for this property is false.
     */
    public CancelPaymentRequest withIsFinal(Boolean value) {
        this.isFinal = value;
        return this;
    }

    /**
     * List of lineItemIds and quantities for capture/refund/cancellation.
     */
    public List<LineItemDetail> getLineItemDetails() {
        return lineItemDetails;
    }

    /**
     * List of lineItemIds and quantities for capture/refund/cancellation.
     */
    public void setLineItemDetails(List<LineItemDetail> value) {
        this.lineItemDetails = value;
    }

    /**
     * List of lineItemIds and quantities for capture/refund/cancellation.
     */
    public CancelPaymentRequest withLineItemDetails(List<LineItemDetail> value) {
        this.lineItemDetails = value;
        return this;
    }

    /**
     * Object that holds all reference properties that are linked to this transaction
     */
    public OperationPaymentReferences getOperationReferences() {
        return operationReferences;
    }

    /**
     * Object that holds all reference properties that are linked to this transaction
     */
    public void setOperationReferences(OperationPaymentReferences value) {
        this.operationReferences = value;
    }

    /**
     * Object that holds all reference properties that are linked to this transaction
     */
    public CancelPaymentRequest withOperationReferences(OperationPaymentReferences value) {
        this.operationReferences = value;
        return this;
    }

    /**
     * Object containing the details of the shipping of the order
     */
    public ShippingDetail getShipping() {
        return shipping;
    }

    /**
     * Object containing the details of the shipping of the order
     */
    public void setShipping(ShippingDetail value) {
        this.shipping = value;
    }

    /**
     * Object containing the details of the shipping of the order
     */
    public CancelPaymentRequest withShipping(ShippingDetail value) {
        this.shipping = value;
        return this;
    }
}
