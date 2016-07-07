package com.fan.hadoop.in_action.hdfs_api;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

/**
 * 客户端去操作hdfs时，是有一个用户身份的
 * 默认情况下，hdfs客户端api会从jvm中获取一个参数来作为自己的用户身份：-DHADOOP_USER_NAME=hadoop
 * <p>
 * 也可以在构造客户端fs对象时，通过参数传递进去
 *
 * @author
 */
public class HdfsClientDemo {
    FileSystem fs = null;

    @Before
    public void init() throws Exception {

        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://node01:9000");//如果不设置则默认为本地文件系统 fs.defaultFS=file:///

        //拿到一个文件系统操作的客户端实例对象
        /*fs = FileSystem.get(conf);*/
        //可以直接传入 uri和用户身份
        fs = FileSystem.get(new URI("hdfs://node01:9000"), conf, "hadoop");
    }

    @Test
    public void testUpload() throws Exception {
        //Thread.sleep(500000);
        fs.copyFromLocalFile(new Path("c:/a.txt"), new Path("/mytest/a.txt.copy"));
        fs.close();
    }


    @Test
    public void testDownload() throws Exception {
        fs.copyToLocalFile(new Path("/a.txt.copy"), new Path("d:/"));
        fs.close();
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://node01:9000");
        //拿到一个文件系统操作的客户端实例对象
        FileSystem fs = FileSystem.get(conf);

        fs.copyFromLocalFile(new Path("c:/a.txt"), new Path("/a.txt.copy"));
        fs.close();
    }


}
