/*
https://www.hackerrank.com/challenges/count-triplets-1
*/
object Solution {
  def countTriplets(r: Long, it: Iterator[Long]) = {
    import scala.collection.mutable.Map.empty

    val h2 = empty[Long, Long].withDefaultValue(0L)
    val h3 = empty[Long, Long].withDefaultValue(0L)

    it.foldLeft(0L) { (acc, x) =>
      val inc = h3(x)
      h3(x*r) += h2(x)
      h2(x*r) += 1
      acc + inc
    }
  }

  def main(_args: Array[String]) {
    val scanner = new java.util.Scanner(System.in)
    val (n, r) = (scanner.nextInt, scanner.nextLong)
    println(countTriplets(r, Iterator.fill(n) { scanner.nextLong }))
  }
}
