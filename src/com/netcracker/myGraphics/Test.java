package com.netcracker.myGraphics;
import com.netcracker.part2.Ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test implements ActionListener{

    private  JFrame f;
    private MyPanel p;
    private com.netcracker.part2.Container container;
    private Ball ball;

    public Test(com.netcracker.part2.Container container, Ball ball){
        this.container = container;
        this.ball = ball;
        Timer timer = new Timer(2000,this);
        timer.setDelay(45);
        timer.start();
    }

    public void createAndShow(){
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p = new MyPanel(container,ball);
        //f.setContentPane(p);
        f.add(p);
        f.pack();
        f.validate();
        f.repaint();
        f.setSize(500,500);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        float right = ball.getX() + ball.getRadius();
        float left = ball.getX();
        float top = ball.getY();
        float bottom = ball.getY() + ball.getRadius();
        int x2 = container.getX()+container.getWidth();
        int x1 = container.getX();
        int y2 = container.getY()+container.getHeight();
        int y1 = container.getY();

        if (!container.collides(ball)) {
            if (right > x2 || left < x1)
                ball.reflectHorizontal();
            if(top < y1 || bottom > y2)
                ball.reflectVertical();
            p.setBall(ball);
        }
        ball.move();
        p.setBall(ball);
        f.add(p);
        f.repaint();
    }
}
