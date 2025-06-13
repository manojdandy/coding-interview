package com.biz.dedup

import java.util.concurrent.ConcurrentHashMap
import scala.collection.mutable
import scala.util.hashing.MurmurHash3

class DeduplicationService {
   val bloomFilter = new BloomFilter(1000000, 0.01) // 1 million events, 1% false positive rate
   val hashTable = new ConcurrentHashMap[String, String]

  def isDuplicate(event: String): Boolean = {
    val hash = MurmurHash3.stringHash(event)
    if (bloomFilter.contains(hash)) {
      hashTable.containsKey(event)
    } else {
      bloomFilter.add(hash)
      false
    }
  }

  def addEvent(event: String): Unit = {
    if (!isDuplicate(event)) {
      hashTable.put(event, event)
    }
  }
}

class BloomFilter(size: Int, errorRate: Double) {
  private val bitArray = new Array[Boolean](size)
  private val hashFunctions = math.ceil(math.log(2) * size / errorRate).toInt

  def add(hash: Int): Unit = {
    (0 until hashFunctions).foreach { i =>
      val index = (hash + i) % size
      bitArray(index) = true
    }
  }

  def contains(hash: Int): Boolean = {
    (0 until hashFunctions).forall { i =>
      val index = (hash + i) % size
      bitArray(index)
    }
  }
}