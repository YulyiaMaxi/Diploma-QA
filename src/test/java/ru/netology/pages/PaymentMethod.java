package ru.netology.pages;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
public class PaymentMethod {
    private SelenideElement heading = $$("h2").findBy(text("Путешествие дня"));
    private SelenideElement buyButton = $$(".button").findBy(text("Купить"));
    public final SelenideElement creditButton = $$(".button").findBy(text("Купить в кредит"));

    public PaymentMethod() {

        heading.shouldBe(visible);
    }

    public OrdinaryPurchase goToBuyPage() {
        buyButton.click();
        return new OrdinaryPurchase();
    }

    public CreditPurchase goToCreditPage() {
        creditButton.click();
        return new CreditPurchase();
    }
}
