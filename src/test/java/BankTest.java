import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqadiplom.Account;
import ru.netology.javaqadiplom.Bank;

public class BankTest {
    @Test
    public void shouldTransfer() {
        Account from = new Account();
        from.balance = 1_000;
        Account to = new Account();
        to.balance = 2_000;
        Bank bank = new Bank();
        bank.transfer(from, to, 500);

        int expectedFrom = 500;
        int actualFrom = from.getBalance();
        Assertions.assertEquals(expectedFrom, actualFrom);

        int expectedTo = 2_500;
        int actualTo = to.getBalance();
        Assertions.assertEquals(expectedTo, actualTo);
    }
@Test
public void shouldIfAmountEqualsBalanceFrom() {
    Account from = new Account();
    from.balance = 3_000;
    Account to = new Account();
    to.balance = 1_000;
    Bank bank = new Bank();
    bank.transfer(from, to, 3_000);

    int expectedFrom = 0;
    int actualFrom = from.getBalance();
    Assertions.assertEquals(expectedFrom, actualFrom);

    int expectedTo = 4_000;
    int actualTo = to.getBalance();
    Assertions.assertEquals(expectedTo, actualTo);
}

}
