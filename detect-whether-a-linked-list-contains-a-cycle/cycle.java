/*
https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle

Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
  if (head == null)
    return false;

  Integer power = 2, length = 0;
  Node tortoise = head, hare = head;

  while (hare.next != null) {
    hare = hare.next;
    length ++;

    if (tortoise.equals(hare))
      return true;

    if (power == length) {
      tortoise = hare;
      power *= 2;
      length = 0;
    }
  }

  return false;
}
