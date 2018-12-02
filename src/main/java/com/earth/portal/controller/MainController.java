package com.earth.portal.controller;

import com.earth.portal.enums.LoadComponent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController extends BaseController {


    public Button openDialog;
    public StackPane stackPane;
    public JFXDialog dialog;
    public JFXButton acceptButton;

    @LoadComponent
    public void initButton() {
        acceptButton.setOnAction(e -> {
            dialog.close();
        });
        openDialog.setOnMouseClicked(e -> {
//            dialog.show(stackPane);
            Platform.runLater(() -> {
                Stage stage = new Stage();
                try {
                    Region pane = FXMLLoader.load(getClass().getResource("/view/main/webEngine.fxml"));
                    Scene scene = new Scene(pane);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e1) {e1.printStackTrace();}
            });
        });
    }


}
