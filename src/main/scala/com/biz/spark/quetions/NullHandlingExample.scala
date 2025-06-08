package com.biz.spark.quetions
import com.biz.spark.common.SparkConnection.spark
import com.biz.spark.common.SparkConnection.spark.implicits._
import org.apache.spark.sql.functions._

object NullHandlingExample {
  case class User(id: Int, name: String, email: Option[String], age: Option[Int])
  def main(args: Array[String]): Unit = {

    // Sample DataFrame
    val data = Seq(
     User (1, "Alice", Some("alice@example.com"), Some(25)),
      User(2, "Bob", None, Some(30)),
      User(3, "Charlie", Some("charlie@example.com"), None),
      User(4, "David", None, None),
      User(5, "Eve", Some("eve@example.com"), Some(28))
    )

    val df = spark.createDataset(data)

    println("Original Data:")
    df.show()
    println("************************************************")
    val newDF = df.na.drop(Seq("email"))
    newDF.show(100,false)
    println("******")
    val avgAge = df.select(avg("age")).first().getDouble(0)
    println(s"avgAge:: ${avgAge}")
    df.select(avg("age")).show(100,false)
    val fillNa = df.na.fill(Map("age" -> avgAge))
    println("********************************")
    fillNa.show(100,false)
  }
}
