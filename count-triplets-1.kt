import java.util.Scanner

fun countTriplets(r: Long, seq: Sequence<Long>): Long {
  val h2 = HashMap<Long, Long>().withDefault { _ -> 0L }
  val h3 = HashMap<Long, Long>().withDefault { _ -> 0L }

  return seq.fold(0L, { acc, x ->
    val inc = h3.getValue(x)
    h3[x*r] = h3.getValue(x*r) + h2.getValue(x)
    h2[x*r] = h2.getValue(x*r) + 1
    acc + inc
  })
}

fun main(_args: Array<String>) {
  val scanner = Scanner(System.`in`)
  val n = scanner.nextInt()
  val r = scanner.nextLong()
  println(countTriplets(r, generateSequence { scanner.nextLong() }.take(n)))
}
