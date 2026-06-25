package com.onlinepayments.it.util.common;

import com.onlinepayments.domain.Address;
import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.AutoCapture;
import com.onlinepayments.domain.BrowserData;
import com.onlinepayments.domain.Card;
import com.onlinepayments.domain.CardPaymentMethodSpecificInput;
import com.onlinepayments.domain.CompanyInformation;
import com.onlinepayments.domain.ContactDetails;
import com.onlinepayments.domain.CreatePaymentRequest;
import com.onlinepayments.domain.Customer;
import com.onlinepayments.domain.CustomerAccount;
import com.onlinepayments.domain.CustomerAccountAuthentication;
import com.onlinepayments.domain.CustomerDevice;
import com.onlinepayments.domain.CustomerPaymentActivity;
import com.onlinepayments.domain.Order;
import com.onlinepayments.domain.OrderReferences;
import com.onlinepayments.domain.PaymentAccountOnFile;
import com.onlinepayments.domain.PersonalInformation;
import com.onlinepayments.domain.PersonalName;
import com.onlinepayments.domain.RedirectPaymentMethodSpecificInput;

public class CreatePaymentRequestBuilder {

    public enum PaymentMethodType {
        CARD,
        PAYPAL_REDIRECT
    }

    private String cardNumber = "4012000033330026";
    private String cvv = "123";
    private String expiryDate = "0530";
    private String cardholderName = "Wile E. Coyote";

    private long amount = 1000L;
    private String currency = "EUR";

    private String merchantReference;
    private String merchantCustomerId = "CUST-000001";

    private String token;
    private boolean autoCapture;
    private String authorizationMode = "FINAL_AUTHORIZATION";

    private PaymentMethodType paymentMethodType = PaymentMethodType.CARD;

    public CreatePaymentRequestBuilder() {
        this.merchantReference = generateMerchantReference();
    }

    public CreatePaymentRequestBuilder withCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public CreatePaymentRequestBuilder withCvv(String cvv) {
        this.cvv = cvv;
        return this;
    }

    public CreatePaymentRequestBuilder withExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    public CreatePaymentRequestBuilder withCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
        return this;
    }

    public CreatePaymentRequestBuilder withAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public CreatePaymentRequestBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public CreatePaymentRequestBuilder withMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
        return this;
    }

    public CreatePaymentRequestBuilder withMerchantCustomerId(String merchantCustomerId) {
        this.merchantCustomerId = merchantCustomerId;
        return this;
    }

    public CreatePaymentRequestBuilder withToken(String token) {
        this.token = token;
        return this;
    }

    public CreatePaymentRequestBuilder withCardPaymentMethod() {
        this.paymentMethodType = PaymentMethodType.CARD;
        return this;
    }

    public CreatePaymentRequestBuilder withPayPalRedirectPaymentMethod() {
        this.paymentMethodType = PaymentMethodType.PAYPAL_REDIRECT;
        return this;
    }

    public CreatePaymentRequestBuilder withAutoCapture(boolean autoCapture) {
        this.autoCapture = autoCapture;
        return this;
    }

    public CreatePaymentRequestBuilder withAuthorizationMode(String authorizationMode) {
        this.authorizationMode = authorizationMode;
        return this;
    }

    public CreatePaymentRequest build() {
        CreatePaymentRequest request = new CreatePaymentRequest();

        if (paymentMethodType == PaymentMethodType.CARD) {
            return request
                .withCardPaymentMethodSpecificInput(buildCardPaymentInput())
                .withOrder(buildCardOrder());
        }

        return request
            .withRedirectPaymentMethodSpecificInput(buildRedirectPaymentInput())
            .withOrder(buildPayPalOrder());
    }

    private CardPaymentMethodSpecificInput buildCardPaymentInput() {
        CardPaymentMethodSpecificInput cardPaymentMethodSpecificInput = new CardPaymentMethodSpecificInput();
        if (this.autoCapture) {
            cardPaymentMethodSpecificInput.withAutoCapture(new AutoCapture().withDelayInMinutes(10));
        }

        return token != null
                ? cardPaymentMethodSpecificInput
                        .withToken(token)
                        .withAuthorizationMode(authorizationMode)
                        .withTransactionChannel("ECOMMERCE")
                        .withReturnUrl("https://example.com/return")
                        .withPaymentProductId(1)
                : cardPaymentMethodSpecificInput
                        .withCard(buildCard())
                        .withAuthorizationMode(authorizationMode)
                        .withTransactionChannel("ECOMMERCE")
                        .withReturnUrl("https://example.com/return")
                        .withPaymentProductId(1);
    }

    private RedirectPaymentMethodSpecificInput buildRedirectPaymentInput() {
        return new RedirectPaymentMethodSpecificInput()
            .withPaymentProductId(840);
    }

    private Card buildCard() {
        return new Card()
            .withCardholderName(cardholderName)
            .withCardNumber(cardNumber)
            .withExpiryDate(expiryDate)
            .withCvv(cvv);
    }

    private Order buildCardOrder() {
        return new Order()
            .withAmountOfMoney(buildAmountOfMoney())
            .withCustomer(buildCustomer())
            .withReferences(buildOrderReferences());
    }

    private Order buildPayPalOrder() {
        return new Order()
            .withAmountOfMoney(buildAmountOfMoney())
            .withReferences(buildOrderReferences()
                .withDescriptor("Applefruitcompany")
                .withMerchantParameters("SessionID=126548354&ShopperID=73541312"));
    }

    private AmountOfMoney buildAmountOfMoney() {
        return new AmountOfMoney()
            .withAmount(amount)
            .withCurrencyCode(currency);
    }

    private OrderReferences buildOrderReferences() {
        return new OrderReferences()
            .withMerchantReference(merchantReference);
    }

    private Customer buildCustomer() {
        return new Customer()
            .withCompanyInformation(buildCompanyInformation())
            .withMerchantCustomerId(merchantCustomerId)
            .withAccount(buildCustomerAccount())
            .withAccountType("existing")
            .withBillingAddress(buildBillingAddress())
            .withContactDetails(buildContactDetails())
            .withDevice(buildCustomerDevice())
            .withPersonalInformation(buildPersonalInformation());
    }

    private CompanyInformation buildCompanyInformation() {
        return new CompanyInformation()
            .withName("CUST-000001");
    }

    private CustomerAccount buildCustomerAccount() {
        return new CustomerAccount()
            .withAuthentication(buildAuthentication())
            .withChangeDate("20200101")
            .withChangedDuringCheckout(true)
            .withCreateDate("20100101")
            .withHadSuspiciousActivity(false)
            .withPasswordChangeDate("20200101")
            .withPasswordChangedDuringCheckout(false)
            .withPaymentAccountOnFile(buildPaymentAccountOnFile())
            .withPaymentActivity(buildPaymentActivity());
    }

    private CustomerAccountAuthentication buildAuthentication() {
        return new CustomerAccountAuthentication()
            .withMethod("guest")
            .withUtcTimestamp("202309261631");
    }

    private PaymentAccountOnFile buildPaymentAccountOnFile() {
        return new PaymentAccountOnFile()
            .withCreateDate("20100101")
            .withNumberOfCardOnFileCreationAttemptsLast24Hours(1);
    }

    private CustomerPaymentActivity buildPaymentActivity() {
        return new CustomerPaymentActivity()
            .withNumberOfPaymentAttemptsLast24Hours(1)
            .withNumberOfPaymentAttemptsLastYear(0)
            .withNumberOfPurchasesLast6Months(0);
    }

    private Address buildBillingAddress() {
        return new Address()
            .withCountryCode("BE")
            .withCity("Brussels")
            .withHouseNumber("3")
            .withState("Flemish Brabant")
            .withStreet("Da Vincilaan")
            .withZip("1930")
            .withAdditionalInfo("floor 9");
    }

    private ContactDetails buildContactDetails() {
        return new ContactDetails()
            .withEmailAddress("wile.e.coyote@acmelabs.com")
            .withPhoneNumber("+321234567890");
    }

    private CustomerDevice buildCustomerDevice() {
        return new CustomerDevice()
            .withAcceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
            .withBrowserData(buildBrowserData())
            .withIpAddress("123.123.123.123")
            .withLocale("en_GB")
            .withUserAgent("Mozilla/5.0(WindowsNT10.0;Win64;x64)AppleWebKit/537.36(KHTML,likeGecko)Chrome/75.0.3770.142Safari/537.36")
            .withTimezoneOffsetUtcMinutes("-180");
    }

    private BrowserData buildBrowserData() {
        return new BrowserData()
            .withColorDepth(99)
            .withJavaEnabled(true)
            .withJavaScriptEnabled(true)
            .withScreenHeight("768")
            .withScreenWidth("1024");
    }

    private PersonalInformation buildPersonalInformation() {
        return new PersonalInformation()
            .withName(buildPersonalName())
            .withGender("male")
            .withDateOfBirth("19500101");
    }

    private PersonalName buildPersonalName() {
        return new PersonalName()
            .withTitle("M.")
            .withFirstName("Wile")
            .withSurname("Coyote");
    }

    private String generateMerchantReference() {
        return "Ref-" + java.util.UUID.randomUUID();
    }
}
