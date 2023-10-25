package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.pages.PaymentMethod;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdinaryPurchaseTest {
    // public static String url = System.getProperty("sut.url");

    //@BeforeEach
    //  public void openPage() {
    //  open ("http://localhost:8080");
    //}

    @BeforeAll
    static void setUpAll() {

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void clearDB() {

        SQLHelper.clearDB();
    }


    @AfterAll
    static void tearDownAll() {

        SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldBuyCardApproved() {
        open("http://localhost:8080");
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getApprovedCard());
        payment.getNotificationApproved();
        assertEquals("APPROVED", SQLHelper.getPaymentStatus());
    }
}
/*
    @Test
    void shouldNotBuyDeclinedCard() {
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getDeclinedCard());
        payment.getFailedNotification();
        assertEquals("DECLINED", SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardNumberFieldEmpty() {
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardNumberFieldEmpty());
        payment.getNotificationWrongFormat();
        assertEquals("0", SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardNumberLessThan16Symbols() {
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardNumberLessThan16Symbols());
        payment.getNotificationWrongFormat();
        assertEquals("0", SQLHelper.getPaymentStatus());
    }


    @Test
    void shouldNotBuyCardHolderInCyrillic() {
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardHolderInCyrillic());
        payment.getNotificationWrongFormat();
        assertEquals("0", SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardHolderInOneWord() {
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardHolderInOneWord());
        payment.getNotificationWrongFormat();
        assertEquals("0", SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardHolderWithSpecialSymbols() {
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardHolderWithSpecialSymbols());
        payment.getNotificationWrongFormat();
        assertEquals("0", SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardHolderEmptyField() {
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardHolderEmptyField());
        payment.getNotificationRequiredFieldError();
        assertEquals("0", SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardMonthLessThan2Figures() {
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardMonthLessThan2Figures());
        payment.getNotificationWrongFormat();
        assertEquals("0", SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardMonthEqual00() {
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardMonthEqual00());
        payment.getNotificationExpirationDateError();
        assertEquals("0", SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardMonthMoreThan12() {
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardMonthMoreThan12());
        payment.getNotificationExpirationDateError();
        assertEquals("0", SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardMonthEmptyField() {
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardMonthEmptyField());
        payment.getNotificationRequiredFieldError();
        assertEquals("0", SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldBuyCardCurrentMonthAndYear() {
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardCurrentMonthAndYear());
        payment.getNotificationApproved();
        assertEquals("0", SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldBuyCardCurrentMonthAndYearPlus5Years() {
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardCurrentMonthAndYearPlus5Years());
        payment.getNotificationApproved();
        assertEquals("0", SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardCurrentMonthAndYearMinus1Month() {
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardCurrentMonthAndYearMinus1Month());
        payment.getNotificationExpiredError();
        assertEquals("0", SQLHelper.getPaymentStatus());
    }
    @Test
    void shouldNotBuyNotCardCurrentMonthAndYearPlus1MonthPlus5Years() {
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardCurrentMonthAndYearMinus1Month());
        payment.getNotificationExpirationDateError();
        assertEquals("0", SQLHelper.getPaymentStatus());
    }

        @Test
        void shouldNotBuyCardYearEmptyField() {
            PaymentMethod page = new PaymentMethod();
            val payment = page.goToBuyPage();
            payment.inputData(DataHelper.getCardYearEmptyField());
            payment.getNotificationRequiredFieldError();
            assertEquals("0", SQLHelper.getPaymentStatus());
        }
    @Test
    void shouldNotBuyCardYearOnlyOneFigure() {
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardYearOnlyOneFigure());
        payment.getNotificationWrongFormat();
        assertEquals("0", SQLHelper.getPaymentStatus());

}

    @Test
    void shouldNotBuyCardCvv000() {
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardCvv000());
        payment.getNotificationWrongFormat();
        assertEquals("0", SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardYearCvvEmptyField() {
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardYearCvvEmptyField());
        payment.getNotificationRequiredFieldError();
        assertEquals("0", SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardCvvLessThanThreeFigures() {
        PaymentMethod page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardCvvLessThanThreeFigures());
        payment.getNotificationWrongFormat();
        assertEquals("0", SQLHelper.getPaymentStatus());
    }


    */