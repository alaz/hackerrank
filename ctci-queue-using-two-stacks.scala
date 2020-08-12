/*
https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks
*/
case class Queue(accepting: List[Long], returning: List[Long]) {
  def put(i: Long) = Queue(i :: accepting, returning)

  def pop(fn: Long => Unit): Queue = returning match {
    case Nil =>
      Queue(Nil, reverse).pop(fn)
    case i :: xs =>
      fn(i)
      Queue(accepting, xs)
  }

  def peek(fn: Long => Unit): Queue = returning match {
    case Nil =>
      Queue(Nil, reverse).peek(fn)
    case i :: xs =>
      fn(i)
      Queue(accepting, returning)
  }

  protected def reverse =
    accepting.foldLeft(List.empty[Long]) { case (acc, i) => i :: acc }
}

object Queue {
  def empty = Queue(Nil, Nil)
}

object Solution {
  import java.util.Scanner

  sealed trait Command
  case class Put(i: Long) extends Command
  case object Pop extends Command
  case object Peek extends Command

  def main(args: Array[String]): Unit = {
    val scanner = new Scanner(System.in)

    Iterator
      .fill(scanner.nextInt) {
        scanner.next match {
          case "1" => Put(scanner.nextLong)
          case "2" => Pop
          case "3" => Peek
        }
      }
      .foldLeft(Queue.empty) {
        case (queue, Put(i)) => queue.put(i)
        case (queue, Pop)    => queue.pop(identity)
        case (queue, Peek)   => queue.peek(System.out.println)
      }
  }
}
