package com.earth.portal.controller;

import com.earth.portal.enums.LoadComponent;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class BaseController {

    public void initialize(){
        Method[] methods = getClass().getDeclaredMethods();
        if(methods == null) {return;}
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            LoadComponent annotation = method.getAnnotation(LoadComponent.class);
            if(annotation == null) {continue;}
            try {method.invoke(this);}
            catch (Exception e) {e.printStackTrace();}
        }
    }

}
