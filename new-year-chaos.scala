/*
https://www.hackerrank.com/challenges/new-year-chaos
*/
object Solution {
  // Binary Index Tree (aka. Fenwick tree), storing how many times `>=i` occurs.
  //
  // Most examples of BIT store the SUM of elements for indeces up to `i`.
  // Instead, this implementation is designed to store and query the COUNT of
  // elements for indeces from `i` and above.
  case class BITree(n: Int) {
    private val a = new Array[Int](n)
    def add(i: Int): Unit =
      for {x <- Iterator.iterate(i+1) { j => j - (j & -j) }.takeWhile(_ > 0)}
        a(x-1) += 1
    def count(i: Int): Int = ( // [i,n]
      for {x <- Iterator.iterate(i+1) { j => j + (j & -j) }.takeWhile(_ <= n)}
        yield a(x-1)
    ).sum
  }

  def minBribes(n: Int, input: Iterator[Int]): Int = {
    val bit = BITree(n)
    input.zipWithIndex.foldLeft(0) {
      case (acc, (i, index)) if acc < 0 || i-2 > index+1 => -1
      case (acc, (i, index)) =>
        bit.add(i-1)
        acc + bit.count(i)
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
