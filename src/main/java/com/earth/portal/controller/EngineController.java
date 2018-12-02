package com.earth.portal.controller;

import com.earth.portal.enums.LoadComponent;
import javafx.scene.web.WebView;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.util.Enumeration;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class EngineController extends BaseController{

    public WebView webView;

    @LoadComponent
    public void initEngine() throws Exception {
        webView.getEngine().setJavaScriptEnabled(true);
        webView.getEngine().setOnAlert(e -> {
            System.out.println(e.getData());
        });
        getJarDirectory("htmlView", "res");
        URL resource = getClass().getResource("/");
        //createResDir(resource.toURI(), "res");
        webView.getEngine().load(getClass().getResource("/htmlView/index.html").toString());
    }

    /**
     * 初始化
     * @param des
     * @param res
     * @throws Exception
     */
    private void createResDir(URI des, String res) throws Exception {
        File dir = new File(new File(des).getParentFile().getAbsolutePath());
        LinkedBlockingQueue<File> queue = new LinkedBlockingQueue<File>(){@Override public void put(File file) throws InterruptedException {super.put(file);System.out.println(file);}};
        if(!dir.exists()){
            dir.mkdirs();
        }
        queue.put(dir);
        while (queue.size() > 0) {
            File file = queue.poll();
            if(file.isDirectory()) {
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    File child = files[i];
                    queue.put(child);
                }
            }
        }
    }

    /**
     * 获取jar中文件夹
     * @throws Exception
     */
    private void getJarDirectory(String sourcePath, String desPath) throws Exception {
        String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        JarFile localJarFile = new JarFile(new File(path));
        File res = new File(new File(path).getParentFile(), desPath);
        boolean a = res.exists() ? false : res.mkdirs();
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
    }
}