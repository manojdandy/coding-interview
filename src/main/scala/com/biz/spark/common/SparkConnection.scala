package com.biz.spark.common

import org.apache.spark.sql.{SparkSession, SQLContext}

import org.apache.spark.SparkContext
import org.apache.spark.sql.{SQLContext, SparkSession}

object SparkConnection extends Serializable {
  // @transient lazy val spark: SparkSession = SparkSession.builder.master("local[2]").enableHiveSupport().getOrCreate()
  private var _useLocalSession: Boolean = true // Change this value to switch between local and non-local sessions

  def useLocalSession: Boolean = _useLocalSession

  private def useLocalSession_=(value: Boolean): Unit = {
    _useLocalSession = value
  }

  def setLocalSession(isLocal: Boolean): Unit = {
    useLocalSession = isLocal
  }

  @transient lazy val spark: SparkSession = {
    if (useLocalSession) {
      //SparkSession.builder.enableHiveSupport().master("local[2]").getOrCreate()
      SparkSession.builder.master("local[2]")
      //  .config("spark.eventLog.enabled", "true")
        //.config("spark.eventLog.dir", "file:///tmp/spark-events")
        .getOrCreate()
    } else {
      SparkSession.builder.enableHiveSupport().getOrCreate()
    }
  }

  // @transient lazy val spark: SparkSession = SparkSession.builder.enableHiveSupport().getOrCreate()

  @transient lazy val sc: SparkContext = spark.sparkContext
  @transient lazy val sqlContext: SQLContext = spark.sqlContext
  @transient lazy val conf = sc.getConf


  def getSparkConf(key: String): String = conf.get(key)

  def reset: SparkSession = {
    spark
    val _conf = conf
    close
    SparkSession.builder.config(_conf).enableHiveSupport().getOrCreate()
  }

  def close: Unit = spark.stop
}