/*
https://www.hackerrank.com/challenges/magic-square-forming
*/
object Solution {
  val n = 3
  type Matrix = Array[Array[Int]]
  def newSquareMatrix(n: Int): Matrix = Array.ofDim[Int](n, n)

  // https://en.wikipedia.org/wiki/Magic_square#Method_for_constructing_a_magic_square_of_order_3
  def magicSquaresN3(): Seq[Matrix] = {

    def rotate(m: Matrix) = {
      val result = newSquareMatrix(n)
      for {
        i <- 0 until n
        (j, x) <- (0 until n).zip(n-1 to 0 by -1)
      } result(i)(x) = m(j)(i)
      result
    }

    def flip1(m: Matrix) = {
      val result = newSquareMatrix(n)
      for {
        i <- 0 until n
        j <- 0 until n
      } result(j)(i) = m(i)(j)
      result
    }

    def flip2(m: Matrix) = {
      val result = newSquareMatrix(n)
      for {
        i <- 0 until n
        j <- 0 until n
      } result(j)(i) = m(n-i-1)(n-j-1)
      result
    }

    val c = 5
    val initial =
      for {
        a <- 1 until c
        b <- 2 until c-a
        if a < b && b != 2*a
      } yield Array(
        Array(c-b, c+a+b, c-a),
        Array(c-a+b, c, c+a-b),
        Array(c+a, c-a-b, c+b)
      )

    initial.flatMap { square =>
      Iterator.iterate(square, 4)(rotate).flatMap { rotation =>
        Seq(rotation, flip1(rotation), flip2(rotation))
      }
    }
  }

  def diff(m1: Matrix)(m2: Matrix) = {
    var result = 0
    for {
      i <- 0 until n
      j <- 0 until n
    } result += (m1(i)(j) - m2(i)(j)).abs
    result
  }

  def main(args: Array[String]): Unit = {
    val scanner = new java.util.Scanner(System.in)

    val input = Array.fill(n) {
      Array.fill(n) { scanner.nextInt }
    }
    System.out.println(magicSquaresN3().map(diff(input) _).min)
  }

}
