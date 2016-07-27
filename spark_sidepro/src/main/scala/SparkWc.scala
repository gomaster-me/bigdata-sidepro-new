import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.immutable.Range.Inclusive

/**
  * Created by fqc on 2016/7/20.
  */
object SparkWc {
  /* def main(args: Array[String]) {
     val conf: SparkConf = new SparkConf().setAppName("wc")//本地模拟
     val sc: SparkContext = new SparkContext(conf)
     sc.textFile(args(0)).flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _, 1).sortBy(_._2).saveAsTextFile(args(1))
     sc.stop()
   }*/
}

object Test {
  def main(args: Array[String]) {
    val conf: SparkConf = new SparkConf()
    conf.setMaster("spark://node01:7077").setAppName("mytest")//运行在集群
    val sc: SparkContext = new SparkContext(conf)
    //    val rdd1 = sc.parallelize(List(1 to 10)) //一个list整体
    //    val rdd1: RDD[Int] = sc.parallelize(List(1 to 10: _*))
    val rdd1: RDD[Int] = sc.parallelize(1 to 10)
    println(rdd1.count())

  }
}