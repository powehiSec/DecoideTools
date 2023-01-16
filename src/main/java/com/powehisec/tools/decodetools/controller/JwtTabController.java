package com.powehisec.tools.decodetools.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWTCreator;
import com.powehisec.tools.decodetools.utils.Utils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Base64;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JwtTabController {
    @FXML
    private Button encodeBtn;
    @FXML
    private TextArea resultTextArea;
    @FXML
    private Button decodeBtn;
    @FXML
    private TextArea inputTextArea;
    @FXML
    private TextField filePathText;
    @FXML
    private TextField secretText;

    public void init() {
        filePathText.onMouseClickedProperty().set(event -> {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("File", "*");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(null);
            filePathText.setText(file.getPath());
        });
        decodeBtn.setOnAction(event -> {
            String text = inputTextArea.getText();
            String secret = secretText.getText();

            String path = filePathText.getText();
            if (path != "" && path != null && secret.trim().length() == 0) {
                resultTextArea.setText("开始爆破secret...");
                try {
                    String fileContent = Utils.getFileContent(path);
                    String[] split = fileContent.split("\n");
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 0; i < split.length; i++) {
                                try {
                                    String decode = decode(text, split[i]);
                                    if (decode.length() > 0) {
                                        resultTextArea.setText(decode);
                                        secretText.setText(split[i]);
                                        break;
                                    }
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                    };
                    Thread thread=new Thread(runnable);
                    thread.start();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    String decode = decode(text, secret);
                    resultTextArea.setText(decode);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        encodeBtn.setOnAction(event -> {
            String text = inputTextArea.getText();
            String secret = secretText.getText();
            String encode = encode(text, secret);
            resultTextArea.setText(encode);
        });
    }

    private String encode(String text, String secret) {
        if (text.trim().length() == 0) {
            return "";
        }
        JSONObject jsonObject = JSON.parseObject(text);
        if (jsonObject == null) {
            return "";
        }
        JWTCreator.Builder builder = JWT.create();
        jsonObject.forEach((k, v) -> {
            if (k.equals("iat")) {
                // 时间戳转data
                builder.withClaim(k, Long.parseLong(v.toString()));
            } else if (k.equals("exp")) {
                builder.withClaim(k, Long.parseLong(v.toString()));
            } else if (k.equals("nbf")) {
                builder.withClaim(k, Long.parseLong(v.toString()));
            } else {
                builder.withClaim(k, v.toString());
            }
        });
        String token = builder.sign(Algorithm.HMAC256(secret));
        return token;
    }

    public String decode(String input, String secret) throws Exception {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(input);
        String payload = decodedJWT.getPayload();
        return new String(Base64.getDecoder().decode(payload));
    }
}
