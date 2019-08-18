package com.earth.portal.controller;

import com.earth.portal.enums.LoadComponent;
import javafx.application.Platform;
import javafx.scene.web.WebView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class EngineController extends BaseController{

    public WebView webView;

    @LoadComponent
    public void initEngine() throws Exception {
        webView.getEngine().setJavaScriptEnabled(true);
        webView.getEngine().setOnAlert(e -> System.out.println(e.getData()));
        Platform.runLater(this::loadEngine);
    }

    private void loadEngine() {
        File htmlDir = null;
        try {
            htmlDir = getJarDirectory("webEngineSource", "res");
        } catch (Exception e) {e.printStackTrace();}
        //加载本地html必须要有file:\\前缀
        webView.getEngine().load(new File(htmlDir, "htmlView/index.html").toURI().toString());
    }

    /**
     * 获取jar中文件夹
     * @throws Exception
     */
    private File getJarDirectory(String sourcePath, String desPath) throws Exception {
        String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        if(new File(path).isDirectory()) {
            return new File(getClass().getResource("/" + sourcePath).toURI());
        }
        JarFile localJarFile = new JarFile(new File(path));
        File res = new File(new File(path).getParentFile(), desPath);
        if(res.exists()) {
            return res;
        }
        res.mkdirs();
        Enumeration<JarEntry> entries = localJarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry jarEntry = entries.nextElement();
            String innerPath = jarEntry.getName();
            if(innerPath.startsWith(sourcePath)){
                if(jarEntry.isDirectory()) {
                    new File(res, innerPath).mkdirs();
                    continue;
                }
                try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(innerPath);FileOutputStream outputStream = new FileOutputStream(new File(res, innerPath))) {
                    byte[] datas = new byte[1024 * 10];
                    int len = 0;
                    while ((len = inputStream.read(datas)) > -1) {
                        outputStream.write(datas, 0, len);
                    }
                }
            }
        }
        return new File(res, sourcePath);
    }
}