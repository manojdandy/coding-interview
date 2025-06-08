package com.biz.spark.quetions
import com.biz.spark.common.SparkConnection.spark
import com.biz.spark.common.SparkConnection.spark.implicits._
import org.apache.spark.sql.functions._

/**
 * Joining two DataFrames: users and events
 * Counting events per user
 * Returning users with more than 2 even
 *
 */
object JoinAndAggregate {
  def main(args: Array[String]): Unit = {
    // Users DataFrame
    val users = Seq(
      (1, "Alice"),
      (2, "Bob"),
      (3, "Charlie"),
      (4, "David")
    ).toDF("userId", "name")

    // Events DataFrame
    val events = Seq(
      (101, 1, "click"),
      (102, 1, "purchase"),
      (103, 1, "click"),
      (104, 2, "click"),
      (105, 2, "click"),
      (106, 3, "purchase"),
      (107, 1, "scroll"),
      (108, 3, "click")
    ).toDF("eventId", "userId", "eventType")

    val joinedDF = users.as("a").join(events.as("b"),Seq("userId"))
    val eventsByUsers = joinedDF.groupBy("userId").agg(count("eventId").as("noOfEvents"))
    joinedDF.show(100,false)
    println("********************************************")
    eventsByUsers.show(100,false)

  }
}
