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
    public void payTestIsNotCheckedCorrectlyOne() {
        CreditAccount account = new CreditAccount(
                5_000,
                18_000,
                15
        );

        account.pay(5_000);

        Assertions.assertEquals(-0_000, account.getBalance());
    }

    @Test
    public void payTestIsNotCheckedCorrectlyTwo() {
        CreditAccount account = new CreditAccount(
                5_000,
                18_000,
                15
        );

        account.pay(8_000);

        Assertions.assertEquals(-3_000, account.getBalance());
    }

}
