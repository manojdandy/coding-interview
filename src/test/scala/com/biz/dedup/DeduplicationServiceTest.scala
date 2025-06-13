package com.biz.dedup

import org.scalatest.funsuite.AnyFunSuiteLike
import scala.collection.mutable

class DeduplicationServiceTest extends AnyFunSuiteLike {

  test("addEvent with duplicate events") {
    val service = new DeduplicationService()
    val events = Seq("Event1", "Event2", "Event1", "Event3", "Event2")
    events.foreach(service.addEvent)

    val hashTable = service.hashTable
    assert(hashTable.size == 3) // Only 3 unique events
    assert(hashTable.containsKey("Event1"))
    assert(hashTable.containsKey("Event2"))
    assert(hashTable.containsKey("Event3"))
  }

  test("addEvent with no duplicates") {
    val service = new DeduplicationService
    val events = Seq("Event1", "Event2", "Event3")
    events.foreach(service.addEvent)

    val hashTable = service.hashTable
    assert(hashTable.size == 3) // All events are unique
    assert(hashTable.containsKey("Event1"))
    assert(hashTable.containsKey("Event2"))
    assert(hashTable.containsKey("Event3"))
  }

  test("isDuplicate with duplicate event") {
    val service = new DeduplicationService
    service.addEvent("Event1")

    assert(service.isDuplicate("Event1") == true)
    assert(service.isDuplicate("Event2") == false)
  }

  test("isDuplicate with no duplicates") {
    val service = new DeduplicationService

    assert(service.isDuplicate("Event1") == false)
    assert(service.isDuplicate("Event2") == false)
  }

  test("concurrent addEvent") {
    val service = new DeduplicationService
    val events = Seq("Event1", "Event2", "Event1", "Event3", "Event2")

    // Simulate concurrent adds
    val threads = events.map { event =>
      new Thread(() => service.addEvent(event))
    }
    threads.foreach(_.start())
    threads.foreach(_.join())

    val hashTable = service.hashTable
    assert(hashTable.size == 3) // Only 3 unique events
    assert(hashTable.containsKey("Event1"))
    assert(hashTable.containsKey("Event2"))
    assert(hashTable.containsKey("Event3"))
  }
}