package com.biz.dedup

object DedeupService {
  def main(args: Array[String]): Unit = {
    val items = Map("ram" -> 334,"shyam" -> 456)
    items.foreach({
      case (name,age) => println(f"ram ::${name},age :: ${age}")
    })

    val itemlist = scala.collection.mutable.Map[String,Int]()
    itemlist.put("ram",444)
    println(itemlist)
    val list = scala.collection.mutable.ListBuffer[String]()
    list.append()

    println(deDupEvent("1234")) // uuid
    println(deDupEvent("1234"))
  }

  def test():Unit = {
    import scala.collection.mutable

    val list = mutable.ListBuffer[String]()

    // Add elements using += operator
    list += "Apple"
    list += "Banana"
    list += "Cherry"

    // Add elements using append method
    list.append("Date")
    list.append("Elderberry")

  }
  val eventStores = Map[String,String]()

  def deDupEvent(event:String):Boolean ={

    return  false
  }

  // Expose a service {health},
  // ml will infereincg -> feature1, feature2 ...
  //inferecning_store -> lookup ( -> cache
  // feature store : address standardization
  // address : address1,address2, dpv, lat,long,pixel, ................
  // beert -> gcs  ml/data sc
  // address_id,[]
  // BigQuery Optimization : clustering , functiona (upser_ ->
  // insert update
  //

}
