package com.powehisec.tools.decodetools.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MainWindowController {

    @FXML
    private UrlTabController urlTabController;
    @FXML
    private UrlByCharTabController urlByCharTabController;
    @FXML
    private Base64TabController base64TabController;
    @FXML
    private UnicodeTabController unicodeTabController;
    @FXML
    private AsciiTabController asciiTabController;
    @FXML
    private HtmlTabController htmlTabController;
    @FXML
    private JwtTabController jwtTabController;
    @FXML
    private CryptTabController cryptTabController;

    public void initialize() {
        urlTabController.init();
        urlByCharTabController.init();
        base64TabController.init();
        unicodeTabController.init();
        asciiTabController.init();
        htmlTabController.init();
        jwtTabController.init();
        cryptTabController.init();
    }
}
