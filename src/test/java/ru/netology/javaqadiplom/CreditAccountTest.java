package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldRateMoreThanMax() {
        CreditAccount account = new CreditAccount(
                1_000,
                4_000,
                15_000
        );
        Assertions.assertEquals(0, account.yearChange());
    }


    @Test
    public void shouldAddToNegativeBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-2_000, 1000, 10);
        });

        String expected = "Начальный баланс не может быть отрицательным, а у вас: -2000";
        String actual = exception.getMessage();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAddToNegativeCreditLimit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(2_000, -1000, 10);
        });

        String expected = "Кредитный лимит не может быть отрицательным, а у вас: -1000";
        String actual = exception.getMessage();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectCreditLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                3_000,
                10);

        Assertions.assertEquals(3000, account.getCreditLimit());
    }

    @Test
    public void shouldDecreaseBalanceIfBalanceMoreThanAmount() {
        CreditAccount account = new CreditAccount(
                2_000,
                3000,
                10);

        account.pay(1000);

        Assertions.assertEquals(1000, account.getBalance());
    }


    @Test
    public void shouldAmountMoreThanCreditLimit() {
        CreditAccount account = new CreditAccount(
                2_000,
                4_000,
                15
        );
        account.pay(7_000);
        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldReplenishAmount() {
        CreditAccount account = new CreditAccount(
                2_000,
                8_000,
                10
        );
        account.add(3_000);
        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void CorrectYearChange() {
        CreditAccount account = new CreditAccount(
                3_000,
                5_000,
                10

        );
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldIncreaseBalanceIfAmountLessThanZero() {
        CreditAccount account = new CreditAccount(
                2_000,
                500,
                10);

        account.add(-500);

        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void shouldNotChangeBalanceIfAddZero() {
        CreditAccount account = new CreditAccount(
                3_000,
                1000,
                10);

        account.add(0);

        Assertions.assertEquals(3000, account.getBalance());
    }

    @Test
    public void shouldCalculatePercent() {
        CreditAccount account = new CreditAccount(
                1_000,
                500,
                15);

        account.pay(1_200);

        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test
    public void shouldNotCalculatePercentIfBalanceZero() {
        CreditAccount account = new CreditAccount(
                0,
                1000,
                10);

        Assertions.assertEquals(0, account.yearChange());
    }

}
