package com.powehisec.tools.decodetools.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class UrlByCharTabController {
    @FXML
    private TextArea resultTextArea;
    @FXML
    public Button decodeBtn;
    @FXML
    public Button encodeBtn;
    @FXML
    public TextArea inputTextArea;

    public void init() {
        decodeBtn.setOnAction(event -> {
            String input = inputTextArea.getText();
            String result = urlDecode(input);
            if ("".equals(result) && result != null) {
                resultTextArea.setText("Url decode error!");
            } else {
                resultTextArea.setText(result);
            }
        });
        encodeBtn.setOnAction(event -> {
            String input = inputTextArea.getText();
            String result = urlEncode(input);
            if ("".equals(result) && result != null) {
                resultTextArea.setText("Url encode error!");
            } else {
                resultTextArea.setText(result);
            }


        });
    }

    private String urlDecode(String str) {
        try {
            String keyWord = URLDecoder.decode(str, "utf-8");
            return keyWord;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private String urlEncode(String str) {
        if (str.trim().length() == 0 ) {
            return "";
        }
        StringBuffer result = new StringBuffer();
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            String s = Integer.toHexString(c);
            result.append("%"+s);
        }
        return result.toString();
    }
}
