package edu.feng.parklotback.pojo;

/**
 * @program: parklot-test
 * @description:
 * @author: feng
 * @create: 2020-02-25 15:47
 * 点类
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}