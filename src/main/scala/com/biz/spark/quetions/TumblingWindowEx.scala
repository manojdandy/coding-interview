package com.biz.spark.quetions
import com.biz.spark.common.SparkConnection.spark
import org.apache.spark.sql.functions._
object TumblingWindowEx {
  def main(args: Array[String]): Unit = {
    import spark.implicits._

    // Sample data with timestamp
    val data = Seq(
      ("user1", "2023-07-01 10:00:00", 100),
      ("user1", "2023-07-01 10:15:00", 200),
      ("user1", "2023-07-01 10:45:00", 300),
      ("user1", "2023-07-01 11:10:00", 400),
      ("user2", "2023-07-01 10:20:00", 150),
      ("user2", "2023-07-01 11:00:00", 250),
      ("user2", "2023-07-01 11:30:00", 350)
    )

    val df = data.toDF("user_id", "ts", "amount")
      .withColumn("ts", to_timestamp($"ts"))

    // Tumbling window of 1 hour
    val result = df
      .groupBy(
        window($"ts", "1 hour"), // Tumbling window
        $"user_id"
      )
      .agg(
        count("*").as("transactions"),
        sum("amount").as("total_amount")
      )
      .orderBy("user_id", "window")

    result.show(false)
  }

}
