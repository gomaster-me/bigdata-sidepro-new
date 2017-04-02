package com.fan.bigdata.io;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by fqc on 3/24/17.
 */
public class TestIO {
    @Test
    public void test01() {
        String inPath = "/Users/fqc/git-work/test/a.txt";
        String outPath = "/Users/fqc/git-work/test/b.txt";
        DumpUtil.dump(inPath, outPath);
        try {
            //if ("HelloWorld".equals(FileUtils.readFileToString(new File(outPath)))) {
            //    System.out.println("ok");
            //}
            Assert.assertEquals("Helloworld", FileUtils.readFileToString(new File(outPath)).trim());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
