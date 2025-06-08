package com.biz.spark.quetions
import com.biz.spark.common.SparkConnection.spark
import com.biz.spark.common.SparkConnection.spark.implicits._
import org.apache.spark.sql.functions.count
object LogFile {
  def main(args: Array[String]): Unit = {
    val df = spark.read.option("delimiter","|").
      option("inferSchema","true").csv("/Users/m0k08nh/intellij_ws2/hands_on/src/main/resources/logfile.txt")
      .toDF("timestamp","loglevel","message")
    df.printSchema()
    df.show(100,false)
    df.groupBy("loglevel").agg(count("*").as("cnt")).orderBy($"cnt".desc).show(100,false)
  }
}
