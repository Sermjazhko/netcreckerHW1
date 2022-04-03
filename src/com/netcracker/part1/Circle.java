package com.netcracker.part1;

import java.util.Objects;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle(){}

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle[" +
                "radius= " + radius +
                ", color= " + color  +
                ']';
    }

    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Circle circle = (Circle) obj;
        return Double.compare(circle.radius, radius) == 0 && this.color.equals(circle.color);
    }

    @Override
    public int hashCode() {
        int result=17;
        long t = Double.doubleToLongBits(radius);

        result = 31*result + color.hashCode();
        result = 31*result + (int)(t ^ (t >>> 32));

        return result;
    }
}
