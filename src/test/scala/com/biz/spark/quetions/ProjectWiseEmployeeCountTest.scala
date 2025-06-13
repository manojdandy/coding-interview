package com.biz.spark.quetions

import com.biz.spark.quetions.ProjectWiseEmployeeCount.{Emp, projectWiseEmployee}
import com.holdenkarau.spark.testing.DataFrameSuiteBase
import org.scalatest.funsuite.AnyFunSuiteLike

class ProjectWiseEmployeeCountTest extends AnyFunSuiteLike with  DataFrameSuiteBase {

  test("testProjectWiseEmployee") {
    val data = Seq(Emp("101",List("p1","p2")),Emp("102",List("p1")),Emp("103",List("p2","p3")))
    val projectWiseEmployeeCountMap  = ProjectWiseEmployeeCount.projectWiseEmployeeCount(data)
    assert(projectWiseEmployeeCountMap.getOrElse("p1",0) == 2)
    assert(projectWiseEmployeeCountMap.getOrElse("p2",0) == 2)
    assert(projectWiseEmployeeCountMap.getOrElse("p3",0) == 1)
  }

  test("testProjectWiseEmployeeCount") {
    import spark.implicits._
    val data = Seq(Emp("101",List("p1","p2")),Emp("102",List("p1")),Emp("103",List("p2","p3")))
    val projectWiseEmployeeCountDF  = ProjectWiseEmployeeCount.projectWiseEmployee(data).orderBy($"project_id")
    val resultDF = Seq(("p1",2),("p2",2),("p3",1)).toDF("project_id","emp_count")
    assertDataFrameDataEquals(resultDF, projectWiseEmployeeCountDF)

  }



}
