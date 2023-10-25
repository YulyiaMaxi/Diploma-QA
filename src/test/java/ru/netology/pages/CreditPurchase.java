package ru.netology.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.Card;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.time.Duration.*;

public class CreditPurchase {
    private SelenideElement heading = $$("h3").find(exactText("Кредит по данным карты"));
    private SelenideElement cardNumberField = $$(".input__control").findBy(text("Номер карты"));
    private SelenideElement monthField = $$(".input__control").findBy(text("Месяц"));
    private SelenideElement yearField = $$(".input__control").findBy(text("Год"));
    private SelenideElement cardHolderField = $$(".input__control").findBy(text("Владелец"));
    private SelenideElement cvvField = $$(".input__control").findBy(text("CVC/CVV"));
    private SelenideElement approvedOperationNotification = $$(".notification__content").findBy(text("Операция одобрена Банком"));
    private SelenideElement failedOperationNotification = $$(".notification__content").findBy(text("Ошибка! Банк отказал в проведении операции"));
    private SelenideElement wrongFieldFormatError = $(byText("Неверный формат"));
    private SelenideElement wrongExpirationDateError = $(byText("Неверно указан срок действия карты"));
    private SelenideElement cardExpiredDateError = $(byText("Истёк срок действия карты"));
    private SelenideElement requiredFieldError = $(byText("Поле обязательно для заполнения"));
    private SelenideElement continueButton = $$(".button").findBy(text("Продолжить"));
    private SelenideElement cancelField = $$("[class=\"icon-button__text\"]").first();

    public CreditPurchase() {
        heading.shouldBe(visible);
    }

    public void inputData(Card card) {
        cardNumberField.setValue(card.getCardNumber());
        monthField.setValue(card.getMonth());
        yearField.setValue(card.getYear());
        cardHolderField.setValue(card.getCardHolder());
        cvvField.setValue(card.getCvv());
        continueButton.click();
    }

    public void ShouldShowNotificationApproved() {
         approvedOperationNotification.waitUntil(visible,15000);;

        cancelField.click();
    }

    public void waitNotificationFailure() {
        failedOperationNotification.waitUntil(visible,15000);;
    }

    public void waitNotificationWrongFormat() {
        wrongFieldFormatError.waitUntil(visible,15000);;
    }

    public void waitNotificationExpirationDateError() {
        wrongExpirationDateError.waitUntil(visible,15000);;
    }

    public void waitNotificationExpiredError() {
        cardExpiredDateError.waitUntil(visible,15000);;
    }

}