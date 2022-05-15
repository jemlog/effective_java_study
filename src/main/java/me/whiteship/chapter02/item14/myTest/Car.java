package me.whiteship.chapter02.item14.myTest;

public class Car implements Comparable<Car>{

    private int num;

    public Car(int num) {
        this.num = num;
    }
    public int getNum()
    {
        return this.num;
    }
    @Override
    public int compareTo(Car o) {
        int result;
        if(this.num > o.num)
        {
            result = 1;
        }
        else if(this.num == o.num)
        {
            result = 0;
        }
        else{
            result = -1;
        }
        return result;
    }
}
