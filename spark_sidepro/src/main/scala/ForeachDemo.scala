import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by fqc on 2016/7/20.
  */
object ForeachDemo {

  def main(args: Array[String]) {
//    val conf = new SparkConf().setAppName("ForeachDemo").setMaster("local[3]") //多线程模拟，顺序不可控喽
    val conf = new SparkConf().setAppName("ForeachDemo").setMaster("local")
    val sc: SparkContext = new SparkContext(conf)

    val rdd1 = sc.parallelize(List(1 to 9: _*), 3)
    //println(List(1 to 10: _*))
    //    rdd1.map(println(_)).collect()//map生成新的rdd
    rdd1.foreach(println(_))//foreach action直接操作

    //延展将数值存入数据库
    rdd1.foreach(x=>{
      //jdbc操作  搞个连接池？ 但也不是很好，因为需要频繁的去拿... so how?!!
      //druid 池子  一个分区拿出一个连接， 一个连接对应一个分区的连接
    })

    rdd1.foreachPartition(x=>{//iterator
     /* val conn = Connection.getConn() //该链接针对一个分区的元素的数据库连接操作
      x.map(
        con.save()
      )*/
    })

    sc.stop()

  }

}
