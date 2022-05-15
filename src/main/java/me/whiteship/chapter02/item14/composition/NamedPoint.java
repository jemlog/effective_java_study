package me.whiteship.chapter02.item14.composition;

public class NamedPoint implements Comparable<NamedPoint> {

    // TODO : 컴포지션
    // TODO : 컴포지션이란? 상속을 받지 않고 부모라고 생각되는 녀석을 인스턴스 변수로 넣어주는 것이다.
    // TODO :  이렇게 되면 NamedPoint에서 아무 제약 없이 point 사용 가능!
    private final Point point;
    private final String name;

    public NamedPoint(Point point, String name) {
        this.point = point;
        this.name = name;
    }

    public Point getPoint() {
        return this.point;
    }

    @Override
    public int compareTo(NamedPoint namedPoint) {
        int result = this.point.compareTo(namedPoint.point);
        if (result == 0) {
            result = this.name.compareTo(namedPoint.name);
        }
        return result;
    }
}
