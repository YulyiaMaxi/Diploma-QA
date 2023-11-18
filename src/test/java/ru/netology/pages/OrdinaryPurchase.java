package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.Card;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OrdinaryPurchase {
    public static SelenideElement approvedOperationNotification = $(byText("Операция одобрена Банком.")).parent().$("[class=\"notification__content\"]");
    public static SelenideElement failedOperationNotification = $(byText("Ошибка! Банк отказал в проведении операции")).parent().$("[class=\"notification__content\"]");
    private final SelenideElement heading = $$("h3").find(exactText("Оплата по карте"));
    private final SelenideElement cardNumberField = $(byText("Номер карты")).parent().$("[class=\"input__control\"]");
    private final SelenideElement monthField = $(byText("Месяц")).parent().$("[class=\"input__control\"]");
    private final SelenideElement yearField = $(byText("Год")).parent().$("[class=\"input__control\"]");
    private final SelenideElement cardHolderField = $(byText("Владелец")).parent().$("[class=\"input__control\"]");
    private final SelenideElement cvvField = $(byText("CVC/CVV")).parent().$("[class=\"input__control\"]");
    private final SelenideElement wrongFormatErrorNotification = $(byText("Неверный формат"));
    private final SelenideElement cardExpirationDateError = $(byText("Неверно указан срок действия карты"));
    private final SelenideElement cardExpiredDateError = $(byText("Истёк срок действия карты"));
    private final SelenideElement requiredFieldError = $(byText("Поле обязательно для заполнения"));

    private final SelenideElement cancelField = $$("[class=\"icon-button__text\"]").first();
    private final SelenideElement continueButton = $$("button").find(exactText("Продолжить"));

    public OrdinaryPurchase() {
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

    public void getApprovedOperationNotification() {
        approvedOperationNotification.shouldBe(visible, Duration.ofSeconds(15));
        cancelField.click();
    }

    public void getFailedNotification() {
        failedOperationNotification.shouldBe(visible, Duration.ofSeconds(15));
        cancelField.click();
    }


    public void getNotificationWrongFormat() {
        wrongFormatErrorNotification.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void getNotificationExpirationDateError() {
        cardExpirationDateError.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void getNotificationExpiredError() {
        cardExpiredDateError.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void getNotificationRequiredFieldError() {
        requiredFieldError.shouldBe(visible, Duration.ofSeconds(15));
    }

}
