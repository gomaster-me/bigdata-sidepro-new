package test

import java.text.SimpleDateFormat
import java.util.Date

/**
  * Created by fqc on 2016/9/29 0029.
  */


object Test {
  def main(args: Array[String]): Unit = {
    //val  dateFormat = new SimpleDateFormat("yyyy-MM-dd")
    //    val time = new Timestamp(dateFormat.parse(new Calendar().toInstant.getLong()).getTime())
    //    print(time)
    //val df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置日期格式
    val df = new SimpleDateFormat("yyyyMMdd.HHmm.ss"); //设置日期格式
    println(df.format(new Date())); // new Date()为获取当前系统时间

  }
}