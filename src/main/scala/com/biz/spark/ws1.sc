/**
 * Filter out even numbers
 * Square the remaining (odd) numbers
 * Return the top 3 largest squared value
 */
val items = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9)
items.filter(_%2 != 0).map(n => n*n).sortWith(_>_).take(3).foreach(println)


items.filter(p=>p%2 == 0).foreach(println)
val sum1 = items.reduce((a,b) => a+b)
val sum2 = items.reduce(_+_)
val minVal = items.reduce(_ min _)
val maxVal = items.reduce((a,b) => {
  if( a > b)
    a
  else b
})
println(s"sum :: ${sum1}")