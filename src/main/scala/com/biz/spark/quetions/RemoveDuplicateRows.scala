package com.biz.spark.quetions
import com.biz.spark.common.SparkConnection.spark
import com.biz.spark.common.SparkConnection.spark.implicits._
import org.apache.spark.sql.expressions.Window
import  org.apache.spark.sql.functions._

object RemoveDuplicateRows {
  def main(args: Array[String]): Unit = {
    val userActions = Seq(
      (101, "click", "2025-06-01 10:00:00"),
      (101, "click", "2025-06-01 10:01:00"),
      (102, "view", "2025-06-01 10:02:00"),
      (103, "click", "2025-06-01 10:03:00"),
      (102, "view", "2025-06-01 10:04:00")
    ).toDF("userId","actionType","timestamp")

    val winFun = Window.partitionBy("userId").orderBy($"timestamp".desc)
    val newdf = userActions.withColumn("rn",row_number().over(winFun)).withColumn("dt",to_date($"timestamp")).
      dropDuplicates(Seq("userId","actionType"))
    newdf.show(100,truncate = false)
    //newdf.where("rn=1").show(100,false)
    newdf.printSchema()

  }
}
