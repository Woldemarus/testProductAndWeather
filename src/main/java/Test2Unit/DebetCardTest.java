package Test2Unit;

import entities.Currency;
import entities.DebetCard;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class DebetCardTest {

    @Test
    void replenishment() {
        DebetCard debetCard = new DebetCard("Название дебетовой карты", new BigDecimal(-10), Currency.RUR);
        debetCard.replenishment(new BigDecimal(10));
        Assert.assertEquals(debetCard.getBalance(), new BigDecimal(0));

        debetCard = new DebetCard("Название дебетовой карты", new BigDecimal(-10), Currency.RUR);
        debetCard.replenishment(new BigDecimal(50));
        Assert.assertEquals(debetCard.getBalance(), new BigDecimal(40));

        debetCard = new DebetCard("Название дебетовой карты", new BigDecimal(-10), Currency.RUR);
        debetCard.replenishment(new BigDecimal(0));
        Assert.assertEquals(debetCard.getBalance(), new BigDecimal(-10));

        debetCard = new DebetCard("Название дебетовой карты", new BigDecimal(0), Currency.RUR);
        debetCard.replenishment(new BigDecimal(10));
        Assert.assertEquals(debetCard.getBalance(), new BigDecimal(10));

        debetCard = new DebetCard("Название дебетовой карты", new BigDecimal(10), Currency.RUR);
        debetCard.replenishment(new BigDecimal(10));
        Assert.assertEquals(debetCard.getBalance(), new BigDecimal(20));

        debetCard = new DebetCard("Название дебетовой карты", new BigDecimal(0), Currency.RUR);
        debetCard.replenishment(new BigDecimal(0));
        Assert.assertEquals(debetCard.getBalance(), new BigDecimal(0));
    }

    @Test
    void writeOff() {
        DebetCard debetCard = new DebetCard("Название дебетовой карты", new BigDecimal(-10), Currency.RUR);
        debetCard.writeOff(new BigDecimal(50));
        Assert.assertEquals(debetCard.getBalance(), new BigDecimal(-60));

        debetCard = new DebetCard("Название дебетовой карты", new BigDecimal(-10), Currency.RUR);
        debetCard.writeOff(new BigDecimal(0));
        Assert.assertEquals(debetCard.getBalance(), new BigDecimal(-10));

        debetCard = new DebetCard("Название дебетовой карты", new BigDecimal(0), Currency.RUR);
        debetCard.writeOff(new BigDecimal(50));
        Assert.assertEquals(debetCard.getBalance(), new BigDecimal(-50));

        debetCard = new DebetCard("Название дебетовой карты", new BigDecimal(0), Currency.RUR);
        debetCard.writeOff(new BigDecimal(0));
        Assert.assertEquals(debetCard.getBalance(), new BigDecimal(0));

        debetCard = new DebetCard("Название дебетовой карты", new BigDecimal(10), Currency.RUR);
        debetCard.writeOff(new BigDecimal(10));
        Assert.assertEquals(debetCard.getBalance(), new BigDecimal(0));

        debetCard = new DebetCard("Название дебетовой карты", new BigDecimal(10), Currency.RUR);
        debetCard.writeOff(new BigDecimal(20));
        Assert.assertEquals(debetCard.getBalance(), new BigDecimal(-10));
    }

    @Test
    void getBalance() {
        DebetCard debetCard = new DebetCard("Название дебетовой карты", new BigDecimal(10), Currency.RUR);
        Assert.assertEquals(debetCard.getBalance(), new BigDecimal(10));
    }

    @Test
    void getName() {
        DebetCard debetCard = new DebetCard("Название дебетовой карты", new BigDecimal(10), Currency.RUR);
        Assert.assertEquals(debetCard.getName(), "Название дебетовой карты");
    }

    @Test
    void getCurrency() {
        DebetCard debetCard = new DebetCard("Название дебетовой карты", new BigDecimal(10), Currency.RUR);
        Assert.assertEquals(debetCard.getCurrency(), Currency.RUR);
    }

    @Test
    void setName() {
        DebetCard debetCard = new DebetCard("Название дебетовой карты", new BigDecimal(10), Currency.RUR);
        debetCard.setName("Название дебетовой карты 2");
        Assert.assertEquals(debetCard.getName(), "Название дебетовой карты 2");
    }

    @Test
    void setBalance() {
        DebetCard debetCard = new DebetCard("Название дебетовой карты", new BigDecimal(10), Currency.RUR);
        debetCard.setBalance(new BigDecimal(20));
        Assert.assertEquals(debetCard.getBalance(), new BigDecimal(20));
    }

    @Test
    void setCurrency() {
        DebetCard debetCard = new DebetCard("Название дебетовой карты", new BigDecimal(10), Currency.RUR);
        debetCard.setCurrency(Currency.JPU);
        Assert.assertEquals(debetCard.getCurrency(), Currency.JPU);
    }
}