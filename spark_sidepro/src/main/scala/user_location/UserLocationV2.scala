package user_location

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by fqc on 2016/7/23.
  */
object UserLocationV2 {
  def main(args: Array[String]) {

    val conf: SparkConf = new SparkConf().setAppName("UserLocationV2").setMaster("local[2]")
    val sc: SparkContext = new SparkContext(conf)

    val rdd1 = sc.textFile("c:/userlocation").map(line => {

      val fileds = line.split(",")

      val mobile = fileds(0)
      val time = fileds(1)
      val location = fileds(2)
      val state = fileds(3)
      var connTime = 0L

      if (state == "1") connTime = -time.toLong else connTime = time.toLong

      ((mobile,location),connTime)

    })

    println("rdd1 = " + rdd1.collect().toBuffer)
  }
}