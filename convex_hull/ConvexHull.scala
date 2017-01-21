/**
  * https://www.hackerrank.com/challenges/convex-hull-fp
  *
  * Convex Hull using Jarvis march (aka. Gift wrapping)
  * Simplified solution, we don't need path, only path length
  */
object Solution {
  import scala.math._
  import scala.annotation._
  import scala.collection.immutable._

  def double(x: Int) = x*x

  val twoPi = 2*Pi

  def normalize(θ: Double) = θ - twoPi*floor( (θ+Pi)/twoPi )

  case class P(x: Int, y: Int) {
    def φ(p: P) = atan2(p.y-y, p.x-x)
    def r(p: P) = sqrt(double(p.y-y) + double(p.x-x))
  }

  def convexHullLength(points: Seq[P]) = {
    val initialP = points.sortBy(_.x).head
    val initialΦ = -Pi/2

    @tailrec
    def jarvisMarch(acc: Double, center: P, φ: Double): Double = {
      val p :: xs = points
        .map { p => p -> normalize(center.φ(p) - φ) }
        .sortBy(_._2)
        .dropWhile(_._2 < 0)
        .map(_._1)
        .filterNot { center.r(_) == 0 }

      if (p == initialP) acc + center.r(p)
      else jarvisMarch(acc + center.r(p), p, center.φ(p))
    }

    jarvisMarch(0, initialP, initialΦ)
  }


  def main(args: Array[String]) {
    val scanner = new java.util.Scanner(System.in)

    System.out.println(
      convexHullLength(
        Seq.fill(scanner.nextInt) { P(scanner.nextInt, scanner.nextInt) }
      ))
  }
}
