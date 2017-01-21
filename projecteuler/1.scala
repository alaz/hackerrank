object Solution {
  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    0 until sc.nextInt foreach { _ =>
      println(euler1(sc.nextLong))
    }
  }

  def euler1(n: Long) = {
    val n3: Long = (n-1)/3
    val n5: Long = (n-1)/5
    val n15: Long = (n-1)/15
    n3*(n3+1)/2*3 + n5*(n5+1)/2*5 - n15*(n15+1)/2*15
  }
}
