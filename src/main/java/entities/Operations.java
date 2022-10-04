package entities;

import java.math.BigDecimal;

public class Operations {

    public static BigDecimal replenishment(BigDecimal balance, BigDecimal sumAmount) {
            return balance.add(sumAmount);
    }
    public static BigDecimal writeOff(BigDecimal balance, BigDecimal minusAmount) {
            return balance.subtract(minusAmount);
    }

}
