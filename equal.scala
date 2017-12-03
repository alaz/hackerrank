// https://www.hackerrank.com/challenges/equal/problem
object Solution {
  def cost(num: Int): Int = num / 5 + num % 5 / 2 + num % 5 % 2
  def calc(list: List[Int]) = {
    val min = list.min
    def pass(i: Int) =  list.map(_ - min + i).map(cost).sum
    (0 until 5).map(pass).min
  }

  def main(args: Array[String]) {
    val scanner = new java.util.Scanner(System.in)

    0 until scanner.nextInt foreach { t =>
      System.out.println(calc(List.fill(scanner.nextInt) { scanner.nextInt }))
    }
  }
}
