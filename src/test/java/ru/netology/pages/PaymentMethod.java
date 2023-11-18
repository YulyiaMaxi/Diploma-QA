package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentMethod {
    public final SelenideElement creditButton = $$(".button").findBy(text("Купить в кредит"));
    private final SelenideElement heading = $$("h2").findBy(text("Путешествие дня"));
    private final SelenideElement buyButton = $$(".button").findBy(text("Купить"));

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
