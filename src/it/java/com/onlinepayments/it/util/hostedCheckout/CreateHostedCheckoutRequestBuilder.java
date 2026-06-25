package com.onlinepayments.it.util.hostedCheckout;

import com.onlinepayments.domain.Address;
import com.onlinepayments.domain.AmountOfMoney;
import com.onlinepayments.domain.CardPaymentMethodSpecificInputForHostedCheckout;
import com.onlinepayments.domain.ContactDetails;
import com.onlinepayments.domain.CreateHostedCheckoutRequest;
import com.onlinepayments.domain.Customer;
import com.onlinepayments.domain.Feedbacks;
import com.onlinepayments.domain.FraudFields;
import com.onlinepayments.domain.HostedCheckoutSpecificInput;
import com.onlinepayments.domain.MobilePaymentMethodHostedCheckoutSpecificInput;
import com.onlinepayments.domain.Order;
import com.onlinepayments.domain.OrderReferences;
import com.onlinepayments.domain.PaymentProductFiltersHostedCheckout;
import com.onlinepayments.domain.PersonalInformation;
import com.onlinepayments.domain.PersonalName;
import com.onlinepayments.domain.RedirectPaymentMethodSpecificInput;
import com.onlinepayments.domain.SepaDirectDebitPaymentMethodSpecificInputBase;
import com.onlinepayments.domain.SplitPaymentProductFiltersHostedCheckout;

public class CreateHostedCheckoutRequestBuilder {

    private long amount = 1000L;
    private String currency = "EUR";

    private String merchantReference;
    private String merchantCustomerId = "CUST-000001";
    private String locale = "en_US";
    private String returnUrl = "https://example.com/return";
    private Boolean showResultPage = true;
    private Integer sessionTimeout = 600;
    private Integer allowedNumberOfPaymentAttempts = 10;
    private Boolean isRecurring = false;
    private Boolean isNewUnscheduledCardOnFileSeries = false;
    private String variant = null;
    private String tokens = null;

    private String countryCode = "US";
    private String firstName = "Test";
    private String surname = "User";
    private String title = null;
    private String emailAddress = null;
    private String phoneNumber = null;
    private String city = null;
    private String street = null;
    private String houseNumber = null;
    private String additionalInfo = null;
    private String state = null;
    private String zip = null;

    private PaymentProductFiltersHostedCheckout paymentProductFilters = null;
    private SplitPaymentProductFiltersHostedCheckout splitPaymentProductFilters = null;
    private Feedbacks feedbacks = null;
    private FraudFields fraudFields = null;

    private Boolean cardClickToPay = false;
    private Boolean cardGroupCards = false;
    private Integer redirectPaymentProductId = 3;
    private Integer sepaPaymentProductId = 771;
    private Integer mobilePaymentProductId = null;

    private Boolean useRedirectPayment = false;
    private Boolean useSepaPayment = false;
    private Boolean useMobilePayment = false;

    public CreateHostedCheckoutRequestBuilder() {
        this.merchantReference = generateMerchantReference();
    }

    public CreateHostedCheckoutRequestBuilder withAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withMerchantCustomerId(String merchantCustomerId) {
        this.merchantCustomerId = merchantCustomerId;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withLocale(String locale) {
        this.locale = locale;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withShowResultPage(Boolean showResultPage) {
        this.showResultPage = showResultPage;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withSessionTimeout(Integer sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withAllowedNumberOfPaymentAttempts(
            Integer allowedNumberOfPaymentAttempts) {
        this.allowedNumberOfPaymentAttempts = allowedNumberOfPaymentAttempts;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withIsRecurring(Boolean isRecurring) {
        this.isRecurring = isRecurring;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withIsNewUnscheduledCardOnFileSeries(
            Boolean isNewUnscheduledCardOnFileSeries) {
        this.isNewUnscheduledCardOnFileSeries = isNewUnscheduledCardOnFileSeries;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withVariant(String variant) {
        this.variant = variant;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withTokens(String tokens) {
        this.tokens = tokens;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withStreet(String street) {
        this.street = street;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withState(String state) {
        this.state = state;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withZip(String zip) {
        this.zip = zip;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withPaymentProductFilters(
            PaymentProductFiltersHostedCheckout paymentProductFilters) {
        this.paymentProductFilters = paymentProductFilters;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withSplitPaymentProductFilters(
            SplitPaymentProductFiltersHostedCheckout splitPaymentProductFilters) {
        this.splitPaymentProductFilters = splitPaymentProductFilters;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withFeedbacks(Feedbacks feedbacks) {
        this.feedbacks = feedbacks;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withFraudFields(FraudFields fraudFields) {
        this.fraudFields = fraudFields;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withCardClickToPay(Boolean cardClickToPay) {
        this.cardClickToPay = cardClickToPay;
        return this;
    }

    public CreateHostedCheckoutRequestBuilder withCardGroupCards(Boolean cardGroupCards) {
        this.cardGroupCards = cardGroupCards;
        return this;
    }

    public CreateHostedCheckoutRequest build() {
        CreateHostedCheckoutRequest request = new CreateHostedCheckoutRequest()
                .withHostedCheckoutSpecificInput(buildHostedCheckoutSpecificInput())
                .withOrder(buildOrder());

        if (useRedirectPayment) {
            request.withRedirectPaymentMethodSpecificInput(buildRedirectPaymentInput());
        } else if (useSepaPayment) {
            request.withSepaDirectDebitPaymentMethodSpecificInput(buildSepaPaymentInput());
        } else if (useMobilePayment) {
            request.withMobilePaymentMethodSpecificInput(buildMobilePaymentInput());
        }

        if (feedbacks != null) {
            request.withFeedbacks(feedbacks);
        }

        if (fraudFields != null) {
            request.withFraudFields(fraudFields);
        }

        return request;
    }

    private HostedCheckoutSpecificInput buildHostedCheckoutSpecificInput() {
        HostedCheckoutSpecificInput input = new HostedCheckoutSpecificInput()
                .withLocale(locale)
                .withReturnUrl(returnUrl)
                .withShowResultPage(showResultPage)
                .withSessionTimeout(sessionTimeout)
                .withAllowedNumberOfPaymentAttempts(allowedNumberOfPaymentAttempts)
                .withIsRecurring(isRecurring)
                .withIsNewUnscheduledCardOnFileSeries(isNewUnscheduledCardOnFileSeries);

        if (variant != null) {
            input.withVariant(variant);
        }

        if (tokens != null) {
            input.withTokens(tokens);
        }

        if (!useRedirectPayment && !useSepaPayment && !useMobilePayment) {
            input.withCardPaymentMethodSpecificInput(buildCardPaymentInput());
        }

        if (paymentProductFilters != null) {
            input.withPaymentProductFilters(paymentProductFilters);
        }

        if (splitPaymentProductFilters != null) {
            input.withSplitPaymentProductFilters(splitPaymentProductFilters);
        }

        return input;
    }

    private CardPaymentMethodSpecificInputForHostedCheckout buildCardPaymentInput() {
        return new CardPaymentMethodSpecificInputForHostedCheckout()
                .withClickToPay(cardClickToPay)
                .withGroupCards(cardGroupCards);
    }

    private RedirectPaymentMethodSpecificInput buildRedirectPaymentInput() {
        return new RedirectPaymentMethodSpecificInput()
                .withPaymentProductId(redirectPaymentProductId);
    }

    private SepaDirectDebitPaymentMethodSpecificInputBase buildSepaPaymentInput() {
        return new SepaDirectDebitPaymentMethodSpecificInputBase()
                .withPaymentProductId(sepaPaymentProductId);
    }

    private MobilePaymentMethodHostedCheckoutSpecificInput buildMobilePaymentInput() {
        return new MobilePaymentMethodHostedCheckoutSpecificInput()
                .withPaymentProductId(mobilePaymentProductId);
    }

    private Order buildOrder() {
        return new Order()
                .withAmountOfMoney(buildAmountOfMoney())
                .withCustomer(buildCustomer())
                .withReferences(buildOrderReferences());
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
        Customer customer = new Customer()
                .withMerchantCustomerId(merchantCustomerId)
                .withBillingAddress(buildBillingAddress());

        if (firstName != null || surname != null) {
            customer.withPersonalInformation(buildPersonalInformation());
        }

        if (emailAddress != null || phoneNumber != null) {
            customer.withContactDetails(buildContactDetails());
        }

        return customer;
    }

    private Address buildBillingAddress() {
        Address address = new Address()
                .withCountryCode(countryCode);

        if (city != null) {
            address.withCity(city);
        }

        if (street != null) {
            address.withStreet(street);
        }

        if (houseNumber != null) {
            address.withHouseNumber(houseNumber);
        }

        if (additionalInfo != null) {
            address.withAdditionalInfo(additionalInfo);
        }

        if (state != null) {
            address.withState(state);
        }

        if (zip != null) {
            address.withZip(zip);
        }

        return address;
    }

    private PersonalInformation buildPersonalInformation() {
        return new PersonalInformation()
                .withName(buildPersonalName());
    }

    private PersonalName buildPersonalName() {
        PersonalName name = new PersonalName()
                .withFirstName(firstName)
                .withSurname(surname);

        if (title != null) {
            name.withTitle(title);
        }

        return name;
    }

    private ContactDetails buildContactDetails() {
        ContactDetails details = new ContactDetails();

        if (emailAddress != null) {
            details.withEmailAddress(emailAddress);
        }

        if (phoneNumber != null) {
            details.withPhoneNumber(phoneNumber);
        }

        return details;
    }

    private String generateMerchantReference() {
        return "Ord-" + java.util.UUID.randomUUID();
    }
}
