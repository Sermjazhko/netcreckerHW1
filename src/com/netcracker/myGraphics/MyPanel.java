package com.netcracker.myGraphics;

import com.netcracker.part2.Ball;
import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel{
    private com.netcracker.part2.Container container;

    private Ball ball;
    public MyPanel(com.netcracker.part2.Container container, Ball ball) {
        this.container = container;
        this.ball = ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.drawRect(container.getX(), container.getY(), container.getWidth(),
                container.getHeight());
        g2.setColor(Color.DARK_GRAY);
        g2.fillOval((int)ball.getX(), (int) ball.getY(), ball.getRadius(), ball.getRadius());
  }



}
