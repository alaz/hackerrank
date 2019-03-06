/*
https://www.hackerrank.com/challenges/ctci-merge-sort
*/
object Solution {
  // insertion sort
  // O(n²•log n)
  def calc(d: Int, it: Iterator[Int]) = {
    val a = Array.ofDim[Int](d)

    // binary search on the left side
    // O(log n)
    def bsearch(upper: Int, gt: Int): Int = {
      var (l, r) = (0, upper);
      while (l != r) {
        val m = (l + r) / 2
        if (a(m) <= gt) {
          l = m+1
        } else {
          r = m
        }
      }
      l
    }

    it.zipWithIndex.foldLeft(0L) {
      case (inv, (n, i)) if i == 0 || a(i-1) <= n =>
        a(i) = n
        inv

      case (inv, (n, i)) =>
        val j = bsearch(i - 1, n) //a.indexWhere(_ > n)
        Array.copy(a, j, a, j+1, i-j) // O(n)
        a(j) = n
        inv + i - j
    }
  }

  def main(args: Array[String]) {
    val scanner = new java.util.Scanner(System.in)
    for (_ <- 0 until scanner.nextInt) {
      val d = scanner.nextInt
      val it = Iterator.fill(d) { scanner.nextInt }
      System.out.println(calc(d, it))
    }
  }
}
