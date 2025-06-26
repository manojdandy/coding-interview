package com.biz.spark
import com.biz.spark.common.SparkConnection.spark
import com.biz.spark.common.SparkConnection.spark.implicits._
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
object HelloWorld {

  def main(args: Array[String]): Unit = {
    val df = Seq(1,2,3,4).toDF
    //df.show(100,false)

    val df2 = spark.read.json("/Users/manojdandy/IdeaProjects/coding-interview/src/main/resources/nested.json")
    //df2.show(100,false)

    val sales = Seq(("A", "2021-01", 100), ("A", "2021-02", 200), ("B", "2021-01", 300)).toDF("cust", "month", "amount")
    val windowSpec = Window.partitionBy("cust").orderBy("month")
    val result = sales.withColumn("running_total", sum("amount").over(windowSpec))
    result.show()

  }
}
