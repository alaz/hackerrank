/*
https://www.hackerrank.com/challenges/angry-children
*/
object Solution {
  def calc(n: Int, k: Int, seq: Array[Long]): Long = {
    scala.util.Sorting.quickSort(seq)
    (0 until n-k).inclusive.map { i => seq(i+k-1) - seq(i) }.min
  }

  def main(args: Array[String]): Unit = {
    val scanner = new java.util.Scanner(System.in)

    val n = scanner.nextInt
    val k = scanner.nextInt
    val seq = Array.fill(n) { scanner.nextLong }
    System.out.println(calc(n, k, seq))
  }
}
