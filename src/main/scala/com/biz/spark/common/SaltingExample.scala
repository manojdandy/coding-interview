package com.biz.spark.common
import org.apache.spark.sql.functions.{expr, col, lit, concat, floor, rand}
import  SparkConnection.spark.implicits._
object SaltingExample {
  def main(args: Array[String]): Unit = {
    // Generate data for cities
   // val cityData = Seq.fill(1000)("Aurangabad") ++ Seq.fill(100)("Mumbai") ++ Seq.fill(10)("Chennai") ++ Seq("Hyderabad")

    val cityData = Seq.fill(2)("Aurangabad") ++ Seq.fill(2)("Mumbai") ++ Seq.fill(2)("Chennai") ++ Seq("Hyderabad")

    // Create DataFrame for cities
    val cityDF = cityData.toDF("city")

    // Add salt to city names
    val saltedCityDF = cityDF.
      withColumn("salt_key", expr("explode(array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19))")).
      withColumn("city_salted", concat(col("city"), lit("_"), col("salt_key")))

    saltedCityDF.show(1000,false)
    println("****************")


    // Generate data for states
    val stateData = Seq(("Aurangabad", "Maharashtra"),
      ("Mumbai", "Maharashtra"),
      ("Chennai", "TamilNadu"),
      ("Hyderabad", "Telangana"))

    // Create DataFrame for states
    val stateDF = stateData.toDF("cityname", "state")

    // Add salt to city names in states
    val saltedStateDF = stateDF.
      withColumn("cityname_salt_key", concat(col("cityname"), lit("_"), floor(rand(123456) * 19)))

    saltedStateDF.show(1000,false)

    // Perform inner join between salted city names and salted city names in states
    val joinedDF = saltedCityDF.join(saltedStateDF, saltedCityDF("city") === saltedStateDF("cityname_salt_key"), "inner")
    joinedDF.explain("formatted")
    // Select the desired columns from the joined DataFrame
    val finalDF = joinedDF.select("cityname", "state")

  }

}
