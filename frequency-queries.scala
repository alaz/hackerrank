// https://www.hackerrank.com/challenges/frequency-queries
object Solution {
  def freqs(q: Int, it: Iterator[(Int,Long)]): Iterator[Int] = {
    val counts = scala.collection.mutable.HashMap.empty[Long, Int].withDefaultValue(0)
    val freq = new Array[Int](q+1)

    it.zipWithIndex.map {
      case ((1, i), _) =>
        val c1 = counts(i)
        freq(c1) = freq(c1) - 1
        val c2 = c1 + 1
        counts.update(i, c2)
        freq(c2) = freq(c2) + 1
        None

      case ((2, i), _) =>
        val c1 = counts(i)
        if (c1 > 0) {
          freq(c1) = freq(c1) - 1
          val c2 = c1 - 1
          counts.update(i, c2)
          freq(c2) = freq(c2) + 1
        }
        None

      case ((3, i), idx) if i > idx =>
        Some(0)
      case ((3, i), _) if freq(i.toInt) > 0 =>
        Some(1)
      case ((3, i), _) =>
        Some(0)
    }.flatten
  }

  def main(args: Array[String]) {
    val scanner = new java.util.Scanner(System.in)

    import scanner.{nextInt, nextLong}
    val q = nextInt
    freqs(q, Iterator.fill(q) { nextInt -> nextLong }).foreach { println }
  }
}
