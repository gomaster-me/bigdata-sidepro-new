package awesome_scala

import scala.util.Random

/**
  * Created by fqc on 2016/10/20.
  */
object CaseValueMatch {
  def main(args: Array[String]) {
    val arr = Array("张三", "lisi", 1)
    val idx = Random.nextInt(arr.length)
    val av = arr(idx)
    println ("av = " + av)
    av match {
      case "张三"=> println(s"zhangsan:$av")
      case "lisi"=>println(s"lisi:$av")
      case _=>println(s"1:$av")
    }
  }
}
