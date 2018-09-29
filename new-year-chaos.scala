/*
https://www.hackerrank.com/challenges/new-year-chaos
*/
object Solution {
  import scala.collection.immutable.TreeSet

  // naïve
  def minBribes(input: Iterator[Int]): Int =
    input.zipWithIndex.foldLeft(0 -> TreeSet.empty[Int]) { case ((acc, buf), (i, index)) =>
      if (acc < 0 || i-2 > index+1) -1 -> buf
      else (acc + buf.from(i+1).size) -> (buf + i)
    }._1

  def main(args: Array[String]) {
    val scanner = new java.util.Scanner(System.in)
    for {_ <- 0 until scanner.nextInt}
      minBribes(Iterator.fill(scanner.nextInt) { scanner.nextInt }) match {
        case -1 => println("Too chaotic")
        case x => println(x)
      }
  }
}
