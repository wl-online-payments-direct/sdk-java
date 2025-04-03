/*
 * This file was automatically generated.
 */

package com.onlinepayments.domain;

public class TokenCardData {

    private CardWithoutCvv cardWithoutCvv;

    private String cobrandSelectionIndicator;

    public CardWithoutCvv getCardWithoutCvv() {
        return cardWithoutCvv;
    }

    public void setCardWithoutCvv(CardWithoutCvv value) {
        this.cardWithoutCvv = value;
    }

    public TokenCardData withCardWithoutCvv(CardWithoutCvv value) {
        this.cardWithoutCvv = value;
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
    public TokenCardData withCobrandSelectionIndicator(String value) {
        this.cobrandSelectionIndicator = value;
        return this;
    }
}
