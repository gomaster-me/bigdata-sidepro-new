import java.io.File

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

/**
  * Created by fqc on 2016/7/20.
  */
class RichFile(file: File) {
  /*def read(file: File) = {
    Source.fromFile(file).getLines().mkString
  }*/

  def read = Source.fromFile(file).getLines().mkString("\n")

}

object ImplicitFunction extends App {

  implicit def double2Int(d: Double) = d.toInt

  val a: Int = 3.6

  implicit def file2RichFile(file: File) = new RichFile(file) //定义函数将要增强的类作为参数传入。
  // 当遇到调用read方法但无read方法的时候会启动隐式转换。将File转为RichFile

  //RichFile 快速增强Java.io.File类
  println(new File("C:\\Users\\fqc\\IdeaProjects\\bigdata\\spark_sidepro\\src\\main\\scala\\SparkWc.scala").read)


  //  implicit def double22Int(d: Double) = d.toInt //会有二义性，则不会发生隐式转换   

  def f(x: Int) = println(x)

  f(3.4)

  1 to 10
}
//val arr = ArrayBuffer(1,23)
//arr.sortBy()
//arr.sortWith()
