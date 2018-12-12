// https://www.hackerrank.com/challenges/super-digit
//
// http://www.sjsu.edu/faculty/watkins/Digitsum0.htm
//
object Solution {
  def mod9(i: Long) = i % 9 match {
    case 0 => 9
    case x => x
  }

  def sd(s: String) = mod9(s.map(_ - '0').map(_.toLong).sum)

  def main(args: Array[String]) {
    val scanner = new java.util.Scanner(System.in)
    println( mod9(sd(scanner.next) * sd(scanner.next)) )
  }
}
