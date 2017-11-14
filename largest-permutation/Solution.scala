object Solution {
  import scala.annotation.tailrec

  @tailrec
  def calc(l: List[Int], k: Int, p: Vector[Int]): List[Int] = {
    if (k == 0 || p.length == 1) l.reverse ::: p.toList
    else if (p.isEmpty) l.reverse
    else {
      val h = p.head
      val t = p.tail
      val max = t.zipWithIndex.maxBy(_._1)
      if (max._1 > h) calc(max._1 :: l, k-1, t.updated(max._2, h))
      else calc(h :: l, k, t)
    }
  }

  def main(args: Array[String]) {
    val scanner = new java.util.Scanner(System.in)
    val n = scanner.nextInt
    val k = scanner.nextInt
    System.out.println( calc(Nil, k, Vector.fill(n) { scanner.nextInt }).mkString(" ") )
  }
}
