package me.whiteship.chapter02.item10;

import java.util.ArrayList;
import java.util.List;

// 단순한 불변 2차원 정수 점(point) 클래스 (56쪽)
public class Point {

    private final int x; // TODO : 생성자로 한번 받고 immutable 하게 만들기, 값 변경 불가능이다.
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//
//        if (!(o instanceof Point)) {
//            return false;
//        }
//
//        Point p = (Point) o;
//        return p.x == x && p.y == y;
        // TODO : equals를 정의할 때 가장 먼저 해야 하는 것 : 같은지를 체크하는것!
        if(this == o)
        {   // TODO : 객체 동일성 -> 반사성이 일치하는 것!
            return true;
        }

        synchronized (new Object())
        {
          // TODO : 락은 어떤 객체 하나가 가지고 있는 특정한 필드가 아니다!
        }
        if(!(o instanceof Point))
        {
            // TODO : 타입 비교하기
            return false;
        }

        Point p = (Point) o;

        // TODO : 여기서 중요한건 핵심적인 필드들만 비교해줘야 한다.
        // 일반 primitive 타입 비교시 == 사용, float, double은 부동소수점 때문에 자체 compare 사용, 참조타입은 equals 사용
        return p.x == x && p.y ==y;

    }

    public static void main(String[] args) {
        Point point = new Point(1, 2);
        List<Point> points = new ArrayList<>();
        points.add(point);
        System.out.println(points.contains(new Point(1, 2)));
    }

    // 잘못된 코드 - 리스코프 치환 원칙 위배! (59쪽)
//    @Override public boolean equals(Object o) {
//        if (o == null || o.getClass() != getClass())
//            return false;
//        Point p = (Point) o;
//        return p.x == x && p.y == y;
//
//    }

    // 아이템 11 참조
    @Override public int hashCode()  {
        return 31 * x + y;
    }
}
