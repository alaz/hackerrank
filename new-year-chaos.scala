/*
https://www.hackerrank.com/challenges/new-year-chaos
*/
object Solution {
  // Binary Index Tree (aka. Fenwick tree), storing how many times `i` occurs.
  // In our task it's always 1 per `i`, but the tree allows fast lookups to
  // determine how many values in a range (i,j] were added.
  case class BITree(n: Int) {
    private val a = new Array[Int](n)
    def add(i: Int): Unit =
      for {x <- Iterator.iterate(i+1) { j => j + (j & -j) }.takeWhile(_ <= n)}
        a(x-1) += 1
    def count(i: Int): Int = ( // (0,i]
      for {x <- Iterator.iterate(i+1) { j => j - (j & -j) }.takeWhile(_ > 0)}
        yield a(x-1)
    ).sum
    def count(l: Int, r: Int): Int = count(r) - count(l) // (l,r]
  }

  def minBribes(n: Int, input: Iterator[Int]): Int = {
    val bit = BITree(n)
    input.zipWithIndex.foldLeft(0) {
      case (acc, (i, index)) if acc < 0 || i-2 > index+1 => -1
      case (acc, (i, index)) =>
        bit.add(i-1)
        acc + bit.count(i-1, n-1)
    }
  }

  def main(args: Array[String]) {
    val scanner = new java.util.Scanner(System.in)
    for {_ <- 0 until scanner.nextInt} {
      val n = scanner.nextInt
      minBribes(n, Iterator.fill(n) { scanner.nextInt }) match {
        case -1 => println("Too chaotic")
        case x => println(x)
      }
    }
  }
}
