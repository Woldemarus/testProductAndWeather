package Test2Unit;

import entities.CreditCard;
import entities.Currency;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CreditCardTest {

    @Test
    void replenishment() {
        CreditCard сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(-10), Currency.RUR);
        сreditCard.replenishment(new BigDecimal(10));
        Assert.assertEquals(сreditCard.getBalance(), new BigDecimal(0));

        сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(-10), Currency.RUR);
        сreditCard.replenishment(new BigDecimal(50));
        Assert.assertEquals(сreditCard.getBalance(), new BigDecimal(40));

        сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(-10), Currency.RUR);
        сreditCard.replenishment(new BigDecimal(0));
        Assert.assertEquals(сreditCard.getBalance(), new BigDecimal(-10));

        сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(0), Currency.RUR);
        сreditCard.replenishment(new BigDecimal(10));
        Assert.assertEquals(сreditCard.getBalance(), new BigDecimal(10));

        сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(10), Currency.RUR);
        сreditCard.replenishment(new BigDecimal(10));
        Assert.assertEquals(сreditCard.getBalance(), new BigDecimal(20));

        сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(0), Currency.RUR);
        сreditCard.replenishment(new BigDecimal(0));
        Assert.assertEquals(сreditCard.getBalance(), new BigDecimal(0));
    }

    @Test
    void writeOff() {
        CreditCard сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(-10), Currency.RUR);
        сreditCard.writeOff(new BigDecimal(50));
        Assert.assertEquals(new BigDecimal(-60), сreditCard.getBalance());

        сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(-10), Currency.RUR);
        сreditCard.writeOff(new BigDecimal(0));
        Assert.assertEquals(new BigDecimal(-10), сreditCard.getBalance());

        сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(0), Currency.RUR);
        сreditCard.writeOff(new BigDecimal(50));
        Assert.assertEquals(new BigDecimal(-50), сreditCard.getBalance());

        сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(0), Currency.RUR);
        сreditCard.writeOff(new BigDecimal(0));
        Assert.assertEquals(new BigDecimal(0), сreditCard.getBalance());

        сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(10), Currency.RUR);
        сreditCard.writeOff(new BigDecimal(10));
        Assert.assertEquals(new BigDecimal(0), сreditCard.getBalance());

        сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(10), Currency.RUR);
        сreditCard.writeOff(new BigDecimal(20));
        Assert.assertEquals(new BigDecimal(-10), сreditCard.getBalance());
    }

    @Test
    void getDept() {
        CreditCard сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(10), Currency.RUR);
        Assert.assertEquals(сreditCard.getDept(), new BigDecimal(154000));
    }

    @Test
    void getInterestRate() {
        CreditCard сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(10), Currency.RUR);
        Assert.assertEquals(сreditCard.getInterestRate(), new Integer(30));
    }

    @Test
    void getBalance() {
        CreditCard сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(10), Currency.RUR);
        Assert.assertEquals(сreditCard.getBalance(), new BigDecimal(10));
    }

    @Test
    void getName() {
        CreditCard сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(10), Currency.RUR);
        Assert.assertEquals(сreditCard.getName(), "Название кредитной карты");
    }

    @Test
    void getCurrency() {
        CreditCard сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(10), Currency.RUR);
        Assert.assertEquals(сreditCard.getCurrency(), Currency.RUR);
    }

    @Test
    void setName() {
        CreditCard сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(10), Currency.RUR);
        сreditCard.setName("Название кредитной карты 2");
        Assert.assertEquals(сreditCard.getName(), "Название кредитной карты 2");
    }

    @Test
    void setBalance() {
        CreditCard сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(10), Currency.RUR);
        сreditCard.setBalance(new BigDecimal(20));
        Assert.assertEquals(сreditCard.getBalance(), new BigDecimal(20));
    }

    @Test
    void setCurrency() {
        CreditCard сreditCard = new CreditCard("Название кредитной карты", new BigDecimal(10), Currency.RUR);
        сreditCard.setCurrency(Currency.JPU);
        Assert.assertEquals(сreditCard.getCurrency(), Currency.JPU);
    }
}