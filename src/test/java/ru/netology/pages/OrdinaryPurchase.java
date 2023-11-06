
package ru.netology.pages;

        import com.codeborne.selenide.SelenideElement;
        import ru.netology.data.Card;

        import java.time.Duration;

        import static com.codeborne.selenide.Condition.*;
        import static com.codeborne.selenide.Selectors.byText;
        import static com.codeborne.selenide.Selenide.$;
        import static com.codeborne.selenide.Selenide.$$;

public class OrdinaryPurchase {
    private SelenideElement heading = $$("h3").find(exactText("Оплата по карте"));
    private SelenideElement cardNumberField = $(byText("Номер карты")).parent().$("[class=\"input__control\"]");
    private SelenideElement monthField = $(byText("Месяц")).parent().$("[class=\"input__control\"]");
    private SelenideElement yearField = $(byText("Год")).parent().$("[class=\"input__control\"]");
    private SelenideElement cardHolderField = $(byText("Владелец")).parent().$("[class=\"input__control\"]");
    private SelenideElement cvvField = $(byText("CVC/CVV")).parent().$("[class=\"input__control\"]");
    private SelenideElement approvedOperationNotification = $(byText("Операция одобрена Банком.")).parent().$("[class=\"notification__content\"]");
    private SelenideElement failedOperationNotification = $(byText("Ошибка! Банк отказал в проведении операции")).parent().$("[class=\"notification__content\"]");
    private SelenideElement wrongFormatErrorNotification = $(byText("Неверный формат"));
    private SelenideElement cardExpirationDateError = $(byText("Неверно указан срок действия карты"));
    private SelenideElement cardExpiredDateError = $(byText("Истёк срок действия карты"));
    private SelenideElement requiredFieldError = $(byText("Поле обязательно для заполнения"));

    private SelenideElement cancelField = $$("[class=\"icon-button__text\"]").first();
    private SelenideElement continueButton = $$("button").find(exactText("Продолжить"));

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

    public void getNotificationApproved() {
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
