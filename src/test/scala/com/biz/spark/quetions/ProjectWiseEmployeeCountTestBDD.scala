package com.biz.spark.quetions

import com.biz.spark.quetions.ProjectWiseEmployeeCount.Emp
import org.scalatest.GivenWhenThen
import org.scalatest.featurespec.AnyFeatureSpec

class ProjectWiseEmployeeCountTestBDD extends AnyFeatureSpec with GivenWhenThen {
  Feature("Project-wise employee count") {
    Scenario("Count distinct employees working on each project") {

      Given("a list of employees with the projects they are working on")
      val data = Seq(
        Emp("101", List("p1", "p2")),
        Emp("102", List("p1")),
        Emp("103", List("p2", "p3"))
      )

      When("the system processes this data to compute project-wise employee count")
      val projectWiseEmployeeCountMap = ProjectWiseEmployeeCount.projectWiseEmployeeCount(data)

      Then("the correct number of distinct employees should be returned for each project")
      assert(projectWiseEmployeeCountMap.getOrElse("p1", 0) == 2)
      assert(projectWiseEmployeeCountMap.getOrElse("p2", 0) == 2)
      assert(projectWiseEmployeeCountMap.getOrElse("p3", 0) == 1)
    }

  }

}
