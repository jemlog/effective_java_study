package me.whiteship.chapter02.item10.lombok;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * https://projectlombok.org/features/EqualsAndHashCode
 * https://projectlombok.org/features/ToString
 */
@EqualsAndHashCode // TODO : JAVA RECORD 공부하기
@ToString
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
