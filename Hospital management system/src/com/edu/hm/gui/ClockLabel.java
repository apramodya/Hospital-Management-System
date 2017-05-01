package com.edu.hm.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.font.TextAttribute.FONT;
import java.text.*;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

class ClockLabel extends JLabel implements ActionListener {

    String type;
    SimpleDateFormat sdf;

    public ClockLabel(String type) {
        this.type = type;
        setForeground(Color.BLACK);

        switch (type) {
            case "date":
                sdf = new SimpleDateFormat("  MMMM dd yyyy");
                setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
                setHorizontalAlignment(SwingConstants.LEFT);
                break;
            case "time":
                sdf = new SimpleDateFormat("hh:mm a");
                setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
                setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case "day":
                sdf = new SimpleDateFormat("EEEE  ");
                setFont(new Font("Segoe UI Light", 1, 22));
                setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            case "withSeconds":
                sdf=new SimpleDateFormat("HH:mm:ss");
                setFont(new Font("Segoe UI Light",1,18));
                setHorizontalAlignment(SwingConstants.CENTER);
                break;
            default:
                sdf = new SimpleDateFormat();
                break;
        }

        Timer t = new Timer(1000, this);
        t.start();
    }

    public void actionPerformed(ActionEvent ae) {
        Date d = new Date();
        setText(sdf.format(d));
    }

}

