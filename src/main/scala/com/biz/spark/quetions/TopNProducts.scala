package com.biz.spark.quetions
import com.biz.spark.common.SparkConnection.spark
import com.biz.spark.common.SparkConnection.spark.implicits._
import org.apache.spark.sql.functions._

object TopNProducts {
  def main(args: Array[String]): Unit = {
    // Sample data
    val data = Seq(
      ("A101", 2, 10.0),
      ("B202", 1, 20.0),
      ("A101", 3, 10.0),
      ("C303", 5, 5.0),
      ("B202", 2, 20.0)
    ).toDF("productId","qty","price")

   val augmentedData = data.withColumn("revenue",$"qty" * $"price")
   val productByRevenue =  augmentedData.groupBy("productId").agg(sum("revenue").as("total_revenue")).orderBy($"total_revenue".desc)
    productByRevenue.show(100,truncate = false)
  }
}
