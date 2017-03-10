package com.fqc;


import org.junit.Test;

/**
 * Created by fqc on 3/10/17.
 */
public class HelloLuceneTest {
    @Test
    public void testIndexFiles() {
        HelloLucene test = new HelloLucene();
        test.indexFiles("/usr/local/data/indexFiles", "/usr/local/data/example");
    }
}