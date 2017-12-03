// https://www.hackerrank.com/challenges/find-the-median/problem
// Quickselect algorithm by T.Hoare

object Solution {
  import scala.annotation.tailrec
  import scala.util.Random

  val rnd = new Random
  def pivot(seq: Seq[Int]): Int = seq(rnd.nextInt(seq.length))

  @tailrec def median(seq: Seq[Int], n: Int): Int = {
    require(n >= 0 && n < seq.length)

    val p = pivot(seq)
    val (l,r) = seq.foldLeft(Vector.empty[Int] -> Vector.empty[Int]) { (ll, x) =>
      if (x < p) (ll._1 :+ x) -> ll._2
      else if (x > p) ll._1 -> (ll._2 :+ x)
      else ll
    }

    if (l.length until (seq.length-r.length) contains n) p
    else if (n < l.length) median(l, n)
    else median(r, n-seq.length+r.length)
  }

  def median(seq: Seq[Int]): Int = median(seq, seq.length / 2)

  def main(args: Array[String]) {
    val scanner = new java.util.Scanner(System.in)
    System.out.println(median(Seq.fill(scanner.nextInt) { scanner.nextInt }))
  }
}
