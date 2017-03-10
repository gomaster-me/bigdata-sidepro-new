package com.fqc;


import org.junit.Before;
import org.junit.Test;

/**
 * Created by fqc on 3/10/17.
 */
public class HelloLuceneTest {
    HelloLucene test;

    @Before
    public void setUp() throws Exception {
        test = new HelloLucene();
    }

    @Test
    public void testIndexFiles() {
        test.indexFiles("/usr/local/data/indexFiles", "/usr/local/data/example");
    }

    @Test
    public void testSearcher() {
        test.searcher("/usr/local/data/indexFiles");
    }
}