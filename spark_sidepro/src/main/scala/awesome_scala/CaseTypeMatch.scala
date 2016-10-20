package awesome_scala

import scala.util.Random


/**
  * Created by fqc on 2016/10/20.
  */
object CaseTypeMatch {
  def main(args: Array[String]) {
    val arr = Array(1, "a", -2.0, 1.0, CaseTypeMatch)
    val idx = Random.nextInt(arr.length)
    val av = arr(idx)
    println(av)
    av match {
      //类型的转换指定，否则统一为Any类型
      case av: Int => println(s"int:$av")
      case av: String => println(s"string:$av")
      case av: Double if (av > 0) => println(s"double:$av")
      case _ => println(throw new Exception("not found exception"))//-2.0 CaseTypeMatch
      /*case Int => println(s"int:$av")
      case String => println(s"string:$av")
      case => println(s"case:$av")
      case av:_ => println(s"case:$av")
      */
    }

  }

  //不仅错误，而且丑陋
  def argly(): Unit = {
    import java.util.Random
    val arr = Array(1, "a", CaseTypeMatch)
    val idx = new Random().nextInt(arr.length)
    val av = arr(idx)
    //val arr1: Any = arr(new Random().nextInt(arr.length))
    println(av)
    av match {
      //opt+tab
      case Int => println(s"int:$av") //由于arr1是Any类型,所以永远都会匹配到该项
      //case String => println(s"string:$av") //object java.lang.String is not a value
      case string => println(s"string:$av")
      case _ => println(s"_:$av") //priv+tab
    }


    val lst = List(1, "a", CaseTypeMatch) //这尼玛也是Any类型的
    val lv = lst(idx)
    lv match {
      case Int => println(s"int:$lv")
      //case String => println(s"string:$lv")编译的时候即使没有直接显示调用也编译不过
      //case String => println(s"string:$lv")//object java.lang.String is not a value
      case CaseTypeMatch => println(s"case:$lv")
    }
  }


}
