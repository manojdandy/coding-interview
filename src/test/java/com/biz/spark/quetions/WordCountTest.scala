package com.biz.spark.quetions

import com.holdenkarau.spark.testing.DataFrameSuiteBase
import org.scalatest.funsuite.AnyFunSuiteLike

class WordCountTest extends AnyFunSuiteLike with DataFrameSuiteBase {
  import  spark.implicits._
 test("word count should count word frequency") {
   val input = Seq(
     "hello world",
     "hello spark",
     "hello hello"
   )
   val wordCount = WordCount.wordCount1(input.toDF)
   assert(wordCount("hello") == 4)
 }
}
