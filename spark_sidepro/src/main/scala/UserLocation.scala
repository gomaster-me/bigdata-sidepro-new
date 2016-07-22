import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by fqc on 2016/7/22.
  */
object UserLocation {
  def main(args: Array[String]) {

    val conf: SparkConf = new SparkConf().setAppName("UserLocation").setMaster("local[2]")
    val sc: SparkContext = new SparkContext(conf)

//    sc.textFile("c:/1.log)").map(_.split(",")).map(x=>(x(0),x(1),x(2),x(3)))
    val rdd1 = sc.textFile("c:\\userLocation").map(line=> { //一定要记住这里是读取目录,且注意数据源头的格式..很坑的 最好统一为unix系统格式
      val fileds = line.split(",")
      val phoneNo = fileds(0)
      val time = fileds(1)
      val lac = fileds(2)
      val state = fileds(3)
      var  calTime = 0L
      if (state=="1") calTime = -time.toLong else calTime = time.toLong //时间与事件类型需要处理 如果建立连接将设置为负
      (phoneNo + "_" + lac, calTime, state)
    })
    println(rdd1.collect.toBuffer)
  }
}
