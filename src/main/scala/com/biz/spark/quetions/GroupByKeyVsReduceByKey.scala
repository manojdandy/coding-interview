package com.biz.spark.quetions
import com.biz.spark.common.SparkConnection.{sc, spark}
import com.biz.spark.common.SparkConnection.spark.implicits._
import org.apache.spark.sql.functions._

object GroupByKeyVsReduceByKey {
  def main(args: Array[String]): Unit = {
    // Sample data: (userId, amount)
    val data = Seq(
      ("u1", 100),
      ("u2", 150),
      ("u1", 200),
      ("u3", 300),
      ("u2", 100),
      ("u3", 50)
    )
    val df = data.toDF("user","income")

    val rdd = sc.parallelize(data)
    rdd.groupByKey().collect()

    val aggUsingReduce = rdd.reduceByKey((a,b) => a+ b).collect().toSeq.toDF()
    aggUsingReduce.show(100,false)
    rdd.reduceByKey((a,b) => a+ b).collect().foreach(println)



  }
}
