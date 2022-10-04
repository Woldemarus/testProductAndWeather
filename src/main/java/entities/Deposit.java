package entities;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Deposit {
    String name;
    BigDecimal balance;
    Currency currency;
    Boolean state = false;

    public Deposit(String Name, BigDecimal balance, Currency currency) {
        if(!Name.isEmpty()) {
            this.name = Name;
            this.balance = balance;
            this.currency = currency;
            state = true;
        }
    }

    public Boolean replenishment(BigDecimal  Sum) {
            this.balance = Operations.replenishment(this.balance, Sum);
            return  true;
    }

    public Boolean Close() {
        this.state = false;
        return  true;
    }
}
