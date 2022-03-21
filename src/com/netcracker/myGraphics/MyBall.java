package com.netcracker.myGraphics;

import com.netcracker.part2.Ball;

import javax.swing.*;
import java.awt.*;
public class MyBall extends JPanel{

    private Ball ball;
    public MyBall( Ball ball) {
        this.ball = ball;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // cast Graphics to Graphics2D
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black); // sets Graphics2D color
        g2.fillOval((int)ball.getX(), (int) ball.getY(), ball.getRadius(), ball.getRadius());

    }



}
