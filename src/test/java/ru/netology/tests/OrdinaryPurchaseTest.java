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
import static org.junit.jupiter.api.Assertions.assertNull;

public class OrdinaryPurchaseTest {
    public static String url = System.getProperty("sut.url");

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    public void openPage() {
        open(url);
    }

    @AfterEach
    public void cleanBase() {
        SQLHelper.clearDB();
    }

    @Test
    void shouldBuyCardApproved() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getApprovedCard());
        payment.getApprovedOperationNotification();
        assertEquals("APPROVED", SQLHelper.getPaymentStatus());
    }


    @Test
    void shouldNotBuyDeclinedCard() {
        val page = new PaymentMethod();
        val payment = page.goToCreditPage();
        payment.inputData(DataHelper.getDeclinedCard());
        payment.getFailedNotification();
        assertEquals("DECLINED", SQLHelper.getPaymentStatus());
    }


    @Test
    void shouldNotBuyCardNumberFieldEmpty() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardNumberFieldEmpty());
        payment.getNotificationWrongFormat();
        assertNull(SQLHelper.getPaymentStatus());
    }


    @Test
    void shouldNotBuyCardNumberLessThan16Symbols() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardNumberLessThan16Symbols());
        payment.getNotificationWrongFormat();
        assertNull(SQLHelper.getPaymentStatus());
    }


    @Test
    void shouldNotBuyCardHolderInCyrillic() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardHolderInCyrillic());
        payment.getNotificationWrongFormat();
        assertNull(SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardHolderInOneWord() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardHolderInOneWord());
        payment.getNotificationWrongFormat();
        assertNull(SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardHolderWithSpecialSymbols() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardHolderWithSpecialSymbols());
        payment.getNotificationWrongFormat();
        assertNull(SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardHolderEmptyField() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardHolderEmptyField());
        payment.getNotificationRequiredFieldError();
        assertNull(SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardMonthLessThan2Figures() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardMonthLessThan2Figures());
        payment.getNotificationWrongFormat();
        assertNull(SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardMonthEqual00() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardMonthEqual00());
        payment.getNotificationExpirationDateError();
        assertNull(SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardMonthMoreThan12() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardMonthMoreThan12());
        payment.getNotificationExpirationDateError();
        assertNull(SQLHelper.getPaymentStatus());
    }


    @Test
    void shouldNotBuyCardMonthEmptyField() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardMonthEmptyField());
        payment.getNotificationWrongFormat();
        assertNull(SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldBuyCardCurrentMonthAndYear() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardCurrentMonthAndYear());
        payment.getApprovedOperationNotification();
        assertEquals("APPROVED", SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldBuyCardCurrentMonthAndYearPlus5Years() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardCurrentMonthAndYearPlus5Years());
        payment.getApprovedOperationNotification();
        assertEquals("APPROVED", SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardCurrentMonthAndYearMinus1Month() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardCurrentMonthAndYearMinus1Month());
        payment.getNotificationExpirationDateError();
        assertNull(SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyNotCardCurrentMonthAndYearPlus1MonthPlus5Years() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardCurrentMonthAndYearMinus1Month());
        payment.getNotificationExpirationDateError();
        assertNull(SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardYearEmptyField() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardYearEmptyField());
        payment.getNotificationWrongFormat();
        assertNull(SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardYearOnlyOneFigure() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardYearOnlyOneFigure());
        payment.getNotificationWrongFormat();
        assertNull(SQLHelper.getPaymentStatus());

    }

    @Test
    void shouldNotBuyCardCvv000() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardCvv000());
        payment.getNotificationWrongFormat();
        assertNull(SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardYearCvvEmptyField() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardYearCvvEmptyField());
        payment.getNotificationRequiredFieldError();
        assertNull(SQLHelper.getPaymentStatus());
    }

    @Test
    void shouldNotBuyCardCvvLessThanThreeFigures() {
        val page = new PaymentMethod();
        val payment = page.goToBuyPage();
        payment.inputData(DataHelper.getCardCvvLessThanThreeFigures());
        payment.getNotificationWrongFormat();
        assertNull(SQLHelper.getPaymentStatus());
    }
}


