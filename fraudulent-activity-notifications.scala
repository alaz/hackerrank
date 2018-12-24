/*
https://www.hackerrank.com/challenges/fraudulent-activity-notifications
*/
object Solution {
  def activityNotifications(expenditure: Array[Int], d: Int): Int = {
    val freq = Array.ofDim[Int](201)
    def inc(delta: Int, i: Int): Unit = { freq(i) = freq(i) + delta }

    val (i1, i2) = if (d % 2 == 1) (d/2, d/2) else (d/2, d/2-1)

    def m_2: Int = {
      val r = freq.tail.scan(freq.head)(_ + _)
      val m1 = r.indexWhere(_ > i1)
      val m2 = r.indexWhere(_ > i2)
      m1 + m2
    }

    expenditure.zipWithIndex.foldLeft(0) {
      case (_, (e, i)) if i < d =>
        inc(+1, e)
        0

      case (result, (e, i)) =>
        val fraud = if (e >= m_2) 1 else 0

        inc(+1, e)
        inc(-1, expenditure(i - d))

        result + fraud
    }
  }

  def main(args: Array[String]) {
    val scanner = new java.util.Scanner(System.in)

    import scanner.{nextInt, nextLong}
    val (n, d) = (nextInt, nextInt)
    println(activityNotifications(Array.fill(n) { nextInt }, d))
  }
}
