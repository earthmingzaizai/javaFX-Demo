package com.earth.portal.controller;

import com.earth.portal.enums.LoadComponent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class MainController extends BaseController{


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
            dialog.show(stackPane);
        });
    }


}
