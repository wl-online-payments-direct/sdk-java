package examples;

/**
 * Card details as entered by the customer. Never log or store this object.
 */
public class CardInput {

    private String number;
    private String holderName;
    /** MMYY, e.g. 1230 for December 2030. */
    private String expiryDate;
    private String cvv;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        // Never print card data, also not by accident through logging or string concatenation.
        return "CardInput[masked]";
    }
}
