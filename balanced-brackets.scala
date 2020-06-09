/*
https://www.hackerrank.com/challenges/balanced-brackets/
*/
object Solution {
  def expected(c: Char): Char = c match {
    case '(' => ')'
    case '[' => ']'
    case '{' => '}'
  }

  def isBalanced(s: String): String = {
    val stack = s.toSeq.foldLeft(List.empty[Char]) {
      case (stack, c @ ('[' | '{' | '(')) =>
        expected(c) :: stack
      case (expect :: rest, c) if c == expect =>
        rest
      case (_, ']' | '}' | ')') =>
        return "NO"
    }
    if (stack.isEmpty)
      "YES"
    else
      "NO"
  }

  def main(_args: Array[String]) {
    val scanner = new java.util.Scanner(System.in)
    for (_ <- 0 until scanner.nextInt)
      println(isBalanced(scanner.next))
  }
}
