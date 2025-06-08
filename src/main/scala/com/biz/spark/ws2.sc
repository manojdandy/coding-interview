
import com.biz.spark.common.SparkConnection.spark
import com.biz.spark.common.SparkConnection.spark.implicits._
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

// Define case class for typed Dataset
case class Person(age: Int, name: String)

// Define custom function
def upper_case(s: String): String = s.toUpperCase

val df = Seq((1,"ram"),(2,"shyam")).toDF("age","name")
val ds = df.as[Person]

val ds2 = ds.map(p => {

  Person(p.age,upper_case(p.name))
})
ds2.show()

val ds3 = ds.flatMap(p => {
  List(p,Person(22,"shiva"))
})

ds3.show(100,false)