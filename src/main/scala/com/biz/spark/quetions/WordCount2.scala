package com.biz.spark.quetions
import com.biz.spark.common.SparkConnection.spark.implicits._
import org.apache.spark.sql.catalyst.expressions.Sentences

object WordCount2 {
  def main(args: Array[String]): Unit = {
    val words = Seq("hello i am here","hello spark world","hello spark distributed computing").toDF("words")
    val splitWords =  words.flatMap(s => s.getString(0).split("\\s+"))
    val wordCountMap = splitWords.map(word => (word,1))
    splitWords.show(100,false)
    println("****")
    wordCountMap.show()
    println("*******")
    wordCountMap.toDF("word","count").groupBy("word").count().show(100,false)
  }

  def wordCount(sentences: Seq[String]):Map[String,Long] = {
    val df = sentences.toDF()
    val splitWords =  df.flatMap(s => s.getString(0).split("\\s+"))
    val wordCountMap = splitWords.map(word => (word,1))
    val wordCounts = wordCountMap.toDF("word","count").groupBy("word").count()

    wordCounts.as[(String,Long)].collect().toMap
  }
}
