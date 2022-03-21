package com.netcracker;

import com.netcracker.part1.*;
import com.netcracker.part2.Ball;
import com.netcracker.part2.Container;
import com.netcracker.part2.MyComplex;
import com.netcracker.part2.MyPolynomial;


public class Main {
    public static void main(String[] args) {
//    Проверка для Circle
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(2.0, "green");

        System.out.println("Circle default: " + circle1);
        System.out.println("Area for " + circle2 + " = " + circle2.getArea());
        System.out.println("___________________________________________________");

//    Проверка для Rectangle
        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle(2, 4);

        System.out.println("Rectangle default: " + rectangle1);
        System.out.println("Area for " + rectangle2 + " = " + rectangle2.getArea() +
                            ", perimeter = " + rectangle2.getPerimeter());
        System.out.println("___________________________________________________");

//     Проверка для Employee
        Employee employee = new Employee(999, "Tom", "Riddle", 50000);

        System.out.println(employee);
        System.out.println("Annual salary (" + employee.getName() + "): " + employee.getAnnualSalary());
        System.out.println("Increase the salary by the percent: 8%, new salary: " + employee.raiseSalary(8));
        System.out.println("___________________________________________________");

//     Проверка для Book
        Author[] authors = new Author[3];
        authors[0] = new Author("Balandin D.B.", "dbalandin@yandex.ru", 'M');
        authors[1] = new Author("Kogan M.M.", "mkogan@nngasu.ru", 'M');
        authors[2] = new Author("Biryukov R.S.", "biryukovrs@gmail.com", 'M');
        String nameBook = "Finite-horizon multi-objective generalized H_2 control with transients";
        Book book = new Book(nameBook, authors, 0, 5);

        System.out.println(book);
        System.out.println("Authors: " + book.getAuthorNames());
        System.out.println("___________________________________________________");

//     Проверка для MyPoint
        MyPoint myPoint1 = new MyPoint();
        MyPoint myPoint2 = new MyPoint(4, 0);
        MyPoint myPoint3 = new MyPoint(0, 3);

        System.out.println("Point default: " + myPoint1);
        System.out.println("Distance from point " + myPoint2 +  " to point (1,9) = " + myPoint2.distance(1,9));
        System.out.println("Distance from point " + myPoint2 + " to point " + myPoint3 + " = " + myPoint2.distance(myPoint3));
        System.out.println("Distance from point " + myPoint2 + " to point " + myPoint1 + " = " + myPoint2.distance());
//        int[] a = myPoint1.getXY();
//        System.out.println(Arrays.toString(a));
        System.out.println("___________________________________________________");

//     Проверка для MyTriangle, три точки с целыми координатами не могут быть вершинами равностор. треуг.
        MyTriangle myTriangle1 = new MyTriangle(0, 0, 0, 3, 3, 0);
        MyTriangle myTriangle2 = new MyTriangle(myPoint1, myPoint2, myPoint3);
        System.out.println(myTriangle2);
        System.out.println("Perimeter for " + myTriangle1 + ": " + "\n"+ myTriangle1.getPerimeter());
        System.out.println("Type: " + myTriangle1.getType());
        System.out.println("Perimeter for " + myTriangle2 + ": " + "\n"+ myTriangle2.getPerimeter());
        System.out.println("Type: " + myTriangle2.getType());
        System.out.println("___________________________________________________");

//    Вторая часть
        System.out.println("___________________________________________________");

//    Проверка для MyComplex
        MyComplex myComplex1 = new MyComplex(5, -4);
        MyComplex myComplex2 = new MyComplex(1, 4);

        System.out.println("The result of adding a complex number " + myComplex1 + " and " + myComplex2+" :");
        System.out.println(myComplex1.addNew(myComplex2));
        System.out.println("Are the numbers equal? " + (myComplex1==myComplex2));
        System.out.println("The absolute value of a number 1:" + myComplex1.magnitude());
        System.out.println("Argument: " + myComplex1.argument());
        System.out.println("Addition, subtraction, multiplication, division in this instance:");
        System.out.println( myComplex1 + " + " + myComplex2 + " = ");
        System.out.println(myComplex1.add(myComplex2));
        System.out.println(myComplex1 + " - " + myComplex2 + " = ");
        System.out.println(myComplex1.subtract(myComplex2));
        System.out.println(myComplex1 + " * " + myComplex2 + " = ");
        System.out.println(myComplex1.multiply(myComplex2));
        System.out.println(myComplex1 + " / " + myComplex2 + " = " );
        System.out.println(myComplex1.divide(myComplex2));
        System.out.println("Conjugate number with " + myComplex1 + " : " + myComplex1.conjugate());
        System.out.println("___________________________________________________");

//    Проверка для MyPolynomial
        MyPolynomial myPolynomial1 = new MyPolynomial(5,-1,7,2,3);
        MyPolynomial myPolynomial2 = new MyPolynomial(-3,1,5);

        System.out.println("1) " + myPolynomial1);
        System.out.println("2) " + myPolynomial2);
        System.out.println("The result of adding two polynomials: ");
        System.out.println(myPolynomial1.add(myPolynomial2));
        System.out.println("Calculation of the polynomial " + myPolynomial2 + " at x = 1: ");
        System.out.println(myPolynomial2.evaluate(1));
        System.out.println("Polynomial multiplication: " + myPolynomial1.multiply(myPolynomial2));
        System.out.println("___________________________________________________");


//    Проверка для Ball и Container
        Container container = new Container(0, 5, 5, 5);
        Ball ball = new Ball(2, 2, 1, 1, 45);

        System.out.println(container);
        System.out.println(ball);
        System.out.println(container.collides(ball));

        ball.move();
        System.out.println(ball);
        System.out.println(container.collides(ball));

        ball.setxDelta(2);
        ball.setyDelta(1);
        ball.move();
        System.out.println(ball);
        System.out.println(container.collides(ball));
        ball.reflectHorizontal();
       
        ball.move();
        System.out.println(ball);
        System.out.println(container.collides(ball));





    }

}

