/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class CardFraudResults {

    private String avsResult;

    private String cvvResult;

    private String fraudServiceResult;

    /**
     * Result of the Address Verification Service checks. Possible values are:
     * <ul>
     *   <li>A - Address (Street) matches, Zip does not</li>
     *   <li>B - Street address match for international transactions—Postal code not verified due to incompatible formats</li>
     *   <li>C - Street address and postal code not verified for international transaction due to incompatible formats</li>
     *   <li>D - Street address and postal code match for international transaction, cardholder name is incorrect</li>
     *   <li>E - AVS error</li>
     *   <li>F - Address does match and five digit ZIP code does match (UK only)</li>
     *   <li>G - Address information is unavailable; international transaction; non-AVS participant</li>
     *   <li>H - Billing address and postal code match, cardholder name is incorrect (Amex)</li>
     *   <li>I - Address information not verified for international transaction</li>
     *   <li>K - Cardholder name matches (Amex)</li>
     *   <li>L - Cardholder name and postal code match (Amex)</li>
     *   <li>M - Cardholder name, street address, and postal code match for international transaction</li>
     *   <li>N - No Match on Address (Street) or Zip</li>
     *   <li>O - Cardholder name and address match (Amex)</li>
     *   <li>P - Postal codes match for international transaction—Street address not verified due to incompatible formats</li>
     *   <li>Q - Billing address matches, cardholder is incorrect (Amex)</li>
     *   <li>R - Retry, System unavailable or Timed out</li>
     *   <li>S - Service not supported by issuer</li>
     *   <li>U - Address information is unavailable</li>
     *   <li>W - 9 digit Zip matches, Address (Street) does not</li>
     *   <li>X - Exact AVS Match</li>
     *   <li>Y - Address (Street) and 5 digit Zip match</li>
     *   <li>Z - 5 digit Zip matches, Address (Street) does not</li>
     *   <li>0 - No service available</li>
     * </ul>
     */
    public String getAvsResult() {
        return avsResult;
    }

    /**
     * Result of the Address Verification Service checks. Possible values are:
     * <ul>
     *   <li>A - Address (Street) matches, Zip does not</li>
     *   <li>B - Street address match for international transactions—Postal code not verified due to incompatible formats</li>
     *   <li>C - Street address and postal code not verified for international transaction due to incompatible formats</li>
     *   <li>D - Street address and postal code match for international transaction, cardholder name is incorrect</li>
     *   <li>E - AVS error</li>
     *   <li>F - Address does match and five digit ZIP code does match (UK only)</li>
     *   <li>G - Address information is unavailable; international transaction; non-AVS participant</li>
     *   <li>H - Billing address and postal code match, cardholder name is incorrect (Amex)</li>
     *   <li>I - Address information not verified for international transaction</li>
     *   <li>K - Cardholder name matches (Amex)</li>
     *   <li>L - Cardholder name and postal code match (Amex)</li>
     *   <li>M - Cardholder name, street address, and postal code match for international transaction</li>
     *   <li>N - No Match on Address (Street) or Zip</li>
     *   <li>O - Cardholder name and address match (Amex)</li>
     *   <li>P - Postal codes match for international transaction—Street address not verified due to incompatible formats</li>
     *   <li>Q - Billing address matches, cardholder is incorrect (Amex)</li>
     *   <li>R - Retry, System unavailable or Timed out</li>
     *   <li>S - Service not supported by issuer</li>
     *   <li>U - Address information is unavailable</li>
     *   <li>W - 9 digit Zip matches, Address (Street) does not</li>
     *   <li>X - Exact AVS Match</li>
     *   <li>Y - Address (Street) and 5 digit Zip match</li>
     *   <li>Z - 5 digit Zip matches, Address (Street) does not</li>
     *   <li>0 - No service available</li>
     * </ul>
     */
    public void setAvsResult(String value) {
        this.avsResult = value;
    }

    /**
     * Result of the Address Verification Service checks. Possible values are:
     * <ul>
     *   <li>A - Address (Street) matches, Zip does not</li>
     *   <li>B - Street address match for international transactions—Postal code not verified due to incompatible formats</li>
     *   <li>C - Street address and postal code not verified for international transaction due to incompatible formats</li>
     *   <li>D - Street address and postal code match for international transaction, cardholder name is incorrect</li>
     *   <li>E - AVS error</li>
     *   <li>F - Address does match and five digit ZIP code does match (UK only)</li>
     *   <li>G - Address information is unavailable; international transaction; non-AVS participant</li>
     *   <li>H - Billing address and postal code match, cardholder name is incorrect (Amex)</li>
     *   <li>I - Address information not verified for international transaction</li>
     *   <li>K - Cardholder name matches (Amex)</li>
     *   <li>L - Cardholder name and postal code match (Amex)</li>
     *   <li>M - Cardholder name, street address, and postal code match for international transaction</li>
     *   <li>N - No Match on Address (Street) or Zip</li>
     *   <li>O - Cardholder name and address match (Amex)</li>
     *   <li>P - Postal codes match for international transaction—Street address not verified due to incompatible formats</li>
     *   <li>Q - Billing address matches, cardholder is incorrect (Amex)</li>
     *   <li>R - Retry, System unavailable or Timed out</li>
     *   <li>S - Service not supported by issuer</li>
     *   <li>U - Address information is unavailable</li>
     *   <li>W - 9 digit Zip matches, Address (Street) does not</li>
     *   <li>X - Exact AVS Match</li>
     *   <li>Y - Address (Street) and 5 digit Zip match</li>
     *   <li>Z - 5 digit Zip matches, Address (Street) does not</li>
     *   <li>0 - No service available</li>
     * </ul>
     */
    public CardFraudResults withAvsResult(String value) {
        this.avsResult = value;
        return this;
    }

    /**
     * Result of the Card Verification Value checks. Possible values are:
     * <ul>
     *   <li>M - CVV check performed and valid value</li>
     *   <li>N - CVV checked and no match</li>
     *   <li>P - CVV check not performed, not requested</li>
     *   <li>S - Cardholder claims no CVV code on card, issuer states CVV-code should be on card</li>
     *   <li>U - Issuer not certified for CVV2</li>
     *   <li>Y - Server provider did not respond</li>
     *   <li>0 - No service available</li>
     * </ul>
     */
    public String getCvvResult() {
        return cvvResult;
    }

    /**
     * Result of the Card Verification Value checks. Possible values are:
     * <ul>
     *   <li>M - CVV check performed and valid value</li>
     *   <li>N - CVV checked and no match</li>
     *   <li>P - CVV check not performed, not requested</li>
     *   <li>S - Cardholder claims no CVV code on card, issuer states CVV-code should be on card</li>
     *   <li>U - Issuer not certified for CVV2</li>
     *   <li>Y - Server provider did not respond</li>
     *   <li>0 - No service available</li>
     * </ul>
     */
    public void setCvvResult(String value) {
        this.cvvResult = value;
    }

    /**
     * Result of the Card Verification Value checks. Possible values are:
     * <ul>
     *   <li>M - CVV check performed and valid value</li>
     *   <li>N - CVV checked and no match</li>
     *   <li>P - CVV check not performed, not requested</li>
     *   <li>S - Cardholder claims no CVV code on card, issuer states CVV-code should be on card</li>
     *   <li>U - Issuer not certified for CVV2</li>
     *   <li>Y - Server provider did not respond</li>
     *   <li>0 - No service available</li>
     * </ul>
     */
    public CardFraudResults withCvvResult(String value) {
        this.cvvResult = value;
        return this;
    }

    /**
     * Resulting advice of the fraud prevention checks. Possible values are:
     * <ul>
     *   <li>accepted - Based on the checks performed the transaction can be accepted</li>
     *   <li>challenged - Based on the checks performed the transaction should be manually reviewed</li>
     *   <li>denied - Based on the checks performed the transaction should be rejected</li>
     *   <li>no-advice - No fraud check was requested/performed</li>
     *   <li>error - The fraud check resulted an error. Note that the fraud check was thus not performed.</li>
     * </ul>
     */
    public String getFraudServiceResult() {
        return fraudServiceResult;
    }

    /**
     * Resulting advice of the fraud prevention checks. Possible values are:
     * <ul>
     *   <li>accepted - Based on the checks performed the transaction can be accepted</li>
     *   <li>challenged - Based on the checks performed the transaction should be manually reviewed</li>
     *   <li>denied - Based on the checks performed the transaction should be rejected</li>
     *   <li>no-advice - No fraud check was requested/performed</li>
     *   <li>error - The fraud check resulted an error. Note that the fraud check was thus not performed.</li>
     * </ul>
     */
    public void setFraudServiceResult(String value) {
        this.fraudServiceResult = value;
    }

    /**
     * Resulting advice of the fraud prevention checks. Possible values are:
     * <ul>
     *   <li>accepted - Based on the checks performed the transaction can be accepted</li>
     *   <li>challenged - Based on the checks performed the transaction should be manually reviewed</li>
     *   <li>denied - Based on the checks performed the transaction should be rejected</li>
     *   <li>no-advice - No fraud check was requested/performed</li>
     *   <li>error - The fraud check resulted an error. Note that the fraud check was thus not performed.</li>
     * </ul>
     */
    public CardFraudResults withFraudServiceResult(String value) {
        this.fraudServiceResult = value;
        return this;
    }
}
