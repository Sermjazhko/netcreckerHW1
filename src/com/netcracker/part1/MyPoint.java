package com.netcracker.part1;

public class MyPoint {
    private int x = 0;
    private int y = 0;

    public MyPoint() {}

    public MyPoint(int x, int y) {
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

    public int[] getXY() {
        int[] coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;
        return coordinates;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x +
                "," + y +
                ")";
    }

    public double distance(int x, int y) {
        return Math.sqrt(Math.pow(y-this.y,2) + Math.pow(x-this.x,2));
    }

    public double distance(MyPoint another) {
        return Math.sqrt(Math.pow(another.getY()-this.y,2) + Math.pow(another.getX()-this.x,2));
    }

    public double distance(){
        return Math.sqrt(Math.pow(this.y,2) + Math.pow(this.x,2));
    }
}
