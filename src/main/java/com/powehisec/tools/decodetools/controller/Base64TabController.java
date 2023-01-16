package com.powehisec.tools.decodetools.controller;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64TabController {
    public TextArea resultTextArea;
    public Button decodeBtn;
    public Button encodeBtn;
    public TextArea inputTextArea;

    public void init() {
        encodeBtn.setOnAction(event -> {
            String text = inputTextArea.getText();
            String encode = encode(text);
            resultTextArea.setText(encode);
        });
        decodeBtn.setOnAction(event -> {
            String text = inputTextArea.getText();
            String decode = decode(text);
            resultTextArea.setText(decode);
        });
    }

    public String encode(String str) {
        if (str.trim().length() == 0) {
            return "";
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            String result = Base64.getEncoder().encodeToString(bytes);
            return result;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public String decode(String str) {
        if (str.trim().length() == 0) {
            return "";
        }
        byte[] decode = Base64.getDecoder().decode(str);
        String result = new String(decode);
        return result;
    }
}
