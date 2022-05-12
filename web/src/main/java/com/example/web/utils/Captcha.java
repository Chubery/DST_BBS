package com.example.web.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class Captcha {
    private int width = 100;
    private int height = 40;
    private String text;
    private Random random = new Random();
    private String codes = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";

    private char randomChar() {
        int index = random.nextInt(codes.length());
        return codes.charAt(index);
    }

    private void drawLine(BufferedImage image) {
        int num = 3;
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();
        for (int i = 0; i < num; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            graphics2D.setColor(new Color(144, 147, 153));
            graphics2D.drawLine(x1, y1, x2, y2);
        }
    }

    private BufferedImage createImage() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();
        graphics2D.setColor(new Color(255, 255, 255));
        graphics2D.fillRect(0, 0, width, height);
        return image;
    }

    public BufferedImage getImage() {
        BufferedImage image = createImage();
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i< 4; i++) {
            String s = randomChar() + "";
            sb.append(s);
            float x = i * 1.0F * width / 4;
            graphics2D.setFont(new Font("宋体", 1, 30));
            graphics2D.setColor(new Color(60, 60, 60));
            graphics2D.drawString(s, x, height-5);
        }
        this.text = sb.toString();
        drawLine(image);
        return image;
    }

    public String getText() {
        return text;
    }

    public void output(BufferedImage image, OutputStream out) throws IOException {
        ImageIO.write(image, "JPG", out);
    }

}
