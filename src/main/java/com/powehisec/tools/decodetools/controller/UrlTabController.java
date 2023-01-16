package com.powehisec.tools.decodetools.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlTabController {
    @FXML
    private TextArea inputTextArea;
    @FXML
    private TextArea resultTextArea;
    @FXML
    private Button decodeBtn;
    @FXML
    private Button encodeBtn;

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
        try {
            String encode = URLEncoder.encode(str, "utf-8");
            String replace = encode.replace("%3A", ":").replace("%2F", "/")
                    .replace("%3F", "?").replace("%3D", "=").replace("%26", "&");
            return replace;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
