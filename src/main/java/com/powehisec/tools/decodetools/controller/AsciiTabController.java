package com.powehisec.tools.decodetools.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class AsciiTabController {
    @FXML
    private TextField decText;
    @FXML
    private TextField hexText;
    @FXML
    private TextArea inputTextArea;
    @FXML
    private Button decodeBtn;
    @FXML
    private Button encodeBtn;

    public void init() {
        encodeBtn.setOnAction(event->{
            String text = inputTextArea.getText();
            Map<String, String> encode = encode(text);
            decText.setText(encode.get("dec"));
            hexText.setText(encode.get("hex"));


        });
        decodeBtn.setOnAction(event->{
            String decStr = decText.getText();
            String hexStr = hexText.getText();
            String decode = decode(decStr, hexStr);
            if (decode != null) {
                inputTextArea.setText(decode);
            } else {
                inputTextArea.setText("输入有误");
            }
        });
        // 文本框鼠标失去焦点事件
        decText.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                hexText.setText("");
            }
        });
        hexText.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                decText.setText("");
            }
        });

    }


    private Map<String, String> encode(String str){
        if(str.trim().length()==0){
            return null;
        }
        StringBuffer sbDec = new StringBuffer();
        StringBuffer sbHex = new StringBuffer();
        Map<String, String> result = new HashMap<>();
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            sbDec.append((int)c+" ");
            sbHex.append("0x"+Integer.toHexString(c)+" ");
        }
        result.put("dec", sbDec.toString());
        result.put("hex", sbHex.toString());
        return result;
    }
    private String decode(String decStr, String hexStr){
        StringBuffer sb = new StringBuffer();
        if (decStr.trim().length() != 0) {
            String[] decArr = decStr.split(" ");
            for (int i = 0; i < decArr.length; i++) {
                sb.append((char) Integer.parseInt(decArr[i]));
            }
            return sb.toString();
        } else if (hexStr.trim().length() != 0) {
            String[] hexArr = hexStr.split(" ");
            for (int i = 0; i < hexArr.length; i++) {
                if (hexArr[i].contains("0x")) {
                    sb.append((char) Integer.parseInt(hexArr[i].substring(2), 16));
                } else {
                    sb.append((char) Integer.parseInt(hexArr[i], 16));
                }
            }
            return sb.toString();
        }

        return null;
    }


}
