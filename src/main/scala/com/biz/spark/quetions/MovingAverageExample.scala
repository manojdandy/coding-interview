package com.biz.spark.quetions
import com.biz.spark.common.SparkConnection.spark
import com.biz.spark.common.SparkConnection.spark.implicits._
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{avg, round}


object MovingAverageExample {
  def main(args: Array[String]): Unit = {
    // Sample stock data
    val df = Seq(
      ("AAPL", "2024-06-01", 180.0),
      ("AAPL", "2024-06-02", 182.0),
      ("AAPL", "2024-06-03", 185.0),
      ("AAPL", "2024-06-04", 190.0),
      ("AAPL", "2024-06-05", 192.0),
      ("GOOG", "2024-06-01", 2500.0),
      ("GOOG", "2024-06-02", 2520.0),
      ("GOOG", "2024-06-03", 2550.0),
      ("GOOG", "2024-06-04", 2560.0)
    ).toDF("stockId", "date", "price")
    df.show(100,false)

    // Define the Window spec: 3-day moving window
    val movingWindow = Window
      .partitionBy("stockId")
      .orderBy("date")
      .rowsBetween(-2, 0) // current row and 2 previous rows

    // Calculate the 3-day moving average
    val result = df.withColumn("moving_avg", round(avg("price").over(movingWindow), 2))

    // Show result
    result.orderBy("stockId", "date").show()
    println("Sleeping for 1 hour...")
    Thread.sleep(3600000)
    println("Awake now!")
  }
}
