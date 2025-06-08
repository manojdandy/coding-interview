import com.biz.spark.common.SparkConnection.spark
import com.biz.spark.common.SparkConnection.spark.implicits._
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

val textFile = spark.read.textFile("path_to_file.txt")
val wordCounts = textFile.flatMap(_.split(" ")).groupByKey(identity).count()
wordCounts.show()

// 2. Flatten Nested JSON
val nestedDF = spark.read.json("path_to_nested_json.json")
nestedDF.printSchema()
val flatDF = nestedDF.selectExpr("user.id as user_id", "user.name as user_name", "event.timestamp")
flatDF.show()

// 3. Join Operations
val df1 = Seq((1, "A"), (2, "B")).toDF("id", "val1")
val df2 = Seq((1, "X"), (3, "Y")).toDF("id", "val2")
val innerJoin = df1.join(df2, Seq("id"), "inner")
innerJoin.show()

// 4. Window Functions
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

val sales = Seq(("A", "2021-01", 100), ("A", "2021-02", 200), ("B", "2021-01", 300)).toDF("cust", "month", "amount")
val windowSpec = Window.partitionBy("cust").orderBy("month")
val result = sales.withColumn("running_total", sum("amount").over(windowSpec))
result.show()

// 5. Handle Missing Data
val dfWithNulls = Seq((1, "foo"), (2, null)).toDF("id", "value")
dfWithNulls.na.fill("unknown").show()

// 6. Schema Evolution - handled using merge schema in read
val dfNew = spark.read.option("mergeSchema", "true").parquet("path_to_parquet")
dfNew.printSchema()

// 7. Custom UDFs
val toUpperCase = udf((s: String) => if (s != null) s.toUpperCase else "")
dfWithNulls.withColumn("upper_value", toUpperCase($"value")).show()

// 8. Aggregation
df1.groupBy("val1").agg(count("id"), sum("id")).show()

// 9. Error Handling
try {
  val riskyDF = spark.read.json("corrupt_file.json")
  riskyDF.show()
} catch {
  case e: Exception => println(s"Error reading file: ${e.getMessage}")
}

// 10. Optimizations
val bigDF = spark.read.parquet("big_dataset.parquet")
bigDF.repartition(10).cache().filter($"column" > 100).show()

// 11. Immutability
val immutableList = List(1, 2, 3)
val newList = immutableList.map(_ * 2)

// 12. Higher-Order Functions
val numbers = List(1, 2, 3)
val squares = numbers.map(n => n * n)

// 13. Pattern Matching
def describe(x: Any): String = x match {
  case 1 => "One"
  case "hello" => "Greeting"
  case _ => "Something else"
}

// 14. Option and Either
def safeDivide(a: Int, b: Int): Either[String, Int] = {
  if (b == 0) Left("Cannot divide by zero") else Right(a / b)
}

// 15. Currying
def multiply(a: Int)(b: Int) = a * b
val timesTwo = multiply(2)_

// 16. Unit Testing (ScalaTest style)
// class WordCountTest extends FunSuite {
//   test("word count should count correctly") {
//     val words = Seq("apple apple banana").toDS()
//     val result = words.flatMap(_.split(" ")).groupByKey(identity).count().collect()
//     assert(result.toMap("apple") == 2)
//   }
// }

// 17. Refactoring - Extract common logic into functions

// 18. Git Example - Skipped (tool-based)

// 19. CI Example - Skipped (Jenkins, GitHub Actions)

// 20. Documentation - Add comments and scaladocs where needed