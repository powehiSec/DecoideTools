package com.powehisec.tools.decodetools.controller;

import com.powehisec.tools.decodetools.utils.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CryptTabController {
    @FXML
    private ComboBox typeComBox;
    @FXML
    private TextArea resultTextArea;
    @FXML
    private TextField keyText;
    @FXML
    private TextField ivText;
    @FXML
    private ComboBox modelComBox;
    @FXML
    private Button decodeBtn;
    @FXML
    private Button encodeBtn;
    @FXML
    private TextArea inputTextArea;

    public void init() {
        ObservableList<String> modelList = FXCollections.observableArrayList("CBC", "CFB", "OFB", "CTR", "ECB");
        ObservableList<String> typeList = FXCollections.observableArrayList("AES", "DES");
        modelComBox.setItems(modelList);
        modelComBox.getSelectionModel().select(0);
        typeComBox.setItems(typeList);
        typeComBox.getSelectionModel().select(0);
        decodeBtn.setOnAction(event -> {

        });
        encodeBtn.setOnAction(event -> {
            String model = modelComBox.getSelectionModel().getSelectedItem().toString();
            String type = typeComBox.getSelectionModel().getSelectedItem().toString();
            String key = keyText.getText();
            String iv = ivText.getText();
            if ("AES".equals(type)) {
                if ("CBC".equals(model)) {
                    resultTextArea.setText(Utils.encryptCBC(inputTextArea.getText(), key, iv));
                } else if ("CFB".equals(model)) {
                    resultTextArea.setText(Utils.encryptCFB(inputTextArea.getText(), key, iv));
                } else if ("OFB".equals(model)) {
                    resultTextArea.setText(Utils.encryptOFB(inputTextArea.getText(), key, iv));
                } else if ("CTR".equals(model)) {
                    resultTextArea.setText(Utils.encryptCTR(inputTextArea.getText(), key, iv));
                } else if ("ECB".equals(model)) {
                    resultTextArea.setText(Utils.encryptECB(inputTextArea.getText(), key));
                }
            } else if ("DES".equals(type)) {
                if ("CBC".equals(model)) {
                    resultTextArea.setText(Utils.encryptDesCBC(inputTextArea.getText(), key, iv));
                } else if ("CFB".equals(model)) {
                    resultTextArea.setText(Utils.encryptDesCFB(inputTextArea.getText(), key, iv));
                } else if ("OFB".equals(model)) {
                    resultTextArea.setText(Utils.encryptDesOFB(inputTextArea.getText(), key, iv));
                } else if ("CTR".equals(model)) {
                    resultTextArea.setText(Utils.encryptDesCTR(inputTextArea.getText(), key, iv));
                } else if ("ECB".equals(model)) {
                    resultTextArea.setText(Utils.encryptDesECB(inputTextArea.getText(), key));
                }
            }
        });

        decodeBtn.setOnAction(event -> {
            String model = modelComBox.getSelectionModel().getSelectedItem().toString();
            String type = typeComBox.getSelectionModel().getSelectedItem().toString();
            String key = keyText.getText();
            String iv = ivText.getText();
            if("AES".equals(type)) {
                if("CBC".equals(model)) {
                    resultTextArea.setText(Utils.decryptCBC(inputTextArea.getText(), key, iv));
                } else if("CFB".equals(model)) {
                    resultTextArea.setText(Utils.decryptCFB(inputTextArea.getText(), key, iv));
                } else if("OFB".equals(model)) {
                    resultTextArea.setText(Utils.decryptOFB(inputTextArea.getText(), key, iv));
                } else if("CTR".equals(model)) {
                    resultTextArea.setText(Utils.decryptCTR(inputTextArea.getText(), key, iv));
                } else if("ECB".equals(model)) {
                    resultTextArea.setText(Utils.decryptECB(inputTextArea.getText(), key));
                }
            } else if("DES".equals(type)) {
                if("CBC".equals(model)) {
                    resultTextArea.setText(Utils.decryptDesCBC(inputTextArea.getText(), key, iv));
                } else if("CFB".equals(model)) {
                    resultTextArea.setText(Utils.decryptDesCFB(inputTextArea.getText(), key, iv));
                } else if("OFB".equals(model)) {
                    resultTextArea.setText(Utils.decryptDesOFB(inputTextArea.getText(), key, iv));
                } else if("CTR".equals(model)) {
                    resultTextArea.setText(Utils.decryptDesCTR(inputTextArea.getText(), key, iv));
                } else if("ECB".equals(model)) {
                    resultTextArea.setText(Utils.decryptDesECB(inputTextArea.getText(), key));
                }
            }
        });
    }
}
