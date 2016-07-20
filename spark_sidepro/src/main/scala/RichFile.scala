import java.io.File

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

  implicit def file2RichFile(file: File) = new RichFile(file)

  //RichFile 快速增强Java.io.File类
  println(new File("C:\\Users\\fqc\\IdeaProjects\\bigdata\\spark_sidepro\\src\\main\\scala\\SparkWc.scala").read)

}