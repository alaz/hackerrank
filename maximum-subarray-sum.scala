/*
https://www.hackerrank.com/challenges/maximum-subarray-sum

References:
- Kadane algorithm
- https://stackoverflow.com/questions/31113993/maximum-subarray-sum-modulo-m
*/
object Solution {
  import scala.math.max
  import scala.collection.immutable.TreeSet

  def maxSubSumMod(input: Stream[Long], m: Long): Long =
    input.foldLeft( (0L, 0L, TreeSet.empty[Long]) ) { case ((result, prev, set), x) =>
      val cur = (prev + x) % m
      val best = for { greater <- set.range(cur+1, m).headOption } yield (cur - greater + m) % m
      (max(best getOrElse cur, result), cur, set + cur)
    }._1

  def main(args: Array[String]) {
    val scanner = new java.util.Scanner(System.in)
    for {_ <- 0 until scanner.nextInt} {
      val (n, m) = (scanner.nextInt, scanner.nextLong)
      val input = Stream.fill(n)(scanner.nextLong)
      println(maxSubSumMod(input, m))
    }
  }
}
