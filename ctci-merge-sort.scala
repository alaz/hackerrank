/*
https://www.hackerrank.com/challenges/ctci-merge-sort
*/
import scala.collection.immutable.TreeMap

object Solution {
  def calc(it: Iterator[Int]) =
    it.foldLeft((0, TreeMap.empty[Int,Int])) { case ((inv, m), n) =>
      (inv + m.from(n+1).values.sum, m.updated(n, m.getOrElse(n, 0) + 1))
    }._1

  def main(args: Array[String]) {
    val scanner = new java.util.Scanner(System.in)
    for (_ <- 0 until scanner.nextInt) {
      val it = Iterator.fill(scanner.nextInt) { scanner.nextInt }
      System.out.println(calc(it))
    }
  }
}
