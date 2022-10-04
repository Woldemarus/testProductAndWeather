package entities;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DebetCard {
    String name;
    BigDecimal balance;
    Currency currency;

    public DebetCard(String Name, BigDecimal balance, Currency currency) {
        if(!Name.isEmpty()) {
            this.name = Name;
            this.balance = balance;
            this.currency = currency;
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
