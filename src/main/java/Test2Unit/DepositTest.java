package Test2Unit;

import entities.Currency;
import entities.Deposit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class DepositTest {

    @Test
    void close() {
        Deposit deposit = new Deposit("Название Депозита", new BigDecimal(-10), Currency.RUR);
        Assertions.assertEquals(deposit.getState(), true);
        deposit.Close();
        Assertions.assertEquals(deposit.getState(), false);
    }

    @Test
    void replenishment() {
        Deposit deposit = new Deposit("Название Депозита", new BigDecimal(-10), Currency.RUR);
        deposit.replenishment(new BigDecimal(10));
        Assertions.assertEquals(deposit.getBalance(), new BigDecimal(0));

        deposit = new Deposit("Название депозита", new BigDecimal(-10), Currency.RUR);
        deposit.replenishment(new BigDecimal(50));
        Assertions.assertEquals(deposit.getBalance(), new BigDecimal(40));

        deposit = new Deposit("Название депозита", new BigDecimal(-10), Currency.RUR);
        deposit.replenishment(new BigDecimal(0));
        Assertions.assertEquals(deposit.getBalance(), new BigDecimal(-10));

        deposit = new Deposit("Название депозита", new BigDecimal(0), Currency.RUR);
        deposit.replenishment(new BigDecimal(10));
        Assertions.assertEquals(deposit.getBalance(), new BigDecimal(10));

        deposit = new Deposit("Название депозита", new BigDecimal(10), Currency.RUR);
        deposit.replenishment(new BigDecimal(10));
        Assertions.assertEquals(deposit.getBalance(), new BigDecimal(20));

        deposit = new Deposit("Название депозита", new BigDecimal(0), Currency.RUR);
        deposit.replenishment(new BigDecimal(0));
        Assertions.assertEquals(deposit.getBalance(), new BigDecimal(0));
    }


    @Test
    void getBalance() {
        Deposit Deposit = new Deposit("Название депозита", new BigDecimal(10), Currency.RUR);
        Assertions.assertEquals(Deposit.getBalance(), new BigDecimal(10));
    }

    @Test
    void getName() {
        Deposit Deposit = new Deposit("Название депозита", new BigDecimal(10), Currency.RUR);
        Assertions.assertEquals(Deposit.getName(), "Название депозита");
    }

    @Test
    void getCurrency() {
        Deposit Deposit = new Deposit("Название депозита", new BigDecimal(10), Currency.RUR);
        Assertions.assertEquals(Deposit.getCurrency(), Currency.RUR);
    }

    @Test
    void setName() {
        Deposit Deposit = new Deposit("Название депозита", new BigDecimal(10), Currency.RUR);
        Deposit.setName("Название депозита 2");
        Assertions.assertEquals(Deposit.getName(), "Название депозита 2");
    }

    @Test
    void setBalance() {
        Deposit Deposit = new Deposit("Название депозита", new BigDecimal(10), Currency.RUR);
        Deposit.setBalance(new BigDecimal(20));
        Assertions.assertEquals(Deposit.getBalance(), new BigDecimal(20));
    }

    @Test
    void setCurrency() {
        Deposit Deposit = new Deposit("Название депозита", new BigDecimal(10), Currency.RUR);
        Deposit.setCurrency(Currency.JPU);
        Assertions.assertEquals(Deposit.getCurrency(), Currency.JPU);
    }
}