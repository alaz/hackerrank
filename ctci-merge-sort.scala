/*
https://www.hackerrank.com/challenges/ctci-merge-sort
*/
object Solution {
  // merge sort
  def calc(a: Array[Int]): Long = mergeSort(a.clone, 0, a.length, a)

  // O(n•log n)
  // [l, r)
  def mergeSort(aux: Array[Int], l: Int, r: Int, result: Array[Int]): Long =
    if (r - l < 2)
      0L
    else {
      val m = (l + r) / 2
      mergeSort(result, l, m, aux) + mergeSort(result, m, r, aux) + merge(aux, l, m, r, result)
    }

  def merge(aux: Array[Int], l: Int, m: Int, r: Int, result: Array[Int]) =
    (l until r).foldLeft((l, m, 0L)) {
      case ((i, j, swaps), k) if i < m && (j >= r || aux(i) <= aux(j)) =>
        result(k) = aux(i)
        (i + 1, j, swaps)

      case ((i, j, swaps), k) =>
        result(k) = aux(j)
        (i, j + 1, swaps + m  - i)
    }._3

  def main(args: Array[String]) {
    val scanner = new java.util.Scanner(System.in)
    for (_ <- 0 until scanner.nextInt) {
      val d = scanner.nextInt
      val a = Array.fill(d) { scanner.nextInt }
      System.out.println(calc(a))
    }
  }
}
