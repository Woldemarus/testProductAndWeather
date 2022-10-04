package entities;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditCard {
    String name;
    BigDecimal balance;
    Currency currency;

    BigDecimal dept;

    Integer interestRate;

    public CreditCard(String Name, BigDecimal balance, Currency currency) {
        if(!Name.isEmpty()) {
            this.name = Name;
            this.balance = balance;
            this.currency = currency;

            //Хардкожу параметры чтобы не раздвувать юнит тесты
            this.dept = new BigDecimal(154000);
            this.interestRate = 30;
        }
    }

    public Boolean replenishment(BigDecimal  Sum) {
            this.balance = Operations.replenishment(this.balance, Sum);
            return  true;
    }
    public Boolean writeOff(BigDecimal  Sum) {
        this.balance = Operations.writeOff(this.balance, Sum);
        return  true;
    }
    public BigDecimal getBalance() {
        return this.balance;
    }


}
