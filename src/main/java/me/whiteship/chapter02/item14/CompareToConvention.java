package me.whiteship.chapter02.item14;

import java.math.BigDecimal;

public class CompareToConvention {

    public static void main(String[] args) {
        BigDecimal n1 = BigDecimal.valueOf(23134134);
        BigDecimal n2 = BigDecimal.valueOf(11231230);
        BigDecimal n3 = BigDecimal.valueOf(53534552);
        BigDecimal n4 = BigDecimal.valueOf(11231230);

        // TODO : 반사성 : 자기자신과 비교를 했을때 같다고 나와야 한다.

        // p88, 반사성
        // TODO : 내 자신이 넘겨받은 객체보다 크다면 양수, 같다면 0 , 작다면 음수
        System.out.println(n1.compareTo(n1));

        // p88, 대칭성
        // TODO : 한쪽이 1이 나오면 다른쪽은 -1이 나와야 한다.
        System.out.println(n1.compareTo(n2));
        System.out.println(n2.compareTo(n1));

        // p89, 추이성
        // TODO :
        System.out.println(n3.compareTo(n1) > 0);
        System.out.println(n1.compareTo(n2) > 0);
        System.out.println(n3.compareTo(n2) > 0);

        // p89, 일관성
        // TODO : 만약 두 수가 같다면,
        System.out.println(n4.compareTo(n2));
        System.out.println(n2.compareTo(n1));
        System.out.println(n4.compareTo(n1));

        // p89, compareTo가 0이라면 equals는 true여야 한다. (아닐 수도 있고..)
        // TODO : 안지켜질수도 있는 예제
        // TODO : equals는 스케일 꼼꼼히 고려
        // TODO : compareTo는 스케일 무시
        BigDecimal oneZero = new BigDecimal("1.0");
        BigDecimal oneZeroZero = new BigDecimal("1.00");
        System.out.println(oneZero.compareTo(oneZeroZero)); // Tree, TreeMap
        System.out.println(oneZero.equals(oneZeroZero)); // 순서가 없는 콜렉션
    }
}
