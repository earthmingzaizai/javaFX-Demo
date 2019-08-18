package com.earth.portal.controller;

import com.earth.portal.enums.LoadComponent;

import java.lang.reflect.Method;

public class BaseController {

    public void initialize(){
        Method[] methods = getClass().getDeclaredMethods();
        for (Method method : methods) {
            LoadComponent annotation = method.getAnnotation(LoadComponent.class);
            if (annotation == null) {
                continue;
            }
            try {
                method.invoke(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
