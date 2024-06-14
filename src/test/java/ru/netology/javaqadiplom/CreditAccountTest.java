package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        CreditAccount account = new CreditAccount(
                -1_000,
                5_000,
                15
        );
        account.add(0);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeCreditLimit() {
        CreditAccount account = new CreditAccount(
                1_000,
                -5_000,
                15
        );
        account.add(0);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldInitialBalanceMoreThanCreditLimit() {
        CreditAccount account = new CreditAccount(
                5_000,
                3_000,
                15
        );
        account.add(0);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAmountMoreThanCreditLimit() {
        CreditAccount account = new CreditAccount(
                2_000,
                6_000,
                15
        );
        account.pay(7_000);
        Assertions.assertEquals(0, account.getBalance());
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
        Assertions.assertEquals(300, account.yearChange());
    }
}
