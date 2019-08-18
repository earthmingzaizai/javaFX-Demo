package com.earth.portal.controller;

import com.earth.portal.enums.LoadComponent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

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
            dialog.show(stackPane);
            /*Platform.runLater(() -> {
                Stage stage = new Stage();
                try {
                    Region pane = FXMLLoader.load(getClass().getResource("/view/main/DrawerTest.fxml"));
                    JFXDecorator jfxDecorator = new JFXDecorator(stage, pane);
                    jfxDecorator.setStyle("-fx-background-color:red");
                    Scene scene = new Scene(jfxDecorator);
                    ObservableList<String> stylesheets = scene.getStylesheets();
                    stylesheets.addAll(this.getClass().getResource("/view/main/jfoenix-main-demo.css").toExternalForm());
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e1) {e1.printStackTrace();}
            });*/
        });
    }


}
