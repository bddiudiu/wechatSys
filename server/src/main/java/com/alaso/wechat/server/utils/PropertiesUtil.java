package com.alaso.wechat.server.utils;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by adam on 26/4/16.
 */
public class PropertiesUtil {

    /**
     * 加载配置文件
     * @param path
     * @return
     */
    public static Properties load(String path){
        ClassLoader cls = PropertiesUtil.class.getClassLoader();
        URL url = cls.getResource(path);
        Properties  prop = new Properties() ;
        try {
            prop.load(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    /**
     * 加载配置文件
     * @param key
     * @return
     */
    public static String getProperties(String key){
        Properties prop = load("wechat.properties");
        String value = prop.getProperty(key);
        return value;
    }

}
