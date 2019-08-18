package com.earth.portal.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXNodesList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author LiDuanMing
 * @Date 2019/8/13 17:20
 * @Description TODO
 */
public class LoadingController implements Initializable {
    public StackPane root;
    public JFXNodesList nodesList;
    public JFXDialog dialog;
    public JFXButton acceptButton;


    public void onNewFile(ActionEvent actionEvent) {
        dialog.setTransitionType(JFXDialog.DialogTransition.CENTER);
        dialog.show(root);
        nodesList.animateList(false);
    }

    public void onNewComment(ActionEvent actionEvent) {
        nodesList.animateList(false);
    }

    public void onNewFilter(ActionEvent actionEvent) {
        nodesList.animateList(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acceptButton.setOnMouseReleased(e -> {
            dialog.close();
        });
    }
}
