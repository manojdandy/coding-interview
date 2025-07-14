package com.lendingclub
import com.biz.spark.common.SparkConnection.spark
object CrunchingData {
  import spark.implicits._
  def main(args: Array[String]): Unit = {
    val df = spark.read.
      option("header",true).option("inferSchema",true).
      csv("/Users/manojbeniwal/projects/datasets/accepted_2007_to_2018Q4.csv.gz")
    df.show(10,false)

  }

}
