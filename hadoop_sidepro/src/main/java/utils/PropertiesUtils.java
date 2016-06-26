package utils;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * Created by fqc on 2016/6/23.
 */

public class PropertiesUtils {
    @Test
    public void writeProperties() {
        Properties properties = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("config.properties");
            properties.setProperty("url", "jdbc:mysql://localhost:3306/");
            properties.setProperty("username", "root");
            properties.setProperty("password", "******");
            properties.setProperty("database", "bbs");//保存键值对到内存
            properties.store(output, "fqc modify" + new Date().toString());// 保存键值对到文件中
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void loadProperties() {
        Properties properties = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("src/main/resources/config.properties");//加载Java项目根路径下的配置文件
            properties.load(input);// 加载属性文件
            System.out.println("url:" + properties.getProperty("url"));
            System.out.println("username:" + properties.getProperty("username"));
            System.out.println("password:" + properties.getProperty("password"));
            System.out.println("database:" + properties.getProperty("database"));
        } catch (IOException io) {
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static String[] readFilePaths() {
        Properties properties = new Properties();
        InputStream input = null;
        String inputPath = "";
        String outputPath = "";
        try {
            input = new FileInputStream("src/main/resources/config.properties");//加载Java项目根路径下的配置文件
            properties.load(input);// 加载属性文件
            System.out.println("input:" + properties.getProperty("input"));
            System.out.println("output:" + properties.getProperty("output"));

            inputPath = properties.getProperty("input");
            outputPath = properties.getProperty("output");

        } catch (IOException io) {
            io.printStackTrace();

        } finally {
            if (input != null) {
                try {
                    input.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new String[]{inputPath, outputPath};
    }



    @Test
    public void printAll() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            String filename = "config.properties";
            input = getClass().getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                return;
            }
            prop.load(input);
            //方法一：
            Set<Object> keys = prop.keySet();//返回属性key的集合
            for (Object key : keys) {
                System.out.println("key:" + key.toString() + ",value:" + prop.get(key));
            }
            //方法二：
            Set<Map.Entry<Object, Object>> entrys = prop.entrySet();//返回的属性键值对实体
            for (Map.Entry<Object, Object> entry : entrys) {
                System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
            }
            //方法三：
            Enumeration<?> e = prop.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = prop.getProperty(key);
                System.out.println("Key:" + key + ",Value:" + value);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
