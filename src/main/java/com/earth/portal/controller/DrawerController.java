package com.earth.portal.controller;

import com.earth.portal.enums.LoadComponent;
import com.jfoenix.controls.JFXDrawer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class DrawerController extends BaseController{
    public JFXDrawer drawer;
    @LoadComponent
    public void initSlider() throws Exception {
        StackPane pane = FXMLLoader.load(getClass().getResource("/view/main/Slider.fxml"));
        Node lookup = pane.lookup("#sideList");
        drawer.setSidePane(lookup);
        drawer.open();
    }
}