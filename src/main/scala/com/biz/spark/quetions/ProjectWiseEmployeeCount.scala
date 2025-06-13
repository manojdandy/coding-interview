package com.biz.spark.quetions

/**
 * Given following PySpark DataFrame:
 *
 * 𝗲𝗺𝗽_𝗶𝗱 | 𝗽𝗿𝗼𝗷𝗲𝗰𝘁𝘀
 * 101   | ["P1","P2"]
 * 102   | ["P1"]
 * 103   | ["P2","P3"]
 *
 * Write PySpark code to get each project and the count of distinct employees working on it.
 *
 * 💡 𝗘𝘅𝗽𝗲𝗰𝘁𝗲𝗱 𝗢𝘂𝘁𝗽𝘂𝘁:
 *
 * 𝗽𝗿𝗼𝗷𝗲𝗰𝘁 | 𝗲𝗺𝗽𝗹𝗼𝘆𝗲𝗲_𝗰𝗼𝘂𝗻𝘁
 * P1     | 2
 * P2    | 2
 * P3     | 1
 *
 * 𝗘𝘅𝗽𝗹𝗮𝗻𝗮𝘁𝗶𝗼𝗻:
 * 1. explode() is used to flatten the array column (projects) so each project gets its own row.
 *
 * 2. groupBy("project") groups data by each project.
 *
 * 3. countDistinct("emp_id") ensures that even if an employee appears multiple times, they are counted only once per project.
 *
 * 𝗖𝗼𝗺𝗺𝗼𝗻 𝗠𝗶𝘀𝘁𝗮𝗸𝗲:
 * Using count() instead of countDistinct() — this can give wrong results if employee IDs are duplicated for any reason.
 * https://www.linkedin.com/posts/shyamala-kashyap_ltimindtree-pyspark-activity-7339147509631471616-j7-i?utm_source=share&utm_medium=member_desktop&rcm=ACoAAANTdC0B5L7FdPiUMotnd03HKA9KrJGzidM
 */
import com.biz.spark.common.SparkConnection.spark
import com.biz.spark.common.SparkConnection.spark.implicits._
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

object ProjectWiseEmployeeCount {
  case class Emp(emp_id:String,projects:List[String])
  def main(args: Array[String]): Unit = {
    val data = Seq(Emp("101",List("p1","p2")),Emp("102",List("p1")),Emp("103",List("p2","p3")))
    val df = spark.createDataset(data)
    val projectWiseEmps = df.withColumn("project_id",explode($"projects")).groupBy("project_id").agg(countDistinct("emp_id").as("emp_count"))
    projectWiseEmps.show(100,false)
    val projectWiseEmpsMap = projectWiseEmps.collect().map(row => {
      (row.getAs[String]("project_id"),row.getAs[Long]("emp_count"))
    }).toMap

    projectWiseEmpsMap
  }

  def projectWiseEmployeeCount(data:Seq[Emp]):Map[String,Long] = {
    val data = Seq(Emp("101",List("p1","p2")),Emp("102",List("p1")),Emp("103",List("p2","p3")))
    val df = spark.createDataset(data)
    val projectWiseEmps = df.withColumn("project_id",explode($"projects")).groupBy("project_id").agg(countDistinct("emp_id").as("emp_count"))
    projectWiseEmps.show(100,false)
    projectWiseEmps.collect().map(p => (p.getString(0),p.getAs[Long](1))).toMap
  }
  def projectWiseEmployee(data:Seq[Emp]):DataFrame = {
    val data = Seq(Emp("101",List("p1","p2")),Emp("102",List("p1")),Emp("103",List("p2","p3")))
    val df = spark.createDataset(data)
    val projectWiseEmps = df.withColumn("project_id",explode($"projects")).groupBy("project_id").agg(countDistinct("emp_id").as("emp_count"))
    projectWiseEmps
  }
}
