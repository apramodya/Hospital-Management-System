/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.hm.validation;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 * 
 * @author Jinadi
 */
public class ValidationController {

    public static void numbersOnlyTextFiled(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE || evt.getKeyChar() == KeyEvent.VK_DELETE
                || evt.getKeyChar() == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }

    public static void phoneNumber(JTextField textFild) {
        String txt = textFild.getText();
        int caretPosition = textFild.getCaretPosition();
        if (!txt.matches("^[0-9]{0,9}$")) {
            txt = txt.substring(0, caretPosition - 1) + txt.substring(caretPosition);
            textFild.setText(txt);
            textFild.setCaretPosition(caretPosition - 1);
        }

    }

    public static void priceText(JTextField textField) {
        String text = textField.getText();
        if (!text.isEmpty()) {
            boolean res = text.matches("[0-9]+[.]?[0-9]{0,2}");
            if (!res) {
                textField.setText(text.substring(0, text.length() - 1));
            }
        }
    }

    public static void nic(JTextField textField) {
        String text = textField.getText();
        if (!text.isEmpty()) {
            boolean res = text.matches("[0-9]{0,9}[V]{0,1}");
            if (!res) {
                textField.setText(text.substring(0, text.length() - 1));
            }
        }
    }

    public static void name(JTextField textFild) {
        String txt = textFild.getText();
        int caretPosition = textFild.getCaretPosition();
        if (!txt.matches("^[A-Za-z// ]*$")) {
            textFild.setText(txt.substring(0, caretPosition - 1) + txt.substring(caretPosition));
            textFild.setCaretPosition(caretPosition - 1);
        }
    }

    public static void numberOnly(JTextField textFild) {
        String txt = textFild.getText();
        int caretPosition = textFild.getCaretPosition();
        if (!txt.matches("^[1-9]{1,2}$")) {
            textFild.setText(txt.substring(0, caretPosition - 1) + txt.substring(caretPosition));
            textFild.setCaretPosition(caretPosition - 1);
        }

    }
    public static void Email(JTextField textFild,String mail){
         Pattern p = Pattern.compile("[@][a-zA-Z]+[.][a-zA-Z]{1}");
        Matcher m = p.matcher(mail);
        if (m.find()) {
             textFild.setForeground(Color.BLACK);
        } else {
             textFild.setForeground(Color.RED);
             textFild.requestFocus();
        }
    }
}
