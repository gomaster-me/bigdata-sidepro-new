import java.text.SimpleDateFormat

import org.apache.spark.{SparkConf, SparkContext}
import java.util.{Calendar, Date}

/**
  * updated by fqc on 2016/7/20.
  */
object SparkWc {
  def main(args: Array[String]) {
    val conf: SparkConf = new SparkConf().setAppName("wc").setMaster("local") //本地模拟
    val sc: SparkContext = new SparkContext(conf)
    /*sc.textFile(args(0)).flatMap(_.split(" ")).map((_, 1)).
      reduceByKey(_ + _, 1).sortBy(_._2).saveAsTextFile(args(1))//注意团队写法，这样的尽量少些*/
    //     sc.textFile(args(0)).flatMap(_.split(" ")).map((_, 1)).
    //       reduceByKey(_ + _, 1).sortBy(_._2).map(x=>x._1+"\t"+x._2).saveAsTextFile(args(1))//注意团队写法，这样的尽量少些
    sc.textFile("c:\\wc.txt").flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _, 1).sortBy(_._2).map(x => x._1 + "\t" + x._2).saveAsTextFile("c:\\" + new SimpleDateFormat("yyyyMMdd.HHmm.ss").format(new Date())) //注意团队写法，这样的尽量少些
    sc.stop()
  }
}


object SparkWcS3 {
  def main(args: Array[String]) {
    val conf: SparkConf = new SparkConf().setAppName("wc")
    val sc: SparkContext = new SparkContext(conf)
    /*sc.textFile(args(0)).flatMap(_.split(" ")).map((_, 1)).
      reduceByKey(_ + _, 1).sortBy(_._2).saveAsTextFile(args(1))//注意团队写法，这样的尽量少些*/
    val df = new SimpleDateFormat("yyyyMMdd.HHmm.ss"); //设置日期格式
    println(df.format(new Date())); // new Date()为获取当前系统时间  开发期间，重构换成日志
    sc.textFile("s3://input-bucket/").flatMap(_.split(" ")).map((_, 1)).
      reduceByKey(_ + _, 1).sortBy(_._2).map(x => x._1 + "\t" + x._2).saveAsTextFile("s3://output-bucket/" + new SimpleDateFormat("yyyyMMdd.HHmm.ss").format(new Date())) //注意团队写法，这样的尽量少些
    sc.stop()
  }
}

object Test {
  /*def main(args: Array[String]) {
    val conf: SparkConf = new SparkConf()
    conf.setMaster("spark://node01:7077").setAppName("mytest")//运行在集群
    val sc: SparkContext = new SparkContext(conf)
    //    val rdd1 = sc.parallelize(List(1 to 10)) //一个list整体
    //    val rdd1: RDD[Int] = sc.parallelize(List(1 to 10: _*))
    val rdd1: RDD[Int] = sc.parallelize(1 to 10)
    println(rdd1.count())

  }*/
}