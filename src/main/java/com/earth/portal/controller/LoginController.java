package com.earth.portal.controller;

import com.earth.portal.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author LiDuanMing
 * @Date 2019/8/13 15:43
 * @Description &#x7528;&#x6237;&#x767b;&#x5f55;
 */
public class LoginController implements Initializable {

    public JFXButton loginBtn;
    public JFXTextField userNameField;
    public JFXPasswordField passwordField;


    private void login(MouseEvent mouseEvent) {
//        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Stage primaryStage = (Stage) loginBtn.getScene().getWindow();
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(getClass().getClassLoader().getResource("login/Spinner.fxml"));
        //关闭原来的
        ((Stage)loginBtn.getScene().getWindow()).close();
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        //Scene类创建场景
        Scene scene = new Scene(root, 600, 500);
        ObservableList<String> stylesheets = scene.getStylesheets();
        stylesheets.addAll(Main.class.getResource("/css/jfoenix-fonts.css").toExternalForm(),
                Main.class.getResource("/css/jfoenix-components.css").toExternalForm(),
                Main.class.getResource("/css/jfoenix-main-demo.css").toExternalForm()
        );
        primaryStage.setTitle("加载中。。。");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(Main::closePlatform);
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginBtn.setOnMouseClicked(this::login);
    }
}
