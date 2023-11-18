
package ru.netology.data;

import com.github.javafaker.Faker;


import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.lang.Math;


public class DataHelper {


    public static Card getApprovedCard() {
        Faker faker = new Faker();
        return new Card("4444444444444441", "11", "25", faker.name().firstName() + " " + faker.name().lastName(), faker.number().digits(3));
    }

    public static Card getDeclinedCard() {
        Faker faker = new Faker();
        return new Card("4444444444444442", "12", "26", faker.name().firstName() + ' ' + faker.name().lastName(), faker.number().digits(3));
    }

    public static Card getCardNumberFieldEmpty() {
        return new Card(" ", "09", "24", "faker.name().firstName() +  ' ' + faker.name().lastName()", "faker.number().digits(3)");
    }

    public static Card getCardNumberLessThan16Symbols() {
        Faker faker = new Faker();
        String number = faker.number().digits(15);
        String cardHolder = faker.name().firstName() + ' ' + faker.name().lastName();
        String month = "12";
        String year = "24";
        String cvv = faker.number().digits(3);
        return new Card(number, month, year, cardHolder, cvv);
    }

    public static Card getCardHolderInCyrillic() {
        Faker faker = new Faker(new Locale("ru"));
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String month = "12";
        String year = "24";
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, cardHolder, cvv);
    }

    public static Card getCardHolderInOneWord() {
        Faker faker = new Faker();
        String cardHolder = faker.name().firstName() + faker.name().lastName();
        String month = "08";
        String year = "25";
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, cardHolder, cvv);
    }

    public static Card getCardHolderWithSpecialSymbols() {
        Faker faker = new Faker();
        String cardHolder = faker.name().firstName() + faker.name().lastName() + "#";
        String month = "04";
        String year = "26";
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, cardHolder, cvv);
    }

    public static Card getCardHolderEmptyField() {
        Faker faker = new Faker();
        String cardHolder = " ";
        String month = "11";
        String year = "25";
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, cardHolder, cvv);
    }

    public static Card getCardMonthLessThan2Figures() {
        Faker faker = new Faker();
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String month = "1";
        String year = "24";
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, cardHolder, cvv);
    }

    public static Card getCardMonthEqual00() {
        Faker faker = new Faker();
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String month = "00";
        String year = "24";
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, cardHolder, cvv);
    }

    public static Card getCardMonthMoreThan12() {
        Faker faker = new Faker();
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String month = "13";
        String year = "24";
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, cardHolder, cvv);
    }

    public static Card getCardMonthEmptyField() {
        Faker faker = new Faker();
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String month = " ";
        String year = "24";
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, cardHolder, cvv);
    }


    public static Card getCardCurrentMonthAndYear() {
        Faker faker = new Faker();
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String month = LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
        String year = LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, cardHolder, cvv);
    }

    public static Card getCardCurrentMonthAndYearPlus5Years() {
        Faker faker = new Faker();
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String month = LocalDate.now().plusYears(5).format(DateTimeFormatter.ofPattern("MM"));
        String year = LocalDate.now().plusYears(5).format(DateTimeFormatter.ofPattern("YY"));
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, cardHolder, cvv);
    }

    public static Card getCardCurrentMonthAndYearMinus1Month() {
        Faker faker = new Faker();
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String month = LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
        String year = LocalDate.now().format(DateTimeFormatter.ofPattern("YY"));
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, cardHolder, cvv);
    }

    public static Card getCardCurrentMonthAndYearPlus1MonthPlus5Years() {
        Faker faker = new Faker();
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        String month = LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
        String year = LocalDate.now().plusYears(5).format(DateTimeFormatter.ofPattern("YY"));
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, cardHolder, cvv);
    }

    public static Card getCardYearEmptyField() {
        Faker faker = new Faker();
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        ;
        String month = "11";
        String year = " ";
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, cardHolder, cvv);
    }

    public static Card getCardYearOnlyOneFigure() {
        Faker faker = new Faker();
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        ;
        String month = "11";
        String year = "2";
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, cardHolder, cvv);
    }

    public static Card getCardCvv000() {
        Faker faker = new Faker();
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        ;
        String month = "11";
        String year = "26";
        String cvv = "000";
        return new Card("4444444444444441", month, year, cardHolder, cvv);
    }

    public static Card getCardCvvLessThanThreeFigures() {
        Faker faker = new Faker();
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        ;
        String month = "11";
        String year = "2";
        String cvv = "23";
        return new Card("4444444444444441", month, year, cardHolder, cvv);
    }

    public static Card getCardYearCvvEmptyField() {
        Faker faker = new Faker();
        String cardHolder = faker.name().firstName() + " " + faker.name().lastName();
        ;
        String month = "11";
        String year = "2";
        String cvv = " ";
        return new Card("4444444444444441", month, year, cardHolder, cvv);
    }


    public static String getShiftedMonth() {
        int shift = (int) (Math.random() * 10);
        return LocalDate.now().plusMonths(shift).format(DateTimeFormatter.ofPattern("MM"));
    }


    public static String getShiftedYear(int yearCount) {
        return LocalDate.now().plusYears(yearCount).format(DateTimeFormatter.ofPattern("YY"));
    }

    public static Card getCardNumberLessThan15Symbols() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        String number = faker.number().digits(15);
        return new Card(number, month, year, holder, cvv);
    }

    public static Card getCardNotInDatabase() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new Card("1444444444444444", month, year, holder, cvv);
    }

    public static Card getCardMonth1Symbol() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = faker.number().digit();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, holder, cvv);
    }

    public static Card getCardMonthOver12() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", "13", year, holder, cvv);
    }

    public static Card getCardMonth00ThisYear() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String year = getShiftedYear(0);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", "00", year, holder, cvv);
    }

    public static Card getCardMonth00OverThisYear() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", "00", year, holder, cvv);
    }

    public static Card getCardYear1Symbol() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = faker.number().digit();
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, holder, cvv);
    }

    public static Card getCardYearOverThisYearOn6() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear(6);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, holder, cvv);
    }

    public static Card getCardYearUnderThisYear() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, holder, cvv);
    }

    public static Card getCardYear00() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, "00", holder, cvv);
    }

    public static Card getCardCvv1Symbol() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(1);
        return new Card("4444444444444441", month, year, holder, cvv);
    }

    public static Card getCardCvv2Symbols() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(2);
        return new Card("4444444444444441", month, year, holder, cvv);
    }

    public static Card getCardHolder1Word() {
        Faker faker = new Faker();
        String holder = faker.name().firstName();
        String month = getShiftedMonth();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, holder, cvv);
    }

    public static Card getCardHolderCyrillic() {
        Faker faker = new Faker(new Locale("ru"));
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, holder, cvv);
    }

    public static Card getCardHolderNumeric() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.number().digit();
        String month = getShiftedMonth();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, holder, cvv);
    }

    public static Card getCardSpecialSymbols() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " %$ * &";
        String month = getShiftedMonth();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, holder, cvv);
    }
}

