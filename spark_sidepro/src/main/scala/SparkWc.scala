import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by fqc on 2016/7/20.
  */
object SparkWc {
  def main(args: Array[String]) {
    val conf: SparkConf = new SparkConf().setAppName("wc")
    val sc: SparkContext = new SparkContext(conf)
    sc.textFile(args(0)).flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _, 1).sortBy(_._2).saveAsTextFile(args(1))
    sc.stop()
  }
}
