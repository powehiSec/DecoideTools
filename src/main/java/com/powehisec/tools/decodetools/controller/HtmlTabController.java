package com.powehisec.tools.decodetools.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import org.apache.commons.text.StringEscapeUtils;

import java.util.HashMap;
import java.util.Map;

public class HtmlTabController {
    @FXML
    private TextArea resultTextArea;
    @FXML
    private Button decodeBtn;
    @FXML
    private Button encodeBtn;
    @FXML
    private TextArea inputTextArea;

    public void init() {
        encodeBtn.setOnAction(event -> {
            String text = inputTextArea.getText();
            StringBuffer sb = new StringBuffer();
            Map<String, String> encode = encode(text);
             sb.append("一般html:\t").append(encode.get("html4")).append("\n\n十进制html:\t").append(encode.get("decHtml"))
                    .append("\n\n十六进制html:\t").append(encode.get("hexHtml"));
            resultTextArea.setText(sb.toString());
        });
        decodeBtn.setOnAction(event -> {
            String text = inputTextArea.getText();
            String decode = decode(text);
            resultTextArea.setText(decode);
        });
    }

    private Map<String,String> encode(String str) {
        if (str.trim().length() == 0) {
            return null;
        }
        String html4 = StringEscapeUtils.escapeHtml4(str);
        StringBuffer sbDecHtml = new StringBuffer();
        StringBuffer sbHexHtml = new StringBuffer();
        Map<String, String> result = new HashMap<>();
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            sbDecHtml.append("&#"+(int)c+";");
            sbHexHtml.append("&#x"+Integer.toHexString(c)+";");
        }
        result.put("html4", html4);
        result.put("decHtml", sbDecHtml.toString());
        result.put("hexHtml", sbHexHtml.toString());
        return result;
    }

    private String decode(String str) {
        if (str.trim().length() == 0) {
            return null;
        }
        return StringEscapeUtils.unescapeHtml4(str);
    }
}
