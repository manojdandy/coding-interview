package com.biz.spark.quetions
import com.biz.spark.common.SparkConnection.spark
import com.biz.spark.common.SparkConnection.spark.implicits._
import org.apache.spark.sql.functions._

object CaseClassTransformation {
   case class Person(name: String, age: Int)

  def main(args: Array[String]): Unit = {

    val people = List(Person("John", 28), Person("Jane", 32))
    val ds = spark.createDataset(people)
    ds.printSchema()
    val result:Map[String,Int] = ds.filter(p => p.age > 30).map(p => (p.name,p.age)).collect().toMap
    result.foreach({
      case (name,age) => println(s"name : ${name}, age :: ${age}")
    })

  }
}
