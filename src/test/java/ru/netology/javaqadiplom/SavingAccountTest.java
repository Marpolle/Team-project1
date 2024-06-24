package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void initialBalanceTakesNegativeValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(-2_000, 0, 10_000, 5);
        });
    }

    @Test
    public void minBalanceTakesNegativeValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(1_000, -1_000, 10_000, 5);
        });
    }

    @Test
    public void maxBalanceTakesNegativeValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(1_000, 1_000, -10_000, 5);
        });
    }

    @Test
    public void minBalanceMoreThanMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(1_000, 100_000, 2_000, 5);
        });
    }


    @Test
    public void maxBalanceLessThanMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(1_000, 30_000, 1_000, 5);
        });
    }

    @Test
    public void initialBalanceMoreMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(100_000, 1_000, 5_000, 5);
        });
    }

    @Test
    public void initialBalanceLessMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(1_000, 2_000, 5_000, 5);
        });
    }

    @Test
    public void payTestWork() {
        SavingAccount account = new SavingAccount(
                7_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_000);

        Assertions.assertEquals(6_000, account.getBalance());
    }

    @Test
    public void payTestAmountMoreThanInitialBalance() {
        SavingAccount account = new SavingAccount(
                7_000,
                1_000,
                10_000,
                5
        );

        account.pay(8_000);

        Assertions.assertEquals(7_000, account.getBalance());
    }


    @Test
    public void payTestAmountMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                7_000,
                1_000,
                10_000,
                5
        );

        account.pay(15_000);

        Assertions.assertEquals(7_000, account.getBalance());
    }

    @Test
    public void addTest() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void addTestBalanceMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                8_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(10_000, account.getBalance());
    }

    @Test
    public void yearChange() {
        SavingAccount account = new SavingAccount(
                8_000,
                1_000,
                10_000,
                20
        );

        Assertions.assertEquals(1600, account.yearChange());
    }


    @Test
    public void yearChangeThanRateEqualToZero() {
        SavingAccount account = new SavingAccount(
                8_000,
                1_000,
                10_000,
                0
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void yearChangeThanRateEqualMax() {
        SavingAccount account = new SavingAccount(
                8_000,
                1_000,
                10_000,
                20_000
        );

        Assertions.assertEquals(1_600_000, account.yearChange());
    }

}