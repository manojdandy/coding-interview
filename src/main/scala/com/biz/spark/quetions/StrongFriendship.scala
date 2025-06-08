package com.biz.spark.quetions
import com.biz.spark.common.SparkConnection.spark
import com.biz.spark.common.SparkConnection.spark.implicits._

/**
 * Each row of this table indicates that the users user1_id and user2_id are friends. Note that user1_id < user2_id.
 * A friendship between a pair of friends x and y is strong if x and y have at least three common friends.
 * Write a query to find all the strong friendship.
 * Note that the result table should not contain duplicates with user1_id < user2_id(To have the friendship user1_id<user2_id)
 *
 */
object StrongFriendship {
  case class Person(user1:String,user2:String)
  def main(args: Array[String]): Unit = {
    val data = Seq(
      Person("1","2"),Person("1","3"),Person("2","3"),
      Person("1","4"),Person("2","4"),Person("1","5"),Person("2","5"),
      Person("1","7"),Person("3","7"),Person("1","6"),Person("3","6"),
      Person("2","6"))
    val df1 = data.toDF()
    df1.show(100,false)
    println("**********************************")
    val df2 = df1.select($"user2".as("user1"),$"user1".as("user2"))
    df2.show()
   // results should not have duplicates (user1 < user2) and at least have three common friends
    val allDF = df1.union(df2)
    val total_connections = allDF.count()
    println(s"total_connections :: ${total_connections}")
    val allDF2 = allDF.select($"user1".as("user1_1"),$"user2".as("user2_2"))
    val resultDF = allDF.as("a").join(allDF2.as("b"),$"a.user2" === $"b.user2_2").where($"a.user1" < $"b.user1_1")
    println("----------------")
    resultDF.show(100,false)
    val resultDF1 = resultDF.groupBy("user1","user1_1").count().where("count >= 3")
    println("----------------")
    resultDF1.show()

  }

}
