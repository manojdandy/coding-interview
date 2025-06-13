package com.biz.spark.quetions

import org.scalatest.GivenWhenThen
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.funsuite.AnyFunSuiteLike

class WordCount2Test extends AnyFeatureSpec with GivenWhenThen {

  Feature("word count frequency for given sentences") {
    Scenario("count how many times a word appear") {
      Given("a list of sentences")
      When("the word count function is called")
      Then("it should return correct word count frequencies")
      val map = WordCount2.wordCount(Seq("hello spark", "spark is distributed system"))
      assert(map.getOrElse("spark",0L) == 2L)
    }

  }


}
