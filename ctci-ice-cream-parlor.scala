/*
https://www.hackerrank.com/challenges/ctci-ice-cream-parlor
*/
object Solution {
  import java.util.Scanner
  import scala.collection.immutable.TreeMap

  def solve(scanner: Scanner): Seq[Int] = {
    val money = scanner.nextLong
    val costs = Iterator.fill(scanner.nextInt) { scanner.nextLong }

    def z = TreeMap.empty[Long, Int]
    val (l, r) = costs.zipWithIndex.foldLeft((z, z)) { case ((l, r), (cost, i)) =>
      val index = i + 1
      if (cost <= money/2 && !l.contains(cost))
        (l + (cost -> index), r)
      else if (cost >= money - money/2 && !r.contains(cost))
        (l, r + (cost -> index))
      else
        (l, r)
    }

    val pairs = for {
      (c1, i1) <- l
      i2 <- r.get(money - c1)
    } yield
      Seq(i1, i2).sorted

    pairs.head
  }

  def main(args: Array[String]): Unit = {
    val scanner = new Scanner(System.in)
    for {_ <- 0 until scanner.nextInt} {
      val result = solve(scanner)
      System.out.println(result mkString " ")
    }
  }
}
