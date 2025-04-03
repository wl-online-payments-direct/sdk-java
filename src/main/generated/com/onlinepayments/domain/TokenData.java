/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class TokenData {

    private Card card;

    private String cobrandSelectionIndicator;

    /**
     * Object containing card details
     */
    public Card getCard() {
        return card;
    }

    /**
     * Object containing card details
     */
    public void setCard(Card value) {
        this.card = value;
    }

    /**
     * Object containing card details
     */
    public TokenData withCard(Card value) {
        this.card = value;
        return this;
    }

    /**
     * For cobranded cards, this field indicates the brand selection method:
     * <ul>
     *   <li>default - The holder implicitly accepted the default brand.</li>
     *   <li>alternative - The holder explicitly selected an alternative brand.</li>
     *   <li>notApplicable - The card is not cobranded.</li>
     * </ul>
     */
    public String getCobrandSelectionIndicator() {
        return cobrandSelectionIndicator;
    }

    /**
     * For cobranded cards, this field indicates the brand selection method:
     * <ul>
     *   <li>default - The holder implicitly accepted the default brand.</li>
     *   <li>alternative - The holder explicitly selected an alternative brand.</li>
     *   <li>notApplicable - The card is not cobranded.</li>
     * </ul>
     */
    public void setCobrandSelectionIndicator(String value) {
        this.cobrandSelectionIndicator = value;
    }

    /**
     * For cobranded cards, this field indicates the brand selection method:
     * <ul>
     *   <li>default - The holder implicitly accepted the default brand.</li>
     *   <li>alternative - The holder explicitly selected an alternative brand.</li>
     *   <li>notApplicable - The card is not cobranded.</li>
     * </ul>
     */
    public TokenData withCobrandSelectionIndicator(String value) {
        this.cobrandSelectionIndicator = value;
        return this;
    }
}
