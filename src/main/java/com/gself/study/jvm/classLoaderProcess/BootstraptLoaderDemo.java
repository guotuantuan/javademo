package com.gself.study.jvm.classLoaderProcess;

import java.net.URL;

/**
 * Created by gtt on 2020/2/23.
 */
public class BootstraptLoaderDemo {
    public static void main(String[] args) {
        System.out.println("*****启动类加载器加载的路径******");
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(URL u:urls){
            System.out.println(u.toExternalForm());
        }
    }
}
