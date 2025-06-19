package com.biz.exam
import  scala.collection.mutable

/**
 * Scenario 1,
 * Input1: [ (2,5), (4,5), (0,1), (3,4), (0,2)]
 * Input2: 5
 * Input3: [2,4,5]
 * Response: Recommendation is invalid
 * Reason: Course 2 can’t be taken without completing the course 0
 *
 * Scenario 2,
 * Input1: [ (2,5), (4,5), (0,1), (3,4), (0,2)]
 * Input2: 5
 * Input3: [3,5,4]
 * Response: Recommendation is valid
 * 3 -> 4 -> 5
 *
 * Scenario 3,
 * Input1: [ (2,5), (4,5), (0,1), (3,4), (0,2)]
 * Input2: 5
 * Input3: [0, 2, 3, 5, 4]
 * Response: Recommendation is valid
 * 0 & 3 -> 2 & 4 -> 5
 */

//class Graph {
//  val adjencyList:List[Int] // outgoing
//  // 5 -> 4
//  // 5 -> 3
//}

object Prac01 {
  def main(args: Array[String]): Unit = {
    // Topological sort
    //
    val graph = mutable.Map[Int,List[Int]]() //List((
    graph.put(2,List(5))
    graph.put(4,List(5))
    graph.put(0,List(1,2))
    graph.put(3,List(4))
   // courses.put(0,2)

    //Graph:

  }

  def precursor(courses:mutable.Map[Int,Int],target:Int,recommendation:List[Int]):Boolean = {
    val visited = mutable.Set[Int]()
    val res = mutable.Stack[Int]()


    //dfs
    def dfs(node:Int):Unit ={
      if(!visited.contains(node)) {
        visited.add(node) // vised += node
        for (preCursor <- graph
            //dfs()

        res.push(node)
      }
    }

    for(node <- graph.keys()) {

    }
    // re -> input
    //
    return  false
  }



}
