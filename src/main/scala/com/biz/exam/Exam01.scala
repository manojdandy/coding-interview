package com.biz.exam
import com.biz.spark.common.SparkConnection.spark.implicits._
import org.apache.spark.sql.functions._
object Exam01 {
  case class Person(name:String,age:Int,upper:Option[String]=None)
  def main(args: Array[String]): Unit = {
    val upperCaseUDF = udf((name:String) => upperCase(name))
      val df = Seq(Person("ram",23),Person("shyam",30),Person("ghanshyam",45)).toDS().
        withColumn("upper",upperCaseUDF($"name")).as[Person]
     df.show()
    println("*********")
    val newdf = df.filter(p => p.age >= 30)
    newdf.show()
  }

  def upperCase(name:String):String = {
    return  name.toUpperCase
  }
}
