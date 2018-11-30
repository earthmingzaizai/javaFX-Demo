package com.earth.portal.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PanelController {

    public JFXDialog dialog;
    public JFXButton acceptButton;
    public StackPane stackPane;
    public AnchorPane parent;

    public void initialize(){
        acceptButton.setOnAction(e -> {
            dialog.close();
            Stage stage = (Stage) parent.getScene().getWindow();
            stage.close();
        });
        dialog.setTransitionType(JFXDialog.DialogTransition.TOP);
        dialog.show(stackPane);
    }


}
