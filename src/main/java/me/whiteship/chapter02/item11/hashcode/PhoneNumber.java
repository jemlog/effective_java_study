package me.whiteship.chapter02.item11.hashcode;

import me.whiteship.chapter02.item10.Point;

import java.util.*;

// equals를 재정의하면 hashCode로 재정의해야 함을 보여준다. (70-71쪽)
public final class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix   = rangeCheck(prefix,   999, "prefix");
        this.lineNum  = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

//    @Override
//    public int hashCode() {
//        return 42;
//    }

    // hashCode 없이는 제대로 동작하지 않는다. 다음 셋 중 하나를 활성화하자.

//     코드 11-2 전형적인 hashCode 메서드 (70쪽)
//    @Override public int hashCode() {
//        int result = Short.hashCode(areaCode); // 1 TODO: 핵심 필드 중에 하나 고르고, 그 필드의 해시코드 구함.
//        // TODO : reference의 경우에는 그 객체의 hascode()를 호출한다.
//        // TODO : Arrays.hascode()도 사용 가능
//        result = 31 * result + Short.hashCode(prefix); // 2 왜 31? 홀수를 써야 한다. 짝수 연산은 뒤에 0이 채워진다.
//        // TODO : 31은 홀수! 짝수 연산은 뒤에 0이 채워진다.
//        // TODO : 해시충돌이 가장 작게 나는 숫자를 찾아봤을때 31이 나왔다!
//        // TODO : 해시의 핵심은 골고루 나오는 것이다!
//        result = 31 * result + Short.hashCode(lineNum); // 3
//        return result;
//    }

    // 코드 11-3 한 줄짜리 hashCode 메서드 - 성능이 살짝 아쉽다. (71쪽)
//    @Override public int hashCode() {
//        return Objects.hash(lineNum, prefix, areaCode); TODO : 사실 그냥 인텔리제이에서 제공하는 Objects.hash 쓰면 됨. 내부적으로 31씀
//    }

    // 해시코드를 지연 초기화하는 hashCode 메서드 - 스레드 안정성까지 고려해야 한다. (71쪽)
    private volatile int hashCode; // 자동으로 0으로 초기화된다.
    // TODO : volatile은 데이터를 캐시가 아닌 메인 메모리에서 가져와준다!
    @Override public int hashCode() { // TODO : Synchronized는 lock 사용
        if (this.hashCode != 0) {
            return hashCode;
        }
        // T1, T2 들어오면? 블락 만큼은 동기화 락이 걸려버린다.
        synchronized (this) {
            int result = hashCode;
            // TODO : 이 코드에 여러 쓰레드가 동시에 들어오면? 계산이 서로 엇갈리면 해시코드 값이 다르게 될 수도 있다!
            if (result == 0) {
                result = Short.hashCode(areaCode);
                result = 31 * result + Short.hashCode(prefix);
                result = 31 * result + Short.hashCode(lineNum);
                this.hashCode = result;
            }
            return result;
        }

    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber(707, 867, 5309), "제니");
        System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
    }
}
