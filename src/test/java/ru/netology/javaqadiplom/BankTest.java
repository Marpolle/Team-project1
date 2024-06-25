package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test // Перевод отрицательной суммы с кредитного счета на сберегательный
    public void transferTestNegativeFromCreditAccountToSavingAccount() {

        CreditAccount creditAccount = new CreditAccount(
                10_000,
                20_000,
                5
        );
        SavingAccount savingAccount = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );
        Bank bank = new Bank();
        bank.transfer(creditAccount, savingAccount, -5_000);

        Assertions.assertEquals(10_000, creditAccount.getBalance());
        Assertions.assertEquals(5_000, savingAccount.getBalance());
    }


    @Test // Перевод положительной суммы с кредитного счета на сберегательный
    public void transferTestPositiveFromCreditAccountToSavingAccount() {

        CreditAccount creditAccount = new CreditAccount(
                10_000,
                20_000,
                5
        );
        SavingAccount savingAccount = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );
        Bank bank = new Bank();
        bank.transfer(creditAccount, savingAccount, 1_000);

        Assertions.assertEquals(9_000, creditAccount.getBalance());
        Assertions.assertEquals(6_000, savingAccount.getBalance());
    }

    @Test // Перевод нулевой суммы с кредитного счета на сберегательный
    public void transferTestZeroFromCreditAccountToSavingAccount() {

        CreditAccount creditAccount = new CreditAccount(
                10_000,
                20_000,
                5
        );
        SavingAccount savingAccount = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );
        Bank bank = new Bank();
        bank.transfer(creditAccount, savingAccount, 0);

        Assertions.assertEquals(10_000, creditAccount.getBalance());
        Assertions.assertEquals(5_000, savingAccount.getBalance());
    }

    @Test // Перевод суммы большей, чем величина кредитного лимита, с кредитного счета на сберегательный
    public void transferTestOverCreditLimitFromCreditAccountToSavingAccount() {

        CreditAccount creditAccount = new CreditAccount(
                1_000,
                5_000,
                5
        );
        SavingAccount savingAccount = new SavingAccount(
                5_000,
                1_000,
                15_000,
                5
        );

        Bank bank = new Bank();
        bank.transfer(creditAccount, savingAccount, 6_000);

        Assertions.assertEquals(5_000, creditAccount.getCreditLimit());
        Assertions.assertEquals(11_000, savingAccount.getBalance());
    }

    @Test // Перевод суммы равной величине кредитного лимита, с кредитного счета на сберегательный
    public void transferTestCreditLimitFromCreditAccountToSavingAccount() {

        CreditAccount creditAccount = new CreditAccount(
                1_000,
                5_000,
                5
        );
        SavingAccount savingAccount = new SavingAccount(
                5_000,
                1_000,
                15_000,
                5
        );

        Bank bank = new Bank();
        bank.transfer(creditAccount, savingAccount, 5_000);

        Assertions.assertEquals(5_000, creditAccount.getCreditLimit());
        Assertions.assertEquals(10_000, savingAccount.getBalance());
    }

    @Test
    // Превышение суммы Mаксимального баланса на сберегательном счете после осуществления операции перевода  с кредитного счета на сберегательный
    public void transferTestOverMaxBalanceFromCreditAccountToSavingAccount() {

        CreditAccount creditAccount = new CreditAccount(
                1_000,
                5_000,
                5
        );
        SavingAccount savingAccount = new SavingAccount(
                1_000,
                1_000,
                4_000,
                5
        );

        Bank bank = new Bank();
        bank.transfer(creditAccount, savingAccount, 4_000);

        Assertions.assertEquals(5_000, creditAccount.getCreditLimit());
        Assertions.assertEquals(4_000, savingAccount.getBalance());
    }

    @Test // Перевод отрицательной суммы со сберегательного счета на кредитный
    public void transferTestNegativeFromSavingAccountToCreditAccount() {

        SavingAccount savingAccount = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );
        CreditAccount creditAccount = new CreditAccount(
                10_000,
                20_000,
                5
        );

        Bank bank = new Bank();
        bank.transfer(savingAccount, creditAccount, -3_000);

        Assertions.assertEquals(5_000, savingAccount.getBalance());
        Assertions.assertEquals(10_000, creditAccount.getBalance());
    }


    @Test // Перевод нулевой суммы со сберегательного счета на кредитный
    public void transferTestZeroFromSavingAccountToCreditAccount() {

        SavingAccount savingAccount = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );
        CreditAccount creditAccount = new CreditAccount(
                10_000,
                20_000,
                5
        );

        Bank bank = new Bank();
        bank.transfer(savingAccount, creditAccount, 0_000);

        Assertions.assertEquals(5_000, savingAccount.getBalance());
        Assertions.assertEquals(10_000, creditAccount.getBalance());
    }

    @Test
    // Перевод суммы на кредитный счет с остатком на сберегательном счете меньше суммы Минимального баласа со сберегательного счета на кредитный
    public void transferTestLessMinBalanceFromSavingAccountToCreditAccount() {

        SavingAccount savingAccount = new SavingAccount(
                5_000,
                2_000,
                10_000,
                5
        );
        CreditAccount creditAccount = new CreditAccount(
                10_000,
                20_000,
                5
        );

        Bank bank = new Bank();
        bank.transfer(savingAccount, creditAccount, 4_000);

        Assertions.assertEquals(5_000, savingAccount.getBalance());
        Assertions.assertEquals(10_000, creditAccount.getBalance());
    }

    @Test
    // Перевод суммы на кредитный счет с остатком на сберегательном счете равной сумме Минимального баласа со сберегательного счета на кредитный
    public void transferTestMinBalanceFromSavingAccountToCreditAccount() {

        SavingAccount savingAccount = new SavingAccount(
                5_000,
                2_000,
                10_000,
                5
        );
        CreditAccount creditAccount = new CreditAccount(
                10_000,
                20_000,
                5
        );

        Bank bank = new Bank();
        bank.transfer(savingAccount, creditAccount, 3_000);

        Assertions.assertEquals(2_000, savingAccount.getBalance());
        Assertions.assertEquals(13_000, creditAccount.getBalance());
    }

    @Test // Перевод суммы на кредитный счет равной сумме Максимального баласа со сберегательного счета на кредитный
    public void transferTestMaxBalanceFromSavingAccountToCreditAccount() {

        SavingAccount savingAccount = new SavingAccount(
                5_000,
                2_000,
                10_000,
                5
        );
        CreditAccount creditAccount = new CreditAccount(
                10_000,
                20_000,
                5
        );

        Bank bank = new Bank();
        bank.transfer(savingAccount, creditAccount, 10_000);

        Assertions.assertEquals(5_000, savingAccount.getBalance());
        Assertions.assertEquals(10_000, creditAccount.getBalance());
    }

    @Test // Перевод суммы на кредитный счет большей, сумма Максимального баласа со сберегательного счета на кредитный
    public void transferTestOverMaxBalanceFromSavingAccountToCreditAccount() {

        SavingAccount savingAccount = new SavingAccount(
                5_000,
                2_000,
                10_000,
                5
        );
        CreditAccount creditAccount = new CreditAccount(
                10_000,
                20_000,
                5
        );

        Bank bank = new Bank();
        bank.transfer(savingAccount, creditAccount, 15_000);

        Assertions.assertEquals(5_000, savingAccount.getBalance());
        Assertions.assertEquals(10_000, creditAccount.getBalance());
    }

    @Test //
    public void transferTestPositiveFromCreditAccountToSavingAccountNew() {

        CreditAccount creditAccount = new CreditAccount(
                3_000,
                20_000,
                5
        );
        SavingAccount savingAccount = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );
        Bank bank = new Bank();
        bank.transfer(creditAccount, savingAccount, 3_000);

        Assertions.assertEquals(0_000, creditAccount.getBalance());
        Assertions.assertEquals(8_000, savingAccount.getBalance());
    }

}


