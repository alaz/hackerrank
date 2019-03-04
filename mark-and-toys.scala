/*
https://www.hackerrank.com/challenges/mark-and-toys
*/
object Solution {
  def calc(a: Seq[Int], k: Int): Int =
    a.sorted.foldLeft( (0, 0) ) { case ((toys, total), price) =>
      if (total + price > k) {
        return toys
      }
      (toys + 1, total + price)
    }._1

  def main(args: Array[String]) {
    val scanner = new java.util.Scanner(System.in)

    val n = scanner.nextInt
    val k = scanner.nextInt
    val a = Seq.fill(n) { scanner.nextInt }
    System.out.println(calc(a, k))
  }
}
