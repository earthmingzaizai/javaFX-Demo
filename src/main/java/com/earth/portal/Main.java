package com.earth.portal;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

/**
 * <h1>主启动类</h1>
 * <p>JavaFx启动一个界面需要一个舞台Stage，有<strong>Stage</strong>之后需要在Stage上搭建场景<strong>Scene</strong>
 * </p>
 * @date 2019年8月13日
 * @author 李端明
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //Stage类创建舞台
        FXMLLoader loader = new FXMLLoader();
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(getClass().getClassLoader().getResource("login/login.fxml"));
        Parent root = loader.load();
        //Scene类创建场景
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("FXML Welcome");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(Main::closePlatform);
        primaryStage.show();
    }

    public static void closePlatform(WindowEvent e) {
        Platform.exit();
    }
}