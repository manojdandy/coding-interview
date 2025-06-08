package com.biz.spark.quetions

import com.biz.spark.common.SparkConnection.spark.implicits._
import com.biz.spark.common.SparkConnection.spark
import org.apache.spark.sql.DataFrame

object WordCount {
  def main(args: Array[String]): Unit = {
    val lines = Seq(
      "Spark is great. Spark is fast!",
      "Scala and Spark, both are functional.",
      "Is this the real life? Is this just fantasy?"
    ).toDF("lines")
    lines.printSchema()
    wordCount1(lines)

  }

  def wordCount1(df: DataFrame): Map[String,Int] = {
    val wordCounts = df
      .rdd
      .flatMap(row => row.getString(0)
        .toLowerCase
        .replaceAll("[^a-zA-Z\\s]", "")
        .split("\\s+"))
      .filter(_.nonEmpty)
      .map(word => (word, 1))
      .reduceByKey(_ + _)
      .sortBy(_._2, ascending = false)
    wordCounts.collect().foreach(println)
    wordCounts.collect().toMap
  }

  def wordCount2(df: DataFrame): Unit = {
    val wordsRDD = df.rdd.flatMap(row => row.getString(0).split(" "))

    // Just print the words to verify
    wordsRDD.collect().foreach(println)
    val wordCountRDD = wordsRDD.map(word => (word, 1))
    val wordCount = wordCountRDD.reduceByKey((a, b) => a + b)
    val sortWordCount = wordCount.sortByKey(ascending = true)
    //wordCount.collect().foreach(println)
    sortWordCount.collect().foreach(println)
  }
}
