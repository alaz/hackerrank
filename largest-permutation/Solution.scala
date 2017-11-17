object Solution {
  import scala.annotation.tailrec

  def calc(N: Int, K: Int, stream: Stream[Int]) = {
    val index = Array.fill[Int](N)(-1)

    @tailrec def get(i: Int): Int = {
      val x = index(i)
      if (x == -1) i else get(x)
    }

    def fn(n: Int, k: Int, s: Stream[Int]): Stream[Int] = s match {
      case Stream.Empty => Stream.empty
      case h #:: tail =>
        val value = get(h-1)+1
        if (k == 0)
          value #:: fn(n-1, 0, tail)
        else if (value < n) {
          index(n-1) = h-1
          n #:: fn(n-1, k-1, tail)
        } else
          value #:: fn(n-1, k, tail)
    }

    fn(N, K, stream)
  }


  def main(args: Array[String]) {
    val scanner = new java.util.Scanner(System.in)
    val n = scanner.nextInt
    val k = scanner.nextInt
    val input = Stream.fill(n) { scanner.nextInt }
    System.out.println(calc(n, k, input) mkString " ")
  }
}
