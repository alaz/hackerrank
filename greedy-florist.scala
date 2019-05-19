/*
https://www.hackerrank.com/challenges/greedy-florist
*/
object Solution {
  def calc(k: Int, c: Seq[Int]): Int = {
    c.sorted.reverse.grouped(k).zipWithIndex.foldLeft(0) { case (total, (g, i)) =>
      total + g.sum*(i+1)
    }
  }

  def main(args: Array[String]) {
    val scanner = new java.util.Scanner(System.in)

    import scanner.{nextInt, nextLong}
    val (n, k) = (nextInt, nextInt)
    println(calc(k, Seq.fill(n) { nextInt }))
  }
}
