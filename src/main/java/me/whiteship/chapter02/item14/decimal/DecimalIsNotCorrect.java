package me.whiteship.chapter02.item14.decimal;

import java.math.BigDecimal;

public class DecimalIsNotCorrect {

    public static void main(String[] args) {
        // TODO : 이렇게 계산하면 가수부 표현하다가 살짝 짤린다.
        int i = 1;
        double d = 0.1;
        System.out.println(i - d * 9);

        // TODO : 금융권처럼 숫자 예민할때는 double이나 float 말고 BigDecimal 사용해야함!
        BigDecimal bd = BigDecimal.valueOf(0.1);
        System.out.println(BigDecimal.valueOf(1).min(bd.multiply(BigDecimal.valueOf(9))));
    }
}
