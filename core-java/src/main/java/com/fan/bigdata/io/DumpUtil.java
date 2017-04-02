package com.fan.bigdata.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by fqc on 3/24/17.
 */
public class DumpUtil {
    public static void dump(String inPath, String outPath) {
        byte[] data = new byte[1024];
        int length;
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(outPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            try (FileInputStream fileInputStream = new FileInputStream(inPath)) {
                while ((length = fileInputStream.read(data)) != -1) {
                    outputStream.write(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
